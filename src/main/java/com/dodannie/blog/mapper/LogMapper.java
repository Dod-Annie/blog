package com.dodannie.blog.mapper;

import com.dodannie.blog.pojo.Log;
import com.dodannie.blog.utils.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/5/30 21:53
 */
@Component
public interface LogMapper {

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
    List<Log> getByPage(Page<Log> page);

    /**
     * 查询总数
     * @param page
     * @return
     */
    int getCountByPage(Page<Log> page);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据id列表删除
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 查询全部
     * @return
     */
    List<Log> getAll();
}
