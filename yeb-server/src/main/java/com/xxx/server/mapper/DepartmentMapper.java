package com.xxx.server.mapper;

import com.xxx.server.pojo.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.server.pojo.ResponseBean;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> getAllDepartments(Integer parentId);

    ResponseBean addDep(Department dep);

    ResponseBean deleteDep(Department dep);
}
