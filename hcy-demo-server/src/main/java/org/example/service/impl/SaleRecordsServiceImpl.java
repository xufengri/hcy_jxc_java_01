package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.example.dto.SaleRecordsPageDto;
import org.example.entity.SaleRecords;
import org.example.mapper.GoodsMapper;
import org.example.mapper.SaleRecordsMapper;
import org.example.mapper.UserMapper;
import org.example.result.PageResult;
import org.example.service.SaleRecordsService;
import org.example.vo.SaleRecordsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName SaleRecordsServiceImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/4 12:48
 * @Version 1.0
 **/
@Service
public class SaleRecordsServiceImpl implements SaleRecordsService {
    @Autowired
    private SaleRecordsMapper saleRecordsMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public List getSaleRecordsList() {
        List<SaleRecords> saleRecordsList = saleRecordsMapper.getList();
        ArrayList saleRecordsVoList = new ArrayList();
        for (SaleRecords saleRecords : saleRecordsList) {
            String goodName = goodsMapper.selectGoodName(saleRecords.getSaleId());
            String name = userMapper.selectName(saleRecords.getSaleId());
            SaleRecordsVo saleRecordsVo = SaleRecordsVo.builder()
                    .goodName(goodName)
                    .count(saleRecords.getCount())
                    .phoneNumber(saleRecords.getPhoneNumber())
                    .createTime(saleRecords.getCreateTime())
                    .name(name)
                    .saleId(saleRecords.getSaleId())
                    .reason(saleRecords.getReason()).build();
            saleRecordsVoList.add(saleRecordsVo);
        }
        return saleRecordsVoList;
    }

    @Override
    public PageResult<SaleRecordsVo> getSaleRecordsPage(SaleRecordsPageDto saleRecordsPageDto) {
        //参数校验
        if (saleRecordsPageDto.getPage() < 0 || saleRecordsPageDto.getPage() == 0) {
            saleRecordsPageDto.setPage(1);
        }
        if (saleRecordsPageDto.getPageSize() < 0 || saleRecordsPageDto.getPageSize() == 0) {
            saleRecordsPageDto.setPageSize(10);
        }
        List<SaleRecordsVo> saleRecordsVoList = new ArrayList();
        PageHelper.startPage(saleRecordsPageDto.getPage(), saleRecordsPageDto.getPageSize());
        List<SaleRecords> saleRecordsList = saleRecordsMapper.getPageList(saleRecordsPageDto.getUserName(),
                saleRecordsPageDto.getBeginTime(), saleRecordsPageDto.getEndTime());
        Page<SaleRecords> page = (Page<SaleRecords>) saleRecordsList;
        List<SaleRecords> result = page.getResult();
        for (SaleRecords saleRecords : result) {
            SaleRecordsVo saleRecordsVo = SaleRecordsVo.builder()
                    .goodName(saleRecords.getGoodName())
                    .count(saleRecords.getCount())
                    .phoneNumber(saleRecords.getPhoneNumber())
                    .createTime(saleRecords.getCreateTime())
                    .name(saleRecords.getUserName())
                    .saleId(saleRecords.getSaleId())
                    .reason(saleRecords.getReason()).build();
            saleRecordsVoList.add(saleRecordsVo);
        }
        return new PageResult<SaleRecordsVo>(page.getTotal(), saleRecordsVoList);
    }
}
