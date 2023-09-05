package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @ClassName SaleRecordsPageDto
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/4 12:51
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsPageDto implements Serializable {
    //页码
    @NotNull
    @Size(max = 1000, min = 0)
    @ApiModelProperty(value = "页码",required = true)
    private Integer page;

    //每页记录数
    @NotNull
    @Size(max = 500, min = 0)
    @ApiModelProperty(value = "每页记录数",required = true)
    private Integer pageSize;

    @ApiModelProperty(value = "货物名称",required = true)
    private String goodName;



}
