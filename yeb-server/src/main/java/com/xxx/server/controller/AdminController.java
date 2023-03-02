package com.xxx.server.controller;


import com.xxx.server.pojo.Admin;
import com.xxx.server.pojo.ResponseBean;
import com.xxx.server.service.IAdminService;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation("获取所有操作员")
    @GetMapping("/")
    public List<Admin> getAllAdmins(String keywords) {
        return adminService.getAllAdmins(keywords);
    }

    @ApiOperation("更新操作员")
    @PutMapping("/")
    public ResponseBean updateAdmin(@RequestBody Admin admin){
        if (adminService.updateById(admin)){
            return ResponseBean.success("更新操作员成功");
        }
        return ResponseBean.error("更新操作员失败");
    }

    @ApiOperation("删除操作员")
    @DeleteMapping("/{id}")
    public ResponseBean deleteAdmin(@PathVariable Integer id){
        if (adminService.removeById(id)){
            return ResponseBean.success("删除操作员成功");
        }
        return ResponseBean.error("删除操作员失败");
    }
}
