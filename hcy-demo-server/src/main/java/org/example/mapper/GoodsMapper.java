package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.dto.AddGoodDto;
import org.example.dto.UpdateGoodDto;
import org.example.entity.Goods;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select g.good_name  from sale_records sr join goods g on sr.good_id = g.good_id " +
            "where sr.sale_id  =#{saleId}")
    String selectGoodName(Integer saleId);

    List<Goods> selectList(String goodName);

    @Select("select good_id,good_name,price,total,good_status,good_desc,good_code from goods " +
            "where good_name =#{goodName}")
    Goods selectByGoodName(String goodName);

    @Select("select good_id,good_name,price,total,good_status,good_desc,good_code from goods " +
            "where good_code =#{goodCode}")
    Goods selectByGoodCode(String goodCode);


    void insert(AddGoodDto addGoodDto);

    @Update("update goods set good_status = 0 where good_id =#{goodId}")
    void upStatus(Integer goodId);

    @Update("update goods set good_status = 1 where good_id =#{goodId}")
    void downStatus(Integer goodId);


    void updateGood(UpdateGoodDto updateGoodDto);

    @Delete("delete from goods where good_id =#{goodId}")
    void deleteByGoodId(Integer goodId);


    void updateoutGoodsGood(@Param("goodId") Integer goodId,
                            @Param("count") Integer count,
                            @Param("reason") String reason);
}
