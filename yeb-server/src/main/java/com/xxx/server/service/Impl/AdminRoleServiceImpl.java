package com.xxx.server.service.Impl;

import com.xxx.server.pojo.AdminRole;
import com.xxx.server.mapper.AdminRoleMapper;
import com.xxx.server.service.IAdminRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements IAdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public Integer addAdminRole(Integer id, Integer[] rids) {
        return adminRoleMapper.addAdminRole(id, rids);
    }
}
