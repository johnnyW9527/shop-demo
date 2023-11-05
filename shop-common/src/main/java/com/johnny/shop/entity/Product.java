package com.johnny.shop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <b>商品</b>
 * <p>
 * 描述<br/>
 * 作用：；<br/>
 * 限制：；<br/>
 * </p>
 *
 * @author wan.liang(79274)
 * @date 2023/11/3 14:09
 */
@Entity(name = "shop_product")
@Data
public class Product {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    /**
     * 商品名称
     */
    private String pname;
    /**
     * 商品价格
     */
    private Double pprice;
    /**
     * 库存
     */
    private Integer stock;

}
