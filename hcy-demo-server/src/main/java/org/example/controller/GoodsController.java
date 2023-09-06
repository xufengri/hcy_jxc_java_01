package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.constant.MessageConstant;
import org.example.constant.StatusConstant;
import org.example.dto.AddGoodDto;
import org.example.dto.GoodsPageDto;
import org.example.dto.UpStatusDto;
import org.example.dto.UpdateGoodDto;
import org.example.result.PageResult;
import org.example.result.Result;
import org.example.service.GoodsService;
import org.example.vo.CommonVo;
import org.example.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @ClassName GoodsServiceController
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 11:46
 * @Version 1.0
 **/
@RestController
@RequestMapping("/goods")
@Api(tags = "货物相关接口")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 货物分页查询
     *
     * @param goodsPageDto
     * @return
     */
    @GetMapping("/getGoods")
    @ApiOperation("货物分页查询")
    public Result getGoods(@Validated GoodsPageDto goodsPageDto) {
        PageResult<GoodsVo> pageResult = goodsService.getGoods(goodsPageDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, pageResult);
    }

    /**
     * 添加货物
     *
     * @param addGoodDto
     * @return
     */
    @PostMapping("/addGood")
    @ApiOperation("添加货物")
    public Result addGood(@RequestBody  @Validated AddGoodDto addGoodDto) {
        CommonVo commonVo = goodsService.addGood(addGoodDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, commonVo);
    }

    /**
     * 货物上下架
     *
     * @param upStatusDto
     * @return
     */
    @PutMapping("/upStatus")
    @ApiOperation("货物上下架")
    public Result upStatus(@Validated @RequestBody UpStatusDto upStatusDto) {
        CommonVo commonVo = goodsService.upStatus(upStatusDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, commonVo);
    }

    /**
     * 编辑
     *
     * @param updateGoodDto
     * @return
     */
    @PutMapping("/updateGood")
    @ApiOperation("编辑")
    public Result updateGood(@Validated @RequestBody UpdateGoodDto updateGoodDto) {
        CommonVo commonVo = goodsService.updateGood(updateGoodDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, commonVo);
    }

    /**
     * 删除货物
     * @param goodId
     * @return
     */
    @DeleteMapping("/delGood/{goodId}")
    @ApiOperation("删除货物")
    public Result delGood(@NotNull @PathVariable("goodId") Integer goodId) {
        CommonVo commonVo = goodsService.delGood(goodId);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, commonVo);
    }
}
