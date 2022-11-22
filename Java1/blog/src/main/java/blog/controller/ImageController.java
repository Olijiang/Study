package blog.controller;


import blog.config.ComResult;
import blog.entity.ArticleDTO;
import blog.service.ImageServiceImpl;
import blog.utils.JwtUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZGB
 * @since 2022-11-18
 */
@RestController
@RequestMapping("/album")
public class AlbumController {

	@Resource
	private ImageServiceImpl albumService;

	@ApiOperation("添加相片")
	@PostMapping("/add")
	public ComResult addPhoto(@RequestBody ArticleDTO articleDTO, @RequestHeader("token") String token) {
		String authorId = Objects.requireNonNull(JwtUtil.getUserFromToken(token)).getUsername();
		return albumService.addPhoto(articleDTO, authorId);
	}
}
