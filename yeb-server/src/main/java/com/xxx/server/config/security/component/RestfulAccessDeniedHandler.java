package com.xxx.server.config.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxx.server.pojo.ResponseBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.config.security
 * @Author: zuoyu
 * @CreateTime: 2022-08-14  20:59
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ResponseBean bean = ResponseBean.error("权限不足，请联系管理员");
        bean.setCode(403);
        out.write(new ObjectMapper().writer().writeValueAsString(bean));
        out.flush();
        out.close();

    }
}
