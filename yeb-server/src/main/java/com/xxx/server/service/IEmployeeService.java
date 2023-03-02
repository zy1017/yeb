package com.xxx.server.service;

import com.xxx.server.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.ResponseBean;
import com.xxx.server.pojo.ResponsePageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
public interface IEmployeeService extends IService<Employee> {

    ResponsePageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取最大工号
     * @return
     */
    ResponseBean maxWorkId();

    ResponseBean addEmp(Employee employee);

    List<Employee> getEmployee(Integer id);
}
