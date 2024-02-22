package com.lc.service.impl;

import com.lc.dao.StockTblDao;
import com.lc.StockTbl;
import com.lc.service.StockTblService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (StockTbl)表服务实现类
 *
 * @author makejava
 * @since 2024-01-26 17:11:48
 */
@Service("stockTblService")
public class StockTblServiceImpl implements StockTblService {
    @Resource
    private StockTblDao stockTblDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockTbl queryById(Integer id) {
        return this.stockTblDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param stockTbl 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StockTbl> queryByPage(StockTbl stockTbl, PageRequest pageRequest) {
        long total = this.stockTblDao.count(stockTbl);
        return new PageImpl<>(this.stockTblDao.queryAllByLimit(stockTbl, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param stockTbl 实例对象
     * @return 实例对象
     */
    @Override
    public StockTbl insert(StockTbl stockTbl) {
        this.stockTblDao.insert(stockTbl);
        return stockTbl;
    }

    /**
     * 修改数据
     *
     * @param stockTbl 实例对象
     * @return 实例对象
     */
    @Override
    public StockTbl update(StockTbl stockTbl) {
        this.stockTblDao.update(stockTbl);
        return this.queryById(stockTbl.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.stockTblDao.deleteById(id) > 0;
    }

    @Override
    public StockTbl queryByCommodityCode(String commodityCode) {
        return this.stockTblDao.queryByCommodityCode(commodityCode);
    }
}
