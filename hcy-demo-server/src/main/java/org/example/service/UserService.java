package org.example.service;

import org.example.dto.GetInventoryDto;
import org.example.dto.OutGoodsDto;
import org.example.dto.UserPageDto;
import org.example.entity.User;
import org.example.result.PageResult;
import org.example.vo.CommonVo;
import org.example.vo.GetInventoryVo;

import java.util.List;

public interface UserService {
    PageResult<User> getUsers(UserPageDto userPageDto);

    PageResult<GetInventoryVo> getInventory(GetInventoryDto getInventoryDto);

    CommonVo outGoods(OutGoodsDto outGoodsDto);
}
