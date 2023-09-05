package org.example.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName SaleRecordsVo
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/4 13:11
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleRecordsVo implements Serializable {

    @ApiModelProperty(value = "货物名称")
    private String goodName;

    @ApiModelProperty(value = "数量")
    private Integer count;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "店铺名称")
    private String name;

    @ApiModelProperty(value = "记录Id")
    private Integer saleId;

    @ApiModelProperty(value = "原因")
    private String reason;
}
