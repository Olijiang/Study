package com.demo.yeb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.yeb.entity.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZGB
 * @since 2022-10-20
 */

@Component
public interface AdminMapper extends BaseMapper<Admin> {

	@Select("select * from t_admin where username = #{username}")
	Admin getByUsername(String username);
}
