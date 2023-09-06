package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select u.name  from sale_records sr join `user` u on sr.user_id =u.id where  sr.sale_id  =#{saleId};")
    String selectName(Integer saleId);


    List<User> selectPage(String name);


    @Select("select name from user where id =#{id}")
    String selectNameById(Integer id);
}
