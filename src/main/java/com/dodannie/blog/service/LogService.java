package com.dodannie.blog.service;

import com.dodannie.blog.pojo.Log;
import com.dodannie.blog.utils.Page;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/5/30 21:47
 */
public interface LogService {

    /**
     * 保存
     * @param logger
     */
    void save(Log logger);

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page<Log> getByPage(Page<Log> page);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据id集合删除
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 查询数据，构建成workbook用于导出
     * @return
     */
    Workbook export();
}