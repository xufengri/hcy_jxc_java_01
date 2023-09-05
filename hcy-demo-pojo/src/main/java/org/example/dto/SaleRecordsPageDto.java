package org.example.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

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
public class SaleRecordsPageDto implements Serializable {
    //页码
    @NotNull
    @Size(max = 1000, min = 0)
    private int page;

    //每页记录数
    @NotNull
    @Size(max = 500, min = 0)
    private int pageSize;

    private String userName;

    private String beginTime;

    private String endTime;


}
