package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @ClassName OutGoodsDto
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/6 13:29
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutGoodsDto implements Serializable {
    @NotEmpty(message = "数量不能为空")
    @ApiModelProperty("数量")
    private Integer count;

    @ApiModelProperty("货物Id")
    @NotEmpty(message = "货物Id不能为空")
    private Integer goodId;

    @ApiModelProperty("原因")
    private String reason;

    @ApiModelProperty("店铺Id")
    @NotEmpty(message = "店铺Id不能为空")
    private Integer userId;
}
