package org.example.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName ExportMupOrderDataVo
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/6 14:24
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExportMupOrderDataVo implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("下单时间")
    private LocalDateTime createTime;

    @ApiModelProperty("收货人姓名")
    private String user;

    @ApiModelProperty("手机")
    private String phoneNumber;

    @ApiModelProperty("地址")
    private String city;

    @ApiModelProperty("编码")
    private String goodCode;

    @ApiModelProperty("商品名称")
    private String goodName;

}
