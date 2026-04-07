package com.lightmall.stock.controller;

import com.lightmall.common.Result;
import com.lightmall.stock.model.Stock;
import com.lightmall.stock.model.StockDTO;
import com.lightmall.stock.model.StockOperationDTO;
import com.lightmall.stock.model.StockUpdateDTO;
import com.lightmall.stock.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "库存管理")
@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @ApiOperation(value = "获取库存列表")
    @GetMapping("/list")
    public Result getStockList() {
        List<Stock> stockList = stockService.list();
        return Result.success(stockList);
    }

    @ApiOperation(value = "获取库存详情")
    @GetMapping("/{id}")
    public Result getStockById(@ApiParam(name = "库存ID", required = true) @PathVariable Long id) {
        Stock stock = stockService.getById(id);
        return Result.success(stock);
    }

    @ApiOperation(value = "根据商品ID获取库存")
    @GetMapping("/goods/{goodsId}")
    public Result getStockByGoodsId(@ApiParam(name = "商品ID", required = true) @PathVariable Long goodsId) {
        Stock stock = stockService.getStockByGoodsId(goodsId);
        return Result.success(stock);
    }

    @ApiOperation(value = "创建库存")
    @PostMapping
    public Result createStock(@ApiParam(name = "库存信息", required = true) @RequestBody StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setGoodsId(stockDTO.getGoodsId());
        stock.setStockNum(stockDTO.getStockNum());
        stock.setLockNum(0);
        stock.setAvailableNum(stockDTO.getStockNum());
        stock.setStatus(stockDTO.getStatus() != null ? stockDTO.getStatus() : 1);
        stock.setVersion(1);
        stockService.save(stock);
        return Result.success(stock);
    }

    @ApiOperation(value = "更新库存")
    @PutMapping
    public Result updateStock(@ApiParam(name = "库存信息", required = true) @RequestBody StockUpdateDTO stockUpdateDTO) {
        Stock stock = stockService.getById(stockUpdateDTO.getId());
        if (stock == null) {
            return Result.error("库存不存在");
        }
        if (stockUpdateDTO.getStockNum() != null) {
            int diff = stockUpdateDTO.getStockNum() - stock.getStockNum();
            stock.setStockNum(stockUpdateDTO.getStockNum());
            stock.setAvailableNum(stock.getAvailableNum() + diff);
        }
        if (stockUpdateDTO.getStatus() != null) {
            stock.setStatus(stockUpdateDTO.getStatus());
        }
        boolean success = stockService.updateStock(stock);
        return success ? Result.success() : Result.error("更新库存失败");
    }

    @ApiOperation(value = "删除库存")
    @DeleteMapping("/{id}")
    public Result deleteStock(@ApiParam(name = "库存ID", required = true) @PathVariable Long id) {
        boolean success = stockService.removeById(id);
        return success ? Result.success() : Result.error("删除库存失败");
    }

    @ApiOperation(value = "更新库存状态")
    @PutMapping("/status/{id}/{status}")
    public Result updateStockStatus(@ApiParam(name = "库存ID", required = true) @PathVariable Long id, @ApiParam(name = "状态", required = true) @PathVariable Integer status) {
        Stock stock = stockService.getById(id);
        if (stock == null) {
            return Result.error("库存不存在");
        }
        stock.setStatus(status);
        boolean success = stockService.updateStock(stock);
        return success ? Result.success() : Result.error("更新库存状态失败");
    }

    @ApiOperation(value = "扣减库存")
    @PostMapping("/decrease")
    public Result decreaseStock(@ApiParam(name = "库存操作信息", required = true) @RequestBody StockOperationDTO stockOperationDTO) {
        boolean success = stockService.decreaseStock(stockOperationDTO.getGoodsId(), stockOperationDTO.getQuantity());
        return success ? Result.success() : Result.error("库存不足");
    }

    @ApiOperation(value = "增加库存")
    @PostMapping("/increase")
    public Result increaseStock(@ApiParam(name = "库存操作信息", required = true) @RequestBody StockOperationDTO stockOperationDTO) {
        boolean success = stockService.increaseStock(stockOperationDTO.getGoodsId(), stockOperationDTO.getQuantity());
        return success ? Result.success() : Result.error("库存回补失败");
    }

    @ApiOperation(value = "锁定库存")
    @PostMapping("/lock")
    public Result lockStock(@ApiParam(name = "库存操作信息", required = true) @RequestBody StockOperationDTO stockOperationDTO) {
        boolean success = stockService.lockStock(stockOperationDTO.getGoodsId(), stockOperationDTO.getQuantity());
        return success ? Result.success() : Result.error("库存不足，无法锁定");
    }

    @ApiOperation(value = "解锁库存")
    @PostMapping("/unlock")
    public Result unlockStock(@ApiParam(name = "库存操作信息", required = true) @RequestBody StockOperationDTO stockOperationDTO) {
        boolean success = stockService.unlockStock(stockOperationDTO.getGoodsId(), stockOperationDTO.getQuantity());
        return success ? Result.success() : Result.error("解锁库存失败");
    }
}
