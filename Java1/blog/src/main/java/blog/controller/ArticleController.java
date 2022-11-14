package blog.controller;


import blog.config.ComResult;
import blog.entity.Article;
import blog.entity.ArticleDTO;
import blog.mapper.ArticleMapper;
import blog.service.ArticleServiceImpl;
import blog.utils.JwtUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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
	private ArticleServiceImpl articleService;
	@Resource
	private ArticleMapper articleMapper;

	@ApiOperation("添加文章")
	@PostMapping("/add")
	public ComResult addArticle(@RequestBody ArticleDTO articleDTO,@RequestHeader("token") String token) {
		String authorId = Objects.requireNonNull(JwtUtil.getUserFromToken(token)).getUsername();
		return articleService.addArticle(articleDTO, authorId);
	}

	@ApiOperation("获取文章列表")
	@GetMapping("/getArticleList")
	public ComResult getArticleList(@RequestHeader("token") String token ,Integer startPage, Integer pageSize) {
		String authorId = Objects.requireNonNull(JwtUtil.getUserFromToken(token)).getUsername();
		QueryWrapper<Article> wrapper=new QueryWrapper<>();
		wrapper.eq("author_id",authorId);
		Page<Article> page = new Page<>(startPage, pageSize);
		articleMapper.selectPage(page, wrapper);
		List<Article> articles = page.getRecords();
		return ComResult.success(articles);
	}



}
