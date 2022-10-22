package com.demo.yeb.service.impl;

import com.demo.yeb.entity.Department;
import com.demo.yeb.mapper.DepartmentMapper;
import com.demo.yeb.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
