package com.xxx.server.service;

import com.xxx.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.ResponseBean;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
public interface IMenuRoleService extends IService<MenuRole> {

    public ResponseBean updateMenuRole(Integer rid, Integer[] mids);
}
