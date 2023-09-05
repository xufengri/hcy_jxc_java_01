package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.dto.DeliveryOrderDto;
import org.example.entity.Order;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> selectPage(@Param("userName") String userName,
                           @Param("statut") Integer statut,
                           @Param("type") Integer type,
                           @Param("beginTime") String beginTime,
                           @Param("endTime") String endTime);

    @Update("update orders set type = 1 where order_id =#{orderId}")
    void updateTypeByOrderId(Integer orderId);

    @Update("update orders set statut = 1 ,deliveryTime = #{deliveryTime} where order_id =#{orderId}")
    void updateStatutByOrderId(DeliveryOrderDto deliveryOrderDto);

    @Delete("delete from orders where order_id =#{orderId}")
    void deleteByOrderId(Integer orderId);

    @Select("select * from orders where order_id =#{orderId}")
    Order selectByOrderId(Integer orderId);
}
