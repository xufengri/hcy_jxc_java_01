package org.example.service;

import org.example.dto.DeliveryOrderDto;
import org.example.dto.OrderPageDto;
import org.example.entity.Order;
import org.example.result.PageResult;
import org.example.vo.CommonVo;

public interface OrderService {

    PageResult<Order> getOrdersPage(OrderPageDto orderPageDto);


    CommonVo orderOk(Integer orderId);

    CommonVo deliveryOrder(DeliveryOrderDto deliveryOrderDto);

    CommonVo delOrder(Integer orderId);
}
