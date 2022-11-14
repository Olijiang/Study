import blog.blogApplication;
import blog.entity.Article;
import blog.entity.Tag;
import blog.mapper.ArticleMapper;
import blog.mapper.TagMapper;
import blog.utils.myUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/10/28 13:58
 */
@SpringBootTest(classes = blogApplication.class)
public class demo {

	@Resource
	private TagMapper tagMapper;
	@Resource
	private ArticleMapper articleMapper;


	@Test
	public void tag(){
		String id = "2020";
		String[] newTags = {"java","test"};
		// 获取作者的tag库
		Tag tag = tagMapper.selectById(id);
		JSONArray jsonArray = (JSONArray) JSON.parseObject(tag.getTags()).get("tags");
		// 遍历
		ArrayList<String > list = new ArrayList<>();
		jsonArray.forEach((object)->{
			list.add(object.toString());
		});
		String[] rawTags =  list.toArray(new String[0]);
		JSONObject newTag = new JSONObject();
		newTag.put("tags", myUtil.union(rawTags, newTags));
		System.out.println(newTag);
	}
	@Test
	public void demo2() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US); // 格式化时间
		System.out.println(dtf.format(LocalDateTime.now()));
	}

	@Test
	public void demo3(){
		String articleId = "2020";
		int startPage = 2;
		int pageSize = 4;
		List<Article> articles = articleMapper.getArticleList(articleId,startPage,pageSize);
		articles.forEach((e)->{
			System.out.println(e.getId());
		});
	}
}
