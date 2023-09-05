package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName GoodPrice
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 13:31
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodPrice implements Serializable {

    private Integer goodId;

    private Integer roleId;

    private BigDecimal peice;
}
