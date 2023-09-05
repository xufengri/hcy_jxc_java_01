package org.example.controller;

import org.example.constant.MessageConstant;
import org.example.constant.StatusConstant;
import org.example.dto.AddGoodDto;
import org.example.dto.GoodsPageDto;
import org.example.result.PageResult;
import org.example.result.Result;
import org.example.service.GoodsService;
import org.example.vo.CommonVo;
import org.example.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName GoodsServiceController
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 11:46
 * @Version 1.0
 **/
@RestController
@RequestMapping("/goods")
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
    public Result getGoods(GoodsPageDto goodsPageDto) {
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
    public Result addGood(@Validated  @RequestBody AddGoodDto addGoodDto) {
        CommonVo commonVo = goodsService.addGood(addGoodDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, commonVo);
    }

}
