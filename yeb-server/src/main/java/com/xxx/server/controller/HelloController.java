package com.xxx.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.controller
 * @Author: zuoyu
 * @CreateTime: 2022-08-14  22:39
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
