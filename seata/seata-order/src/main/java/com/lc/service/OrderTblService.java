package com.lc.service;

import com.lc.OrderTbl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (OrderTbl)表服务接口
 *
 * @author makejava
 * @since 2024-01-26 17:05:57
 */
public interface OrderTblService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderTbl queryById(Integer id);

    /**
     * 分页查询
     *
     * @param orderTbl 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<OrderTbl> queryByPage(OrderTbl orderTbl, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    OrderTbl insert(OrderTbl orderTbl);

    /**
     * 修改数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    OrderTbl update(OrderTbl orderTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
