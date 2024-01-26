package com.lc.dao;


import com.lc.entity.OrderTbl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (OrderTbl)表数据库访问层
 *
 * @author makejava
 * @since 2024-01-26 17:05:46
 */
@Mapper
public interface OrderTblDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderTbl queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param orderTbl 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<OrderTbl> queryAllByLimit(OrderTbl orderTbl, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param orderTbl 查询条件
     * @return 总行数
     */
    long count(OrderTbl orderTbl);

    /**
     * 新增数据
     *
     * @param orderTbl 实例对象
     * @return 影响行数
     */
    int insert(OrderTbl orderTbl);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderTbl> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderTbl> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderTbl> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderTbl> entities);

    /**
     * 修改数据
     *
     * @param orderTbl 实例对象
     * @return 影响行数
     */
    int update(OrderTbl orderTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

