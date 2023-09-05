package org.example.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.constant.MessageConstant;
import org.example.constant.StatusConstant;
import org.example.dto.AddGoodDto;
import org.example.dto.GoodsPageDto;
import org.example.dto.UpStatusDto;
import org.example.dto.UpdateGoodDto;
import org.example.entity.Goods;
import org.example.exception.BusinessException;
import org.example.mapper.GoodPriceMapper;
import org.example.mapper.GoodsMapper;
import org.example.mapper.RolesMapper;
import org.example.result.PageResult;
import org.example.service.GoodsService;
import org.example.vo.CommonVo;
import org.example.vo.GoodsVo;
import org.example.vo.PriceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName GoodsServiceImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/5 11:46
 * @Version 1.0
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RolesMapper rolesMapper;

    @Autowired
    private GoodPriceMapper goodPriceMapper;

    @Override
    public PageResult<GoodsVo> getGoods(GoodsPageDto goodsPageDto) {
        //参数校验
        if (goodsPageDto.getPage() < 0 || goodsPageDto.getPage() == 0) {
            goodsPageDto.setPage(1);
        }
        if (goodsPageDto.getPageSize() < 0 || goodsPageDto.getPageSize() == 0) {
            goodsPageDto.setPageSize(10);
        }
        List<GoodsVo> goodsVoList = new ArrayList<>();
        PageHelper.startPage(goodsPageDto.getPage(), goodsPageDto.getPageSize());
        List<Goods> goodsList = goodsMapper.selectList(goodsPageDto.getGoodName());
        Page<Goods> page = (Page<Goods>) goodsList;
        for (Goods goods : page.getResult()) {
            List<PriceList> priceLists = rolesMapper.selectByGoodId(goods.getGoodId());
            GoodsVo goodsVo = BeanUtil.copyProperties(goods, GoodsVo.class);
            goodsVo.setPriceList(priceLists);
            goodsVoList.add(goodsVo);
        }
        return new PageResult<>(page.getTotal(), goodsVoList);
    }

    @Override
    @Transactional
    public CommonVo addGood(AddGoodDto addGoodDto) {
        Goods byGoodName = goodsMapper.selectByGoodName(addGoodDto.getGoodName());
        if (Objects.nonNull(byGoodName)) {
            throw new BusinessException(StatusConstant.DISABLE, MessageConstant.GOODNAME_ALREADY_EXISTS);
        }
        Goods byGoodCode = goodsMapper.selectByGoodCode(addGoodDto.getGoodCode());
        if (Objects.nonNull(byGoodCode)) {
            throw new BusinessException(StatusConstant.DISABLE, MessageConstant.GOODCODE_ALREADY_EXISTS);
        }
        try {
            goodsMapper.insert(addGoodDto);
            Goods dbGood = goodsMapper.selectByGoodName(addGoodDto.getGoodName());
            for (PriceList priceList : addGoodDto.getPriceList()) {
                goodPriceMapper.insert(dbGood.getGoodId(), priceList.getRoleId(), priceList.getPrice());
            }
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

    @Override
    public CommonVo upStatus(UpStatusDto upStatusDto) {
        try {
            if (upStatusDto.getGoodStatus().equals(0)) {
                goodsMapper.upStatus(upStatusDto.getGoodId());
            }
            goodsMapper.downStatus(upStatusDto.getGoodId());
            return CommonVo.builder()
                    .fieldCount(0)
                    .affectedRows(1)
                    .insertId(0)
                    .serverStatus(2)
                    .warningCount(0)
                    .message("(Rows matched:" + 1 + "Changed:" + 1 + "Warnings:" + 0 + ")")
                    .protocol41(true)
                    .changeRows(1).build();
        } catch (Exception e) {
            throw new BusinessException(StatusConstant.DISABLE, e.getMessage());
        }

    }

    @Override
    @Transactional
    public CommonVo updateGood(UpdateGoodDto updateGoodDto) {
        //参数校验
        if (!updateGoodDto.getGoodStatus().equals(0)) {
            throw new BusinessException(StatusConstant.DISABLE, MessageConstant.GOOD_UP);
        }
        try {
            goodsMapper.updateGood(updateGoodDto);
            for (PriceList priceList : updateGoodDto.getPriceList()) {
                goodPriceMapper.deleteByGoodId(updateGoodDto.getGoodId());
                goodPriceMapper.insert(updateGoodDto.getGoodId(), priceList.getRoleId(), priceList.getPrice());
            }
            return CommonVo.builder()
                    .fieldCount(0)
                    .affectedRows(2)
                    .insertId(0)
                    .serverStatus(2)
                    .warningCount(0)
                    .message("(Rows matched:" + 2 + "Changed:" + 0 + "Warnings:" + 0 + ")")
                    .protocol41(true)
                    .changeRows(0).build();
        } catch (Exception e) {
            throw new BusinessException(StatusConstant.DISABLE, e.getMessage());
        }
    }

    @Override
    public CommonVo delGood(Integer goodId) {
        try {
            goodsMapper.deleteByGoodId(goodId);
            return CommonVo.builder()
                    .fieldCount(0)
                    .affectedRows(1)
                    .insertId(0)
                    .serverStatus(34)
                    .warningCount(0)
                    .message("")
                    .protocol41(true)
                    .changeRows(0).build();
        } catch (Exception e) {
            throw new BusinessException(StatusConstant.DISABLE, e.getMessage());
        }
    }
}
