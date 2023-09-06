package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName UserGoods
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/6 11:31
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGoods implements Serializable {

    private Integer goodId;

    private String goodName;

    private Integer userId;

    private BigDecimal price;

    private Integer total;


}
