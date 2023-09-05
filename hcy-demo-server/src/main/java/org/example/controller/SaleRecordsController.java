package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.constant.MessageConstant;
import org.example.constant.StatusConstant;
import org.example.dto.SaleRecordsPageDto;
import org.example.entity.SaleRecords;
import org.example.result.PageResult;
import org.example.result.Result;
import org.example.service.SaleRecordsService;
import org.example.vo.SaleRecordsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SaleRecordsController
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/4 12:34
 * @Version 1.0
 **/
@RestController
@RequestMapping("/order/getSaleRecords")
@Api(tags = "零售记录接口")
public class SaleRecordsController {

    @Autowired
    private SaleRecordsService saleRecordsService;

    /**
     * 查询实体店销售记录列表
     */
    @GetMapping("/list")
    @ApiOperation("查询实体店销售记录列表")
    public Result getSaleRecordsList() {
        List list = saleRecordsService.getSaleRecordsList();
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS,list);
    }

    /**
     * 分页条件查询
     * @return
     */
    @GetMapping
    @ApiOperation("分页条件查询")
    public Result getSaleRecordsPage(@Validated  SaleRecordsPageDto saleRecordsPageDto){
        PageResult<SaleRecordsVo> pageResult = saleRecordsService.getSaleRecordsPage(saleRecordsPageDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS,pageResult);
    }
}
