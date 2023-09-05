package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.GoodPrice;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface GoodPriceMapper {


    void insert(Integer goodId, Integer roleId, BigDecimal price);
}
