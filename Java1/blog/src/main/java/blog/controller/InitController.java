package blog.controller;

import blog.config.ComResult;
import blog.service.ArticleServiceImpl;
import blog.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/8 11:14
 */
@Api("处理初始化请求和无需权限的请求")
@RestController
@RequestMapping("/init")
public class InitController {

	@Resource
	private UserServiceImpl userService;
	@Resource
	private ArticleServiceImpl articleService;

	@ApiOperation("初始化时获取作者信息")
	@GetMapping("/author")
	public ComResult author(String authorId){
		return userService.getUser(authorId);
	}

	@GetMapping("/category")
	public ComResult category(String authorId){
		return articleService.getCategoryById(authorId);
	}
	@GetMapping("/tags")
	public ComResult tags(String authorId){
		return articleService.getTagsById(authorId);
	}

	@ApiOperation("初始化时获取文章信息")
	@GetMapping("/getArticleList")
	public ComResult getArticleList(String authorId, int startPage, int pageSize){
		return articleService.getArticleList(authorId, startPage, pageSize);
	}

	@ApiOperation("根据文章id获取文章信息")
	@GetMapping("/getArticle")
	public ComResult getArticleById(String ArticleId){
		return articleService.getArticleById(ArticleId);
	}

	@ApiOperation("获取文章内容")
	@GetMapping("/getContent")
	public ComResult getContent(String fileName){
		return articleService.getArticleContent(fileName);
	}

}
