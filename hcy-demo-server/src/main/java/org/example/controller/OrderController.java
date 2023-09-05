package org.example.controller;

import org.example.constant.MessageConstant;
import org.example.constant.StatusConstant;
import org.example.dto.OrderPageDto;
import org.example.dto.DeliveryOrderDto;
import org.example.entity.Order;
import org.example.result.PageResult;
import org.example.result.Result;
import org.example.service.OrderService;
import org.example.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/4 15:56
 * @Version 1.0
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单分页查询
     *
     * @param orderPageDto
     * @return
     */
    @GetMapping("/getOrders")
    public Result getOrdersPage(OrderPageDto orderPageDto) {
        PageResult<Order> pageResult = orderService.getOrdersPage(orderPageDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, pageResult);
    }


    /**
     * 订单确认收款
     * @param orderId
     * @return
     */
    @PutMapping("/orderOk/{orderId}")
    public Result orderOk(@NotNull  @PathVariable("orderId") Integer orderId) {
        CommonVo commonVo = orderService.orderOk(orderId);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, commonVo);
    }

    /**
     * 订单发货
     * @param deliveryOrderDto
     * @return
     */
    @PutMapping("/deliveryOrder")
    public Result deliveryOrder(@Validated  @RequestBody DeliveryOrderDto deliveryOrderDto) {
        CommonVo commonVo = orderService.deliveryOrder(deliveryOrderDto);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, commonVo);
    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    @DeleteMapping("/delOrder/{orderId}")
    public Result delOrder(@NotNull @PathVariable("orderId") Integer orderId) {
        CommonVo commonVo = orderService.delOrder(orderId);
        return new Result(StatusConstant.ENABLE, MessageConstant.SUCCESS, commonVo);
    }

}
