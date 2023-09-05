package org.example.vo;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "编号")
    private Integer goodId;

    @ApiModelProperty(value = "货物名称")
    private String goodName;

    @ApiModelProperty(value = "数量")
    private Double total;

    @ApiModelProperty(value = "货物状态")
    private Integer goodStatus;

    @ApiModelProperty(value = "备注")
    private String goodDesc;

    @ApiModelProperty(value = "商品编码")
    private String goodCode;

    @ApiModelProperty(value = "价格集合")
    private List<PriceList> priceList;
}
