package com.xxx.server.mapper;

import com.xxx.server.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 更新角色菜单
     * @param  rid
     * @param mids
     */
    Integer insertRecord(Integer rid,Integer [] mids);
}
