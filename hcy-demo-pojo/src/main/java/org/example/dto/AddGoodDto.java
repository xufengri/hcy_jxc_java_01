package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.vo.PriceList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName AddGoodDto
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 13:59
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddGoodDto implements Serializable {
    @NotBlank(message = "商品编码不能为空")
    @ApiModelProperty(value = "商品编码",required = true)
    private String goodCode;

    @ApiModelProperty(value = "货物名称",required = true)
    private String goodName;

    @ApiModelProperty(value = "价格集合",required = true)
    @NotNull
    private List<PriceList> priceList;

    @ApiModelProperty(value = "数量",required = true)
    @NotNull
    private Double total;

    @ApiModelProperty(value = "备注",required = false)
    private String goodDesc;
}
