package com.lightmall.goods.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel(description = "商品创建请求对象")
public class GoodsDTO {
    @ApiModelProperty(value = "商品名称", required = true)
    private String goodsName;
    @ApiModelProperty(value = "商品图片URL")
    private String goodsImg;
    @ApiModelProperty(value = "商品详情")
    private String goodsDetail;
    @ApiModelProperty(value = "商品价格", required = true)
    private BigDecimal goodsPrice;
    @ApiModelProperty(value = "状态: 0-下架 1-上架", required = true)
    private Integer status;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
