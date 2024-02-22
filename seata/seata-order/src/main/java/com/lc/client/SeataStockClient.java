package com.lc.client;

import com.lc.StockTbl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "seata-stock")
public interface SeataStockClient {
    @PostMapping("/stockTbl/insert")
    ResponseEntity<StockTbl> add(StockTbl stockTbl);

    @PutMapping("/stockTbl/edit")
     ResponseEntity<StockTbl> edit(StockTbl stockTbl);

    @PutMapping("/stockTbl/sale/{commodityCode}/{count}")
    ResponseEntity<Boolean> sale(@PathVariable("commodityCode") String commodityCode,@PathVariable("count") int count);
}