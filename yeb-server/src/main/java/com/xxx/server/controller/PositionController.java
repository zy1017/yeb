package com.xxx.server.controller;


import com.xxx.server.pojo.Position;
import com.xxx.server.pojo.ResponseBean;
import com.xxx.server.service.IPositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
@RequestMapping("/system/config/pos")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @ApiOperation("获取所有职位信息")
    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.list();
    }

    ;

    @ApiOperation(("新增职位信息"))
    @PostMapping("/")
    public ResponseBean addPosition(@RequestBody Position position) {
        if (positionService.save(position)) {
            return ResponseBean.success("添加成功");
        }
        return ResponseBean.error("添加失败");
    }

    @ApiOperation("更新职位信息")
    @PutMapping("/")
    public ResponseBean updatePosition(@RequestBody Position position) {
        if (positionService.updateById(position)) {
            return ResponseBean.success("更新成功");
        }
        return ResponseBean.error("更新失败");
    }

    @ApiOperation("删除职位信息")
    @DeleteMapping("/{id}")
    public ResponseBean deletePosition(@PathVariable Integer id) {
        if (positionService.removeById(id)) {
            return ResponseBean.success("删除成功");
        }
        return ResponseBean.error("删除失败");
    }

    @ApiOperation("批量删除职位信息")
    @DeleteMapping("/")
    public ResponseBean deletePositionByIds(Integer[] ids) {

        if (positionService.removeByIds(Arrays.asList(ids))){
            return ResponseBean.success("批量删除成功");
        }
        return ResponseBean.error("批量删除失败");
    }
}
