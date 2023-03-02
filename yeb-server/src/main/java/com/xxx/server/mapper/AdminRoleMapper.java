package com.xxx.server.mapper;

import com.xxx.server.pojo.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    Integer addAdminRole(Integer id, Integer[] rids);
}
