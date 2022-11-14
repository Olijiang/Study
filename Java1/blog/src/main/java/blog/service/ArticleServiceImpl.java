package blog.service;

import blog.config.ComResult;
import blog.config.LocalCatch;
import blog.entity.Article;
import blog.entity.ArticleDTO;
import blog.entity.Category;
import blog.entity.Tag;
import blog.mapper.ArticleMapper;
import blog.mapper.CategoryMapper;
import blog.mapper.TagMapper;
import blog.utils.myUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZGB
 * @since 2022-11-06
 */
@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>{

	private static final String dataPath = "blogData";
	private static final String imgPath = "imgs";
	private static final String articlePath = "articles";

	@Resource
	private CategoryMapper categoryMapper;
	@Resource
	private ArticleMapper articleMapper;
	@Resource
	private TagMapper tagMapper;

	public ComResult getArticleContent(String fileName){
		String article;
		if ((article = (String) LocalCatch.get(fileName))==null){
			log.info("缓存未命中content："+fileName);
			article = getContent(fileName);
			if (article.equals("")){
				return ComResult.error("获取文章内容失败",article);
			}
			LocalCatch.put(fileName,article);
			return ComResult.success("获取文章内容成功",article);
		}
		log.info("缓存命中content："+fileName);
		return ComResult.success("获取文章内容成功",article);
	}

	public ComResult getArticleList(String articleId,int startPage, int pageSize) {
		List<Article> articles;
		String key = "articleList" + "-" + articleId + "-" + startPage + "-" + pageSize;
		if ((articles = (List<Article>) LocalCatch.get(key)) == null) {
			log.info("缓存未命中article：" + key);
			try {
				articles = articleMapper.getArticleList(articleId,startPage,pageSize);
				LocalCatch.put(key, articles);
				return ComResult.success("获取文章列表成功", articles);
			} catch (Exception e) {
				log.warn("获取文章列表失败" + e);
				return ComResult.error("获取文章列表失败");
			}
		}
		//  缓存命中
		log.info("缓存命中article：" + key);
		return ComResult.success("获取文章列表成功", articles);
	}
	public ComResult getArticleById(String articleId){
		Article article;
		String key = "article" + "-" + articleId;
		if ((article = (Article) LocalCatch.get(key))==null){
			log.info("缓存未命中article："+articleId);
			try {
				article = articleMapper.selectById(articleId);
				LocalCatch.put(key,article);
				return ComResult.success("获取文章成功",article);
			}catch (Exception e){
				log.warn("获取文章失败" + e);
				return ComResult.success("获取文章失败");
			}
		}
		log.info("缓存命中article：" + key);
		return ComResult.success("获取文章成功",article);
	}


	public ComResult addArticle(ArticleDTO articleDTO, String authorId) {
		Article article = new Article();
		// 图片
//		System.out.println(articleDTO);
		String imgPath = saveImg(articleDTO.getImg(),authorId);
		if (imgPath.equals("")){
			return ComResult.error("文章发表失败, 原因：插图");
		}
		article.setImg(imgPath);
		// 文章
		String articlePath = saveContent(articleDTO.getContent(),authorId);
		if (articlePath.equals("")){
			return ComResult.error("文章发表失败, 原因：文章内容");
		}
		article.setContent(articlePath);
		// title
		article.setTitle(articleDTO.getTitle());
		// category
		article.setCategory(articleDTO.getCategory());
		// 刷新作者的 category 库
		String[] rawCategory = getCategory(authorId);
		String[] thisCategory = {articleDTO.getCategory()};
		String[] newCategory = myUtil.union(rawCategory, thisCategory);
		setCategory(authorId, newCategory);

		// 刷新作者的 tag 库
		String[] rawTag = getTag(authorId);
		String[] thisTag = articleDTO.getTag();
		String[] newTag = myUtil.union(rawTag, thisTag);
		setTag(authorId, newTag);
		// 设置 本文章的 tag
		JSONObject thisTagJson = new JSONObject();
		thisTagJson.put("tags", thisTag);
		article.setTag(thisTagJson.toJSONString());
		// authorId
		article.setAuthorId(authorId);
		//digest
		if (articleDTO.getContent().length()>180){
			article.setDigest(articleDTO.getContent().substring(0,180)+"...");
		}else {
			article.setDigest(articleDTO.getContent());
		}

		//CreatTime
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US); // 格式化时间
		String date = dtf.format(LocalDateTime.now());
		article.setCreateTime(date);
		//updateTime
		article.setUpdateTime(date);
		log.info("成功添加新文章:"+article.getTitle());
		articleMapper.insert(article);
		return ComResult.success("添加成功");
	}

	public ComResult getCategoryById(String authorId){
		String[] categories;
		String key = "category"+authorId;
		if ((categories = (String[]) LocalCatch.get(key))==null){
			log.info("缓存未命中category："+key);
			categories = getCategory(authorId);
			LocalCatch.put(key,categories);
		}
		log.info("缓存命中category："+key);
		return ComResult.success("获取分类成功",categories);
	}

	public ComResult getTagsById(String authorId){
		String[] tags = getTag(authorId);
		return ComResult.success("获取标签成功",tags);
	}


	/**
	 * @description: 以下部分为内部封装的方法 方便操作  private
	 */
	//保存错误时返回空字符串,  成功返回相对路径
	private String saveContent(String contentData,String authorId) {
		String projectParentPath = myUtil.getProjectParentPath();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS", Locale.US); // 格式化时间
		String date = dtf.format(LocalDateTime.now());
		// 文件名
		String fileName = date + "_" + authorId+".txt";
		String storagePath = projectParentPath + dataPath + File.separator + articlePath + File.separator + fileName;
		String relativePath = articlePath + File.separator + fileName;
		if (myUtil.writeTxt(contentData, storagePath)){
			log.info("文章保存成功");
			return relativePath;
		}else {
			log.warn("文章保存失败");
			return "";
		}
	}

	//读取错误时返回空字符串
	private String getContent(String fileName) {
		String projectParentPath = myUtil.getProjectParentPath();
		String storagePath = projectParentPath + dataPath + File.separator + articlePath + File.separator + fileName;
		return myUtil.readTxt(storagePath);
	}

	private String saveImg(String imgData, String authorId){
		String projectParentPath = myUtil.getProjectParentPath();
		// 截取图片信息
		String[] info = imgData.split(";base64,");
		// 截取图片文件后缀
		String fileSuffix = info[0].substring(11);
		// 图片数据
		String base64ImgData = info[1];
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS", Locale.US); // 格式化时间
		String date = dtf.format(LocalDateTime.now());
		// 文件名
		String fileName = date + "_" + authorId + "." + fileSuffix;
		String storagePath = projectParentPath + dataPath + File.separator +imgPath + File.separator + fileName;
		// relativePath src链接直接请求数据，需要加static资源映射
		String relativePath = "static" + File.separator + imgPath + File.separator + fileName;
		if (myUtil.writeBase64Img(base64ImgData, storagePath)){
			log.info("图片保存成功");
			return relativePath;
		}else {
			log.warn("图片保存失败");
			return "";
		}
	}

	private String[] getCategory(String authorId) {
		Category category = categoryMapper.selectById(authorId);
		JSONArray jsonArray = (JSONArray) JSON.parseObject(category.getCategories()).get("categories");
		return jsonToArray(jsonArray);
	}

	private void setCategory(String authorId, String[] categories) {
		Category category = new Category();
		category.setAuthorId(authorId);
		JSONObject newCategory = new JSONObject();
		newCategory.put("categories", categories);
		category.setCategories(newCategory.toJSONString());
		categoryMapper.updateById(category);
	}


	// 根据author 获取 tag 数据
	private String[] getTag(String authorId){
		Tag tag = tagMapper.selectById(authorId);
		JSONArray jsonArray = (JSONArray) JSON.parseObject(tag.getTags()).get("tags");
		return jsonToArray(jsonArray);
	}
	// 根据author 重写 tag 数据
	private void setTag(String authorId, String[] tags){
		Tag tag = new Tag();
		tag.setAuthorId(authorId);
		JSONObject newTag = new JSONObject();
		newTag.put("tags", tags);
		tag.setTags(newTag.toJSONString());
		tagMapper.updateById(tag);
	}
	private String[] jsonToArray(JSONArray jsonArray){
		ArrayList<String > list = new ArrayList<>();
		jsonArray.forEach((object)->{
			list.add(object.toString());
		});
		return list.toArray(new String[0]);
	}

}
