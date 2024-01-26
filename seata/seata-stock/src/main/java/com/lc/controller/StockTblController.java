package com.lc.controller;

import com.lc.entity.StockTbl;
import com.lc.service.StockTblService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (StockTbl)表控制层
 *
 * @author makejava
 * @since 2024-01-26 17:11:44
 */
@RestController
@RequestMapping("stockTbl")
public class StockTblController {
    /**
     * 服务对象
     */
    @Resource
    private StockTblService stockTblService;

    /**
     * 分页查询
     *
     * @param stockTbl 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<StockTbl>> queryByPage(StockTbl stockTbl, PageRequest pageRequest) {
        return ResponseEntity.ok(this.stockTblService.queryByPage(stockTbl, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<StockTbl> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.stockTblService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param stockTbl 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<StockTbl> add(StockTbl stockTbl) {
        return ResponseEntity.ok(this.stockTblService.insert(stockTbl));
    }

    /**
     * 编辑数据
     *
     * @param stockTbl 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<StockTbl> edit(StockTbl stockTbl) {
        return ResponseEntity.ok(this.stockTblService.update(stockTbl));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.stockTblService.deleteById(id));
    }

}

