package org.example.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName OrderDetailVo
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 9:59
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVo implements Serializable {

    @ApiModelProperty(value = "货物名称")
    private String goodName;

    @ApiModelProperty(value = "订单号")
    private Integer orderId;

    @ApiModelProperty(value = "数量")
    private Double total;

    @ApiModelProperty(value = "总部库存")
    private Integer count;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "货物Id")
    private Integer goodId;

    @ApiModelProperty(value = "货物状态")
    private Integer goodStatus;
}
