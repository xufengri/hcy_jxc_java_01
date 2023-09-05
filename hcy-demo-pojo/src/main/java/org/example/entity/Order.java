package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "订单Id")
    private Integer orderId;

    @ApiModelProperty(value = "店铺名称")
    private String user;

    @ApiModelProperty(value = "店铺Id")
    private Integer userId;

    @ApiModelProperty(value = "物流状态")
    private Integer statut;

    @ApiModelProperty(value = "支付状态")
    private Integer type;

    @ApiModelProperty(value = "总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "备注")
    private String descs;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "发货时间")
    private LocalDateTime deliveryTime;


}
