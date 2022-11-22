package blog.service;

import blog.config.ComResult;
import blog.entity.Image;
import blog.entity.ArticleDTO;
import blog.mapper.AlbumMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZGB
 * @since 2022-11-18
 */
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Image> {

	public ComResult addPhoto(ArticleDTO articleDTO, String authorId) {
		return ComResult.success();
	}
}
