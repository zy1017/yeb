package com.xxx.server.controller;


import com.xxx.server.pojo.PoliticsStatus;
import com.xxx.server.pojo.ResponseBean;
import com.xxx.server.service.IPoliticsStatusService;
import com.xxx.server.service.IPositionService;
import com.xxx.server.service.Impl.PositionServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zy
 * @since 2022-07-29
 */
@RestController
@RequestMapping("/system/basic/politicsStatus")
public class PoliticsStatusController {

    @Autowired
    private IPoliticsStatusService politicsStatusService;

    @ApiOperation(value = "获取所有政治面貌")
    @GetMapping("/")
    public List<PoliticsStatus> getAllPoliticsStatus(){
        return politicsStatusService.list();
    }

}
