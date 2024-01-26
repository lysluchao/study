package controller;

import com.lc.entity.OrderTbl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lc.service.OrderTblService;

import javax.annotation.Resource;

/**
 * (OrderTbl)表控制层
 *
 * @author makejava
 * @since 2024-01-26 17:05:44
 */
@RestController
@RequestMapping("orderTbl")
public class OrderTblController {
    /**
     * 服务对象
     */
    @Resource
    private OrderTblService orderTblService;

    /**
     * 分页查询
     *
     * @param orderTbl 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<OrderTbl>> queryByPage(OrderTbl orderTbl, PageRequest pageRequest) {
        return ResponseEntity.ok(this.orderTblService.queryByPage(orderTbl, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OrderTbl> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.orderTblService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param orderTbl 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<OrderTbl> add(OrderTbl orderTbl) {
        return ResponseEntity.ok(this.orderTblService.insert(orderTbl));
    }

    /**
     * 编辑数据
     *
     * @param orderTbl 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<OrderTbl> edit(OrderTbl orderTbl) {
        return ResponseEntity.ok(this.orderTblService.update(orderTbl));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.orderTblService.deleteById(id));
    }

}

