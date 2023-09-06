package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.constant.MessageConstant;
import org.example.constant.StatusConstant;
import org.example.dto.GetInventoryDto;
import org.example.dto.OutGoodsDto;
import org.example.dto.UserPageDto;
import org.example.entity.User;
import org.example.result.PageResult;
import org.example.result.Result;
import org.example.service.UserService;
import org.example.vo.CommonVo;
import org.example.vo.GetInventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/6 10:38
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
@Api(tags = "库存管理相关接口")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getUsers")
    @ApiOperation("库存分页查询")
    public Result getUsers(@Validated UserPageDto userPageDto) {
        PageResult<User> pageResult = userService.getUsers(userPageDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, pageResult);
    }

    @GetMapping("/getInventory")
    @ApiOperation("查看库存")
    public Result getInventory(@Validated GetInventoryDto getInventoryDto) {
        PageResult<GetInventoryVo> pageResult = userService.getInventory(getInventoryDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, pageResult);
    }

    @PutMapping("/outGoods")
    @ApiOperation("出库")
    public Result outGoods(@RequestBody @Validated OutGoodsDto outGoodsDto) {
         CommonVo commonVo = userService.outGoods(outGoodsDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, commonVo);
    }
}
