package eva.rabbitmq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import eva.rabbitmq.entity.DaxingTraffic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZGB
 * @since 2022-11-07
 */
@Component
@Mapper
public interface DaxingTrafficMapper extends BaseMapper<DaxingTraffic> {

}
