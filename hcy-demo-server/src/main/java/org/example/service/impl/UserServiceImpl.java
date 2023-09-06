package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.constant.StatusConstant;
import org.example.dto.GetInventoryDto;
import org.example.dto.OutGoodsDto;
import org.example.dto.UserPageDto;
import org.example.entity.User;
import org.example.exception.BusinessException;
import org.example.mapper.GoodsMapper;
import org.example.mapper.UserGoodsMapper;
import org.example.mapper.UserMapper;
import org.example.result.PageResult;
import org.example.service.UserService;
import org.example.vo.CommonVo;
import org.example.vo.GetInventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/6 10:38
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserGoodsMapper userGoodsMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageResult<User> getUsers(UserPageDto userPageDto) {
        PageHelper.startPage(userPageDto.getPage(), userPageDto.getSize());
        List<User> userList = userMapper.selectPage(userPageDto.getName());
        Page<User> page = (Page<User>) userList;
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult<GetInventoryVo> getInventory(GetInventoryDto getInventoryDto) {
        String name = userMapper.selectNameById(getInventoryDto.getId());
        PageHelper.startPage(getInventoryDto.getPage(), getInventoryDto.getSize());
        List<GetInventoryVo> getInventoryVoList = userGoodsMapper.selectByUserId(getInventoryDto.getId());
        Page<GetInventoryVo> page = (Page<GetInventoryVo>) getInventoryVoList;
        for (GetInventoryVo getInventoryVo : page.getResult()) {
            getInventoryVo.setName(name);
        }
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    @Transactional
    public CommonVo outGoods(OutGoodsDto outGoodsDto) {
        try {
            goodsMapper.updateoutGoodsGood(outGoodsDto.getGoodId(), outGoodsDto.getCount(), outGoodsDto.getReason());
            userGoodsMapper.updateoutGoodsGood(outGoodsDto.getGoodId(), outGoodsDto.getCount());
            return CommonVo.builder()
                    .fieldCount(0)
                    .affectedRows(1)
                    .insertId(0)
                    .serverStatus(2)
                    .warningCount(0)
                    .message("")
                    .protocol41(true)
                    .changeRows(0).build();
        } catch (Exception e) {
            throw new BusinessException(StatusConstant.DISABLE, e.getMessage());
        }
    }
}
