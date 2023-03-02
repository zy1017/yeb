package com.xxx.server.controller;


import com.xxx.server.pojo.AdminRole;
import com.xxx.server.pojo.ResponseBean;
import com.xxx.server.service.IAdminRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/admin-role")
public class AdminRoleController {

    @Autowired
    private IAdminRoleService adminRoleService;

    @ApiOperation("查询所有操作员角色")
    @GetMapping("/")
    public List<AdminRole> getAllAdminRole() {
        return adminRoleService.list();
    }

    @ApiOperation("更新操作员角色")
    @PutMapping("/")
    @Transactional
    public ResponseBean updateAdminRole(Integer id, Integer[] rids) {
        adminRoleService.removeById(id);
        Integer result = adminRoleService.addAdminRole(id, rids);
        if (result == rids.length) {
            return ResponseBean.success("更新操作员成功");
        }
        return ResponseBean.error("更新操作员失败");
    }
}
