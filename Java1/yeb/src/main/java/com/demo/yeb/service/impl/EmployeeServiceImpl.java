package com.demo.yeb.service.impl;

import com.demo.yeb.entity.Employee;
import com.demo.yeb.mapper.EmployeeMapper;
import com.demo.yeb.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
