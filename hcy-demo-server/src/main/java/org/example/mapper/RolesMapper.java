package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.vo.PriceList;

import java.util.List;

@Mapper
public interface RolesMapper {

    List<PriceList> selectByGoodId(Integer goodId);
}
