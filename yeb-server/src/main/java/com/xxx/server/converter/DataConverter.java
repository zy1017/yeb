package com.xxx.server.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 全局日期转换
 *
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.converter
 * @Author: zuoyu
 * @CreateTime: 2022-11-01  12:59
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class DataConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String source) {
        try {
            return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
