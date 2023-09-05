package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.vo.OrderDetailVo;

import java.util.List;

@Mapper
public interface OrderDetailMapper {


    List<OrderDetailVo> selectListByOrderID(Integer orderId);
}
