package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.GoodPrice;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface GoodPriceMapper {


    void insert(@Param("goodId") Integer goodId, @Param("roleId") Integer roleId, @Param("price") BigDecimal price);

    @Delete("delete from good_price where good_id =#{goodId}")
    void deleteByGoodId(Integer goodId);
}
