package org.example.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.constant.MessageConstant;
import org.example.constant.StatusConstant;
import org.example.dto.DeliveryOrderDto;
import org.example.dto.OrderPageDto;
import org.example.entity.Order;
import org.example.exception.BusinessException;
import org.example.mapper.OrderMapper;
import org.example.result.PageResult;
import org.example.service.OrderService;
import org.example.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/4 15:57
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageResult<Order> getOrdersPage(OrderPageDto orderPageDto) {
        //参数校验
        if (orderPageDto.getPage() < 0 || orderPageDto.getPage() == 0) {
            orderPageDto.setPage(1);
        }
        if (orderPageDto.getPageSize() < 0 || orderPageDto.getPageSize() == 0) {
            orderPageDto.setPageSize(20);
        }
        PageHelper.startPage(orderPageDto.getPage(), orderPageDto.getPageSize());
        List<Order> orderList = orderMapper.selectPage(orderPageDto.getUserName(), orderPageDto.getStatut(), orderPageDto.getType(),
                orderPageDto.getBeginTime(), orderPageDto.getEndTime());
        Page<Order> page = (Page<Order>) orderList;
        return new PageResult<>(page.getTotal(), page.getResult());
    }


    @Override
    public CommonVo orderOk(Integer orderId) {
        //参数校验
        if (orderId == null || orderId < 0) {
            throw new BusinessException(StatusConstant.DISABLE, MessageConstant.PARAMETER_ERROR);
        }
        try {
            orderMapper.updateTypeByOrderId(orderId);
            return CommonVo.builder()
                    .fieldCount(0)
                    .affectedRows(1)
                    .insertId(0)
                    .serverStatus(2)
                    .warningCount(0)
                    .message("(Rows matched:" + 1 + "Changed:" + 1 + "Warnings:" + 0 + ")")
                    .protocol41(true)
                    .changeRows(1).build();
        } catch (Exception e) {
            throw new BusinessException(StatusConstant.DISABLE, e.getMessage());
        }
    }


    @Override
    public CommonVo deliveryOrder(DeliveryOrderDto deliveryOrderDto) {
        //参数校验
        if (deliveryOrderDto.getOrderId() == null || StrUtil.isBlank(deliveryOrderDto.getDeliveryTime())) {
            throw new BusinessException(StatusConstant.DISABLE, MessageConstant.PARAMETER_ERROR);
        }
        try {
            orderMapper.updateStatutByOrderId(deliveryOrderDto);
            return CommonVo.builder()
                    .fieldCount(0)
                    .affectedRows(1)
                    .insertId(0)
                    .serverStatus(2)
                    .warningCount(0)
                    .message("(Rows matched:" + 1 + "Changed:" + 1 + "Warnings:" + 0 + ")")
                    .protocol41(true)
                    .changeRows(1).build();
        } catch (Exception e) {
            throw new BusinessException(StatusConstant.DISABLE, e.getMessage());
        }
    }


    @Override
    public CommonVo delOrder(Integer orderId) {
        //参数校验
        if (orderId == null || orderId < 0) {
            throw new BusinessException(StatusConstant.DISABLE, MessageConstant.PARAMETER_ERROR);
        }
        Order dbOrder = orderMapper.selectByOrderId(orderId);
        if (Objects.isNull(dbOrder)){
            throw new BusinessException(StatusConstant.DISABLE,MessageConstant.ORDER_NOT_FOUND);
        }
        try {
            orderMapper.deleteByOrderId(orderId);
            return CommonVo.builder()
                    .fieldCount(0)
                    .affectedRows(1)
                    .insertId(0)
                    .serverStatus(2)
                    .warningCount(0)
                    .message("(Rows matched:" + 1 + "Changed:" + 1 + "Warnings:" + 0 + ")")
                    .protocol41(true)
                    .changeRows(1).build();
        } catch (Exception e) {
            throw new BusinessException(StatusConstant.DISABLE, e.getMessage());
        }
    }
}
