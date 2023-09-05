package org.example.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName CommonVo
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 10:49
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonVo implements Serializable {

    private Integer fieldCount;

    private Integer affectedRows;

    private Integer insertId;

    private Integer serverStatus;

    private Integer warningCount;

    private String message;

    private Boolean protocol41;

    private Integer changeRows;
}
