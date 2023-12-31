package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName deliveryOrderDto
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 14:26
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrderDto implements Serializable {
    @NotNull
    @ApiModelProperty(value = "订单号",required = true)
    private Integer orderId;

    @ApiModelProperty(value = "发货时间",required = true)
    @NotNull
    private String deliveryTime;
}
