package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @ClassName Order
 * @Description TODO 订单实体类
 * @Author Lenovo
 * @Date 2023/9/4 15:38
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private Integer orderId;

    private String user;

    private Integer userId;

    private Integer statut;

    private Integer type;

    private BigDecimal totalPrice;

    private String descs;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private String city;

    private String phoneNumber;

    private LocalDateTime deliveryTime;


}
