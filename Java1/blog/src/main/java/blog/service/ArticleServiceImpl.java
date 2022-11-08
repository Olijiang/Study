package blog.service;

import blog.entity.Article;
import blog.mapper.ArticleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZGB
 * @since 2022-11-06
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>{

}
