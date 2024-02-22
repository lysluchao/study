package com.lc.service.impl;

import com.lc.dao.OrderTblDao;
import com.lc.OrderTbl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.lc.service.OrderTblService;

import javax.annotation.Resource;

/**
 * (OrderTbl)表服务实现类
 *
 * @author makejava
 * @since 2024-01-26 17:05:59
 */
@Service("orderTblService")
public class OrderTblServiceImpl implements OrderTblService {
    @Resource
    private OrderTblDao orderTblDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderTbl queryById(Integer id) {
        return this.orderTblDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param orderTbl 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrderTbl> queryByPage(OrderTbl orderTbl, PageRequest pageRequest) {
        long total = this.orderTblDao.count(orderTbl);
        return new PageImpl<>(this.orderTblDao.queryAllByLimit(orderTbl, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    @Override
    public OrderTbl insert(OrderTbl orderTbl) {
        this.orderTblDao.insert(orderTbl);
        return orderTbl;
    }

    /**
     * 修改数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    @Override
    public OrderTbl update(OrderTbl orderTbl) {
        this.orderTblDao.update(orderTbl);
        return this.queryById(orderTbl.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderTblDao.deleteById(id) > 0;
    }
}
