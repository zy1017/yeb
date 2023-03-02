package com.xxx.server.service.Impl;

import com.xxx.server.pojo.Department;
import com.xxx.server.mapper.DepartmentMapper;
import com.xxx.server.pojo.ResponseBean;
import com.xxx.server.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取所有部门
     *
     * @return
     * @author zy
     */
    @Override
    public List<Department> getAllDepartments(Integer parentId) {
        return departmentMapper.getAllDepartments(parentId);
    }

    @Override
    public ResponseBean addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
        if (dep.getResult() == 1) {
            return ResponseBean.success("添加部门成功");
        }
        return ResponseBean.error("添加部门失败");
    }

    @Override
    public ResponseBean deleteDep(Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentMapper.deleteDep(dep);
        if (dep.getResult() == 1) {
            return ResponseBean.success("删除部门成功");
        }
        return ResponseBean.error("删除部门失败");
    }
}
