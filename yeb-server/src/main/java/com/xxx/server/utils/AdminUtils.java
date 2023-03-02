package com.xxx.server.utils;

import com.xxx.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;
import springfox.documentation.spi.service.contexts.SecurityContext;

/**
 * 操作员工工具类
 *
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.utils
 * @Author: zuoyu
 * @CreateTime: 2022-10-31  18:53
 * @Description: TODO
 * @Version: 1.0
 */
public class AdminUtils {

    /**
     * 获取当前登录操作员
     * @return Admin
     */
    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }
}
