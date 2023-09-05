package org.example.vo;

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

    private String goodName;

    private Integer orderId;

    private Double total;

    private Integer count;

    private BigDecimal price;

    private Integer goodId;

    private Integer goodStatus;
}
