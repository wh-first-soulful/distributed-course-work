package com.lightmall.goods.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "秒杀商品更新请求对象")
public class SeckillGoodsUpdateDTO {
    @ApiModelProperty(value = "秒杀商品ID", required = true)
    private Long id;
    @ApiModelProperty(value = "商品ID", required = true)
    private Long goodsId;
    @ApiModelProperty(value = "秒杀价格", required = true)
    private BigDecimal seckillPrice;
    @ApiModelProperty(value = "秒杀库存数量", required = true)
    private Integer stockCount;
    @ApiModelProperty(value = "秒杀开始时间", required = true)
    private Date startTime;
    @ApiModelProperty(value = "秒杀结束时间", required = true)
    private Date endTime;
    @ApiModelProperty(value = "状态: 0-未开始 1-进行中 2-已结束", required = true)
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(BigDecimal seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
