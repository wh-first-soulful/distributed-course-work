package com.lightmall.goods.controller;

import com.lightmall.common.Result;
import com.lightmall.goods.model.SeckillGoods;
import com.lightmall.goods.model.SeckillGoodsDTO;
import com.lightmall.goods.model.SeckillGoodsUpdateDTO;
import com.lightmall.goods.service.SeckillGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "秒杀商品管理")
@RestController
@RequestMapping("/api/seckill")
public class SeckillGoodsController {

    @Autowired
    private SeckillGoodsService seckillGoodsService;

    @ApiOperation(value = "获取秒杀商品列表")
    @GetMapping("/list")
    public Result getSeckillGoodsList() {
        try {
            List<SeckillGoods> seckillGoodsList = seckillGoodsService.getSeckillGoodsList();
            return Result.success(seckillGoodsList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据ID获取秒杀商品详情")
    @GetMapping("/{id}")
    public Result getSeckillGoodsById(@ApiParam(name = "秒杀商品ID", required = true) @PathVariable Long id) {
        try {
            SeckillGoods seckillGoods = seckillGoodsService.getSeckillGoodsById(id);
            return Result.success(seckillGoods);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "添加秒杀商品")
    @PostMapping
    public Result addSeckillGoods(@ApiParam(name = "秒杀商品信息", required = true) @RequestBody SeckillGoodsDTO seckillGoodsDTO) {
        try {
            SeckillGoods seckillGoods = new SeckillGoods();
            seckillGoods.setGoodsId(seckillGoodsDTO.getGoodsId());
            seckillGoods.setSeckillPrice(seckillGoodsDTO.getSeckillPrice());
            seckillGoods.setStockCount(seckillGoodsDTO.getStockCount());
            seckillGoods.setStartTime(seckillGoodsDTO.getStartTime());
            seckillGoods.setEndTime(seckillGoodsDTO.getEndTime());
            seckillGoods.setStatus(seckillGoodsDTO.getStatus());
            boolean success = seckillGoodsService.addSeckillGoods(seckillGoods);
            return success ? Result.success() : Result.error("添加失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "更新秒杀商品")
    @PutMapping
    public Result updateSeckillGoods(@ApiParam(name = "秒杀商品信息", required = true) @RequestBody SeckillGoodsUpdateDTO seckillGoodsUpdateDTO) {
        try {
            SeckillGoods seckillGoods = new SeckillGoods();
            seckillGoods.setId(seckillGoodsUpdateDTO.getId());
            seckillGoods.setGoodsId(seckillGoodsUpdateDTO.getGoodsId());
            seckillGoods.setSeckillPrice(seckillGoodsUpdateDTO.getSeckillPrice());
            seckillGoods.setStockCount(seckillGoodsUpdateDTO.getStockCount());
            seckillGoods.setStartTime(seckillGoodsUpdateDTO.getStartTime());
            seckillGoods.setEndTime(seckillGoodsUpdateDTO.getEndTime());
            seckillGoods.setStatus(seckillGoodsUpdateDTO.getStatus());
            boolean success = seckillGoodsService.updateSeckillGoods(seckillGoods);
            return success ? Result.success() : Result.error("更新失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "删除秒杀商品")
    @DeleteMapping("/{id}")
    public Result deleteSeckillGoods(@ApiParam(name = "秒杀商品ID", required = true) @PathVariable Long id) {
        try {
            boolean success = seckillGoodsService.deleteSeckillGoods(id);
            return success ? Result.success() : Result.error("删除失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }
}
