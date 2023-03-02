package com.xxx.server.exception;

import com.xxx.server.pojo.ResponseBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 *
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.exception
 * @Author: zuoyu
 * @CreateTime: 2022-10-19  18:34
 * @Description: TODO
 * @Version: 1.0
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public ResponseBean mySqlException(SQLException ex){
        if (ex instanceof SQLIntegrityConstraintViolationException){
            return ResponseBean.error("该数据有关联数据,操作失败！");
        }
        return ResponseBean.error("数据库异常,操作失败");
    }
}
