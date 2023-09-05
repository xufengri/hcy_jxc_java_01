package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 11:36
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {

    private Integer goodId;

    private String goodName;

    private BigDecimal price;

    private Double total;

    private Integer goodStatus;

    private String goodDesc;

    private String goodCode;
}
