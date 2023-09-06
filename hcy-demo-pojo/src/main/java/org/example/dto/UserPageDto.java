package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
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
public class UserPageDto implements Serializable {
    //页码
    // @NotEmpty(message = "页码不能为空！")
    @Valid
    @Size(max = 1000, min = 1,message = "页码不能为空")
    @ApiModelProperty(value = "页码",required = true)
    private Integer page;

    //每页记录数
    // @NotNull(message = "每页记录数不能为空")
    @Valid
    @Size(max = 500, min = 5,message = "每页记录数不能为空")
    @ApiModelProperty(value = "每页记录数",required = true)
    private Integer size;

    @ApiModelProperty(value = "商店名称",required = false)
    private String name;



}
