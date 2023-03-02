package com.xxx.server.service;

import com.xxx.server.pojo.AdminRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
public interface IAdminRoleService extends IService<AdminRole> {

    Integer addAdminRole(Integer id, Integer[] rids);
}
