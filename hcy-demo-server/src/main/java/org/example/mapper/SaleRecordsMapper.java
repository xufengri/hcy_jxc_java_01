package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.SaleRecords;

import java.time.LocalDateTime;
import java.util.List;


@Mapper
public interface SaleRecordsMapper {

    @Select("select sale_id, good_id, user_id, count, phone_number, createTime, updateTime,reason from sale_records")
    List<SaleRecords> getList();


    List<SaleRecords> getPageList(@Param("userName") String userName,
                                  @Param("beginTime") String beginTime,
                                  @Param("endTime") String endTime);
}
