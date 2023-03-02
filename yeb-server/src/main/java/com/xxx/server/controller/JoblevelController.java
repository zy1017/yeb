package com.xxx.server.controller;

import com.xxx.server.pojo.Joblevel;
import com.xxx.server.pojo.ResponseBean;
import com.xxx.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: yeb
 * @BelongsPackage: com.xxx.server.controller
 * @Author: zuoyu
 * @CreateTime: 2022-10-20  17:49
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/")
    public List<Joblevel> getAllJobLevels() {
        return joblevelService.list();
    }

    @ApiOperation("添加职位")
    @PostMapping("/")
    public ResponseBean addJoblevel(@RequestBody Joblevel joblevel) {
        joblevel.setCreateDate(LocalDateTime.now());
        if (joblevelService.save(joblevel)) {
            return ResponseBean.success("添加职位成功");
        }
        return ResponseBean.error("添加职位失败");
    }

    @ApiOperation("更新职位")
    @PutMapping("/")
    public ResponseBean updateJoblevel(@RequestBody Joblevel joblevel) {
        if (joblevelService.updateById(joblevel)) {
            return ResponseBean.success("更新职位成功");
        }
        return ResponseBean.error("更新职位失败");
    }

    @ApiOperation(("删除职位"))
    @DeleteMapping("/{id}")
    public ResponseBean deleteJoblevel(@PathVariable Integer id) {
        if (joblevelService.removeById(id)) {
            return ResponseBean.success("删除职位成功");
        }
        return ResponseBean.error("删除职位失败");
    }

    @ApiOperation(("批量删除职位"))
    @DeleteMapping("/")
    public ResponseBean deleteJoblevelsByIds(Integer[] ids) {
        if (joblevelService.removeByIds(Arrays.asList(ids))){
            return ResponseBean.success("批量删除成功");
        }
        return ResponseBean.error("批量删除失败");
    }
}
