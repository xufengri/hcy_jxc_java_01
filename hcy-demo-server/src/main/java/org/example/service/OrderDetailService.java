package org.example.service;

import org.example.vo.OrderDetailVo;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailVo> getgetOrderDetail(Integer orderId);
}
