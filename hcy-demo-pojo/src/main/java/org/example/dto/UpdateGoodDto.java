package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.vo.PriceList;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName UpdateGoodDto
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 16:44
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGoodDto implements Serializable {
    @NotNull
    @ApiModelProperty(value = "商品编码",required = true)
    private String goodCode;

    @NotNull
    @ApiModelProperty(value = "货物名称",required = true)
    private String goodName;

    @NotNull
    @ApiModelProperty(value = "价格集合",required = true)
    private List<PriceList> priceList;

    @NotNull
    @ApiModelProperty(value = "数量",required = true)
    private Double total;

    @ApiModelProperty(value = "备注",required = false)
    private String goodDesc;

    @NotNull
    @ApiModelProperty(value = "货物Id",required = true)
    private Integer goodId;

    @NotNull
    @ApiModelProperty(value = "货物状态",required = true)
    private Integer goodStatus;
}
