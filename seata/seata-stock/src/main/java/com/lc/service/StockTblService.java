package com.lc.service;

import com.lc.entity.StockTbl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (StockTbl)表服务接口
 *
 * @author makejava
 * @since 2024-01-26 17:11:47
 */
public interface StockTblService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockTbl queryById(Integer id);

    /**
     * 分页查询
     *
     * @param stockTbl 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StockTbl> queryByPage(StockTbl stockTbl, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param stockTbl 实例对象
     * @return 实例对象
     */
    StockTbl insert(StockTbl stockTbl);

    /**
     * 修改数据
     *
     * @param stockTbl 实例对象
     * @return 实例对象
     */
    StockTbl update(StockTbl stockTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
