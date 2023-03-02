package com.xxx.server.service;

import com.xxx.server.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.ResponseBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
public interface IDepartmentService extends IService<Department> {

    List<Department> getAllDepartments(Integer parentId);

    ResponseBean addDep(Department dep);

    ResponseBean deleteDep(Integer id);
}
