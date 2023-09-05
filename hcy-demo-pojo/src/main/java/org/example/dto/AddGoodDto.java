package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.vo.PriceList;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName AddGoodDto
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 13:59
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddGoodDto implements Serializable {
    @NotNull
    private String goodCode;
    @NotNull
    private String goodName;
    @NotNull
    private List<PriceList> priceList;
    @NotNull
    private Double total;

    private String goodDesc;
}
