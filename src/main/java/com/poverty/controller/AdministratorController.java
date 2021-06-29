package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.service.AdministratorService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 16:30
 */
@RestController
@RequiresRoles(value = {"administrator"})
@RequestMapping("/admin")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class AdministratorController {

    @Resource
    public AdministratorService administratorService;

    /**
     * 通过用户id设置管理员
     *
     * @param id JSON{"id":"用户id"}
     * @return Result
     */
    @PostMapping("/setAdmin")
    public Result setAdmin(@RequestBody PostId id) {
        return administratorService.setAdmin(id);
    }

    /**
     * 通过用户id取消管理员
     *
     * @param id JSON{"id":"用户id"}
     * @return Result
     */
    @PostMapping("/setUser")
    public Result setUser(@RequestBody PostId id) {
        return administratorService.setUser(id);
    }

    /**
     * 获取管理员账号列表
     *
     * @param current 当前页数
     * @param size 每页几条数据
     * @return Result
     */
    @GetMapping("/getAdmin/{current}/{size}")
    public Result getAdmin(@PathVariable int current,@PathVariable int size) {
        return administratorService.getAdmin(current, size);
    }
}
