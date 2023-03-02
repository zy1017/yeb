package com.xxx.server.mapper;

import com.xxx.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
public interface AdminMapper extends BaseMapper<Admin> {

    List<Admin> getAllAdmins(Integer id, String keywords);
}
