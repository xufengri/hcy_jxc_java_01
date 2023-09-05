package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.dto.AddGoodDto;
import org.example.entity.Goods;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select g.good_name  from sale_records sr join goods g on sr.good_id = g.good_id where sr.sale_id  =#{saleId}")
    String selectGoodName(Integer saleId);

    List<Goods> selectList(String goodName);

    @Select("select good_id,good_name,price,total,good_status,good_desc,good_code from goods where good_name =#{goodName}")
    Goods selectByGoodName(String goodName);

    @Select("select good_id,good_name,price,total,good_status,good_desc,good_code from goods where good_code =#{goodCode}")
    Goods selectByGoodCode(String goodCode);


    void insert(AddGoodDto addGoodDto);
}
