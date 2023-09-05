package org.example.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName PriceList
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 13:15
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceList implements Serializable {

    private String name;

    private BigDecimal price;

    private Integer roleId;
}
