package com.lightmall.goods.controller;

import com.lightmall.common.Result;
import com.lightmall.goods.model.Goods;
import com.lightmall.goods.model.GoodsDTO;
import com.lightmall.goods.model.GoodsUpdateDTO;
import com.lightmall.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品管理")
@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "获取商品列表")
    @GetMapping("/list")
    public Result getGoodsList() {
        try {
            List<Goods> goodsList = goodsService.getGoodsList();
            return Result.success(goodsList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据ID获取商品详情")
    @GetMapping("/{id}")
    public Result getGoodsById(@ApiParam(name = "商品ID", required = true) @PathVariable Long id) {
        try {
            Goods goods = goodsService.getGoodsById(id);
            return Result.success(goods);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "添加商品")
    @PostMapping
    public Result addGoods(@ApiParam(name = "商品信息", required = true) @RequestBody GoodsDTO goodsDTO) {
        try {
            Goods goods = new Goods();
            goods.setGoodsName(goodsDTO.getGoodsName());
            goods.setGoodsImg(goodsDTO.getGoodsImg());
            goods.setGoodsDetail(goodsDTO.getGoodsDetail());
            goods.setGoodsPrice(goodsDTO.getGoodsPrice());
            goods.setStatus(goodsDTO.getStatus());
            boolean success = goodsService.addGoods(goods);
            return success ? Result.success() : Result.error("添加失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "更新商品")
    @PutMapping
    public Result updateGoods(@ApiParam(name = "商品信息", required = true) @RequestBody GoodsUpdateDTO goodsUpdateDTO) {
        try {
            Goods goods = new Goods();
            goods.setId(goodsUpdateDTO.getId());
            goods.setGoodsName(goodsUpdateDTO.getGoodsName());
            goods.setGoodsImg(goodsUpdateDTO.getGoodsImg());
            goods.setGoodsDetail(goodsUpdateDTO.getGoodsDetail());
            goods.setGoodsPrice(goodsUpdateDTO.getGoodsPrice());
            goods.setStatus(goodsUpdateDTO.getStatus());
            boolean success = goodsService.updateGoods(goods);
            return success ? Result.success() : Result.error("更新失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "删除商品")
    @DeleteMapping("/{id}")
    public Result deleteGoods(@ApiParam(name = "商品ID", required = true) @PathVariable Long id) {
        try {
            boolean success = goodsService.deleteGoods(id);
            return success ? Result.success() : Result.error("删除失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation(value = "更新商品状态")
    @PutMapping("/status/{id}/{status}")
    public Result updateStatus(@ApiParam(name = "商品ID", required = true) @PathVariable Long id, @ApiParam(name = "状态", required = true) @PathVariable Integer status) {
        try {
            boolean success = goodsService.updateStatus(id, status);
            return success ? Result.success() : Result.error("更新状态失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }
}
