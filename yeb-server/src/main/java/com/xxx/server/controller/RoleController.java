package com.xxx.server.controller;


import com.xxx.server.pojo.ResponseBean;
import com.xxx.server.pojo.Role;
import com.xxx.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
@RestController
@RequestMapping("system/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation("查询所有角色信息")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation("新增角色信息")
    @PostMapping("/")
    public ResponseBean addRole(@RequestBody Role role){
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if (roleService.save(role)){
            return ResponseBean.success("新增角色成功");
        }
        return ResponseBean.error("新增角色失败");
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/role/{id}")
    public ResponseBean deleteRole(@PathVariable Integer id){
        if (roleService.removeById(id)){
            ResponseBean.success("角色删除成功");
        }
        return ResponseBean.error("角色删除失败");
    }
}
