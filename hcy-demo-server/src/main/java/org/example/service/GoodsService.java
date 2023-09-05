package org.example.service;

import org.example.dto.AddGoodDto;
import org.example.dto.GoodsPageDto;
import org.example.result.PageResult;
import org.example.vo.CommonVo;
import org.example.vo.GoodsVo;

public interface GoodsService {
    PageResult<GoodsVo> getGoods(GoodsPageDto goodsPageDto);

    CommonVo addGood(AddGoodDto addGoodDto);
}
