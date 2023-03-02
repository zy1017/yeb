package com.xxx.server.controller;


import com.xxx.server.pojo.Nation;
import com.xxx.server.service.INationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
@RestController
@RequestMapping("/system/basic/nation")
public class NationController {

    @Autowired
    private INationService nationService;

    @ApiOperation(value = "获取所有民族")
    @GetMapping("/")
    public List<Nation> getAllNation() {
        return nationService.list();
    }

}
