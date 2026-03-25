package com.lightmall.stock.controller;

import com.lightmall.common.Result;
import com.lightmall.stock.model.Stock;
import com.lightmall.stock.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "库存管理")
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @ApiOperation(value = "根据商品ID获取库存")
    @GetMapping("/goods/{goodsId}")
    public Result getStockByGoodsId(@ApiParam(name = "商品ID", required = true) @PathVariable Long goodsId) {
        Stock stock = stockService.getStockByGoodsId(goodsId);
        return Result.success(stock);
    }

    @ApiOperation(value = "扣减库存")
    @PostMapping("/decrease")
    public Result decreaseStock(@ApiParam(name = "商品ID", required = true) @RequestParam Long goodsId, @ApiParam(name = "扣减数量", required = true) @RequestParam Integer quantity) {
        boolean success = stockService.decreaseStock(goodsId, quantity);
        return success ? Result.success() : Result.error("库存不足");
    }

    @ApiOperation(value = "增加库存")
    @PostMapping("/increase")
    public Result increaseStock(@ApiParam(name = "商品ID", required = true) @RequestParam Long goodsId, @ApiParam(name = "增加数量", required = true) @RequestParam Integer quantity) {
        boolean success = stockService.increaseStock(goodsId, quantity);
        return success ? Result.success() : Result.error("库存回补失败");
    }

    @ApiOperation(value = "更新库存")
    @PutMapping
    public Result updateStock(@ApiParam(name = "库存信息", required = true) @RequestBody Stock stock) {
        boolean success = stockService.updateStock(stock);
        return success ? Result.success() : Result.error("更新库存失败");
    }
}
