package com.dodannie.blog.service.impl;

import com.dodannie.blog.excel.entity.ExportParams;
import com.dodannie.blog.excel.handler.ExcelExportHandler;
import com.dodannie.blog.mapper.LogMapper;
import com.dodannie.blog.pojo.Log;
import com.dodannie.blog.service.LogService;
import com.dodannie.blog.utils.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/5/30 21:51
 */
@Service
@Slf4j
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 保存
     * @param logger
     */
    @Override
    public void save(Log logger) {
        logMapper.save(logger);
    }

    @Override
    public Page<Log> getByPage(Page<Log> page) {
        // 查询数据
        List<Log> logList = logMapper.getByPage(page);
        page.setList(logList);
        // 查询总数
        int totalCount = logMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }

    @Override
    public void deleteById(Integer id) {
        logMapper.deleteById(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        logMapper.deleteByIds(ids);
    }

    @Override
    public Workbook export() {
        List<Log> logList = logMapper.getAll();
        return new ExcelExportHandler().createSheet(new ExportParams("最新日志", "sheet1"), Log.class, logList);
    }
}
