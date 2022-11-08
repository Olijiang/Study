package blog.controller;


import blog.config.ComResult;
import blog.entity.Article;
import blog.mapper.ArticleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZGB
 * @since 2022-11-06
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

	@Resource
	private ArticleMapper articleMapper;

	@RequestMapping("/getList")
	public ComResult getArticles(String username, Integer startPage, Integer pageSize){
		
		List<Article> list = new ArrayList<>();
		QueryWrapper<Article> wrapper=new QueryWrapper<>();
		if (username.equals("")) username="2020";
		wrapper.eq("author_id",username);
		Page<Article> page = new Page<>(startPage, pageSize);
		List<Article> articles = page.getRecords();
		return ComResult.success(articles);
	}


}
