package com.xxx.server.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.mapper.EmployeeMapper;
import com.xxx.server.pojo.Employee;
import com.xxx.server.pojo.EmployeeEc;
import com.xxx.server.mapper.EmployeeEcMapper;
import com.xxx.server.pojo.ResponsePageBean;
import com.xxx.server.service.IEmployeeEcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
@Service
public class EmployeeEcServiceImpl extends ServiceImpl<EmployeeEcMapper, EmployeeEc> implements IEmployeeEcService {


}
