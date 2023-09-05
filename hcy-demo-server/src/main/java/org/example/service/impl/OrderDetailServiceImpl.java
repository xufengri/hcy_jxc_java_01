package org.example.service.impl;

import org.example.constant.MessageConstant;
import org.example.constant.StatusConstant;
import org.example.entity.Order;
import org.example.entity.OrderDetail;
import org.example.exception.BusinessException;
import org.example.mapper.OrderDetailMapper;
import org.example.service.OrderDetailService;
import org.example.service.OrderService;
import org.example.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderDetailImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/4 17:50
 * @Version 1.0
 **/
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetailVo> getgetOrderDetail(Integer orderId) {
        //参数校验
        if (orderId == null || orderId < 0) {
            throw new BusinessException(StatusConstant.DISABLE, MessageConstant.PARAMETER_ERROR);
        }
        return orderDetailMapper.selectListByOrderID(orderId);

    }
}
