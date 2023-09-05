package org.example.dto;

import lombok.*;

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
public class OrderPageDto implements Serializable {
    //页码
    @NotNull
    @Size(max = 1000, min = 0)
    private Integer page;

    //每页记录数
    @NotNull
    @Size(max = 500, min = 0)
    private Integer pageSize;

    private String userName;

    //物流状态，0：未发货  1：运输中 2：已收货
    private Integer statut;

    //支付状态，0：未付款 1：已付款
    private Integer type;


    private String beginTime;


    private String endTime;


}
