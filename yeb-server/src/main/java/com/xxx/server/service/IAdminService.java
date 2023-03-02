package com.xxx.server.service;

import com.xxx.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.ResponseBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录之后返回Token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    ResponseBean login(String username, String password, String code, HttpServletRequest request);

    Admin getAdminByUserName(String username);

    List<Admin> getAllAdmins(String keywords);
}
