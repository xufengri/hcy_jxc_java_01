package org.example.service;

import org.example.dto.AddGoodDto;
import org.example.dto.GoodsPageDto;
import org.example.dto.UpStatusDto;
import org.example.dto.UpdateGoodDto;
import org.example.result.PageResult;
import org.example.vo.CommonVo;
import org.example.vo.GoodsVo;

public interface GoodsService {
    PageResult<GoodsVo> getGoods(GoodsPageDto goodsPageDto);

    CommonVo addGood(AddGoodDto addGoodDto);

    CommonVo upStatus(UpStatusDto upStatusDto);

    CommonVo updateGood(UpdateGoodDto updateGoodDto);

    CommonVo delGood(Integer goodId);
}
