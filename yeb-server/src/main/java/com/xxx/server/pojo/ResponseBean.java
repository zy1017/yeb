package com.xxx.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 *
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.pojo
 * @Author: zuoyu
 * @CreateTime: 2022-07-29  22:12
 * @Description: TODO
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     *
     * @param message
     * @return
     */
    public static ResponseBean success(String message) {
        return new ResponseBean(200, message, null);
    }

    /**
     * 成功返回结果
     *
     * @param message
     * @param obj
     * @return
     */
    public static ResponseBean success(String message, Object obj) {
        return new ResponseBean(200, message, obj);
    }

    /**
     * 失败返回结果
     *
     * @param message
     * @return
     */
    public static ResponseBean error(String message) {
        return new ResponseBean(500, message, null);
    }

    /**
     * 失败返回结果
     * @param message
     * @param obj
     * @return
     */
    public static ResponseBean error(String message, Object obj) {
        return new ResponseBean(500, message, obj);
    }
}
