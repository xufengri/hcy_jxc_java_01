package org.example.service;

import org.example.dto.SaleRecordsPageDto;
import org.example.entity.SaleRecords;
import org.example.result.PageResult;
import org.example.vo.SaleRecordsVo;

import java.util.List;

/**
 * @ClassName SaleRecordsService
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/4 12:48
 * @Version 1.0
 **/
public interface SaleRecordsService {
    List getSaleRecordsList();


    PageResult<SaleRecordsVo> getSaleRecordsPage(SaleRecordsPageDto saleRecordsPageDto);
}
