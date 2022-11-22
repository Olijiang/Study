import blog.blogApplication;
import blog.config.PathConfig;
import blog.mapper.AlbumMapper;
import blog.service.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/10/28 13:58
 */
@SpringBootTest(classes = blogApplication.class)
public class demo {

	@Resource
	private ArticleServiceImpl articleService;
	@Resource
	private PathConfig athConfig;
	@Resource
	private AlbumMapper albumMapper;

	@Test
	public void tag(){
		System.out.println(albumMapper.getAlbums("123"));
	}





}
