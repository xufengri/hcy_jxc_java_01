package org.example.dto;

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
    private Integer orderId;

    @NotNull
    private String deliveryTime;
}
