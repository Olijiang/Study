package eva.kafka.service.impl;

import eva.kafka.entity.TaxiTrans;
import eva.kafka.mapper.TaxiTransMapper;
import eva.kafka.service.ITaxiTransService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZGB
 * @since 2022-11-02
 */
@Service
public class TaxiTransServiceImpl extends ServiceImpl<TaxiTransMapper, TaxiTrans> implements ITaxiTransService {

}
