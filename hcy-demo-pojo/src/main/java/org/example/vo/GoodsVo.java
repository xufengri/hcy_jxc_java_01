package org.example.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName GoodsVo
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 11:44
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo implements Serializable {
    private Integer goodId;

    private String goodName;

    private Double total;

    private Integer goodStatus;

    private String goodDesc;

    private String goodCode;

    private List<PriceList> priceList;
}
