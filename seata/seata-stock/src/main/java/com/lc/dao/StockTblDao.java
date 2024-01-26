package com.lc.dao;


import com.lc.entity.StockTbl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (StockTbl)表数据库访问层
 *
 * @author makejava
 * @since 2024-01-26 17:11:46
 */
@Mapper
public interface StockTblDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockTbl queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param stockTbl 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<StockTbl> queryAllByLimit(StockTbl stockTbl, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param stockTbl 查询条件
     * @return 总行数
     */
    long count(StockTbl stockTbl);

    /**
     * 新增数据
     *
     * @param stockTbl 实例对象
     * @return 影响行数
     */
    int insert(StockTbl stockTbl);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockTbl> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StockTbl> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockTbl> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StockTbl> entities);

    /**
     * 修改数据
     *
     * @param stockTbl 实例对象
     * @return 影响行数
     */
    int update(StockTbl stockTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

