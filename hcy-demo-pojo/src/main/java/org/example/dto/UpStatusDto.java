package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName UpStatusDto
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 16:29
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpStatusDto implements Serializable {

    @NotNull
    @ApiModelProperty(value = "货物Id",required = true)
    private Integer goodId;

    @NotNull
    @ApiModelProperty(value = "货物状态",required = true)
    private Integer goodStatus;
}
