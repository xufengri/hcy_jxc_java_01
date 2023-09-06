package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.example.vo.GetInventoryVo;

import java.util.List;

/**
 * @ClassName UserGoodsMapper
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/6 12:00
 * @Version 1.0
 **/
@Mapper
public interface UserGoodsMapper {

    List<GetInventoryVo> selectByUserId(Integer id);

    @Update("update user_goods set total = total - #{count} where good_id =#{goodId}")
    void updateoutGoodsGood(Integer goodId, Integer count);
}
