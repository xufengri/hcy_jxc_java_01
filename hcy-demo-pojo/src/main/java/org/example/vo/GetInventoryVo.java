package org.example.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName GetInventoryVo
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/6 11:35
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetInventoryVo implements Serializable {

    @ApiModelProperty("货物编号")
    private Integer goodId;

    @ApiModelProperty("货物名称")
    private String goodName;

    @ApiModelProperty("店铺名称")
    private String name;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("数量")
    private Integer total;

    @ApiModelProperty("备注")
    private String goodDesc;
}
