package com.xxx.server.controller;


import com.xxx.server.pojo.Department;
import com.xxx.server.pojo.ResponseBean;
import com.xxx.server.service.IDepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
@RestController
@RequestMapping("system/basic/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @ApiOperation("获取所有部门")
    @GetMapping("/")
    public List<Department> getAllDepartments(Integer parentId) {
        return departmentService.getAllDepartments(parentId);
    }

    @ApiOperation("/添加部门")
    @PostMapping("/")
    public ResponseBean addDep(@RequestBody Department dep) {
        return departmentService.addDep(dep);
    }

    @ApiOperation("/删除部门")
    @DeleteMapping("/{id}")
    public ResponseBean deleteDep(@PathVariable Integer id){
        return departmentService.deleteDep(id);
    }


}
