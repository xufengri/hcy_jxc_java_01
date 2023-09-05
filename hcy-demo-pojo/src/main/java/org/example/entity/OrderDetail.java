package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName OrderDetail
 * @Description TODO 订单详情实体类
 * @Author Lenovo
 * @Date 2023/9/5 10:24
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {
    private String goodName;

    private Integer orderId;

    private Integer count;

    private BigDecimal price;

    private Integer goodId;

}
