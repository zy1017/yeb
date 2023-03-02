package com.xxx.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 分页返回对象
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.pojo
 * @Author: zuoyu
 * @CreateTime: 2022-11-01  12:55
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePageBean {
    /**
     * 总行数
    */
    private Long total;
    /**
     * 数据List
     */
    private List<?> data;
}
