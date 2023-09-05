package org.example.controller;

import org.example.constant.MessageConstant;
import org.example.constant.StatusConstant;
import org.example.entity.Order;
import org.example.result.Result;
import org.example.service.OrderDetailService;
import org.example.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName OrderDetailController
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/4 17:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/order")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    @GetMapping("/getgetOrderDetail/{orderId}")
    public Result getgetOrderDetail(@NotNull @PathVariable("orderId") Integer orderId) {
        List<OrderDetailVo> list = orderDetailService.getgetOrderDetail(orderId);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS,list);
    }
}
