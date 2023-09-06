package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/6 10:28
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("状态")
    private  Integer status;

    @ApiModelProperty("角色编号")
    private String roleId;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("管理员")
    private Integer admin;

    @ApiModelProperty("密码")
    private String pwd;

    @ApiModelProperty("账号编号")
    private Integer moreId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
