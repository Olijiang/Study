package com.demo.yeb.service.impl;

import com.demo.yeb.entity.Admin;
import com.demo.yeb.mapper.AdminMapper;
import com.demo.yeb.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZGB
 * @since 2022-10-20
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {


}
