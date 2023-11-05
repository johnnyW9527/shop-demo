package com.johnny.shop.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * <b>订单</b>
 * <p>
 * 描述<br/>
 * 作用：；<br/>
 * 限制：；<br/>
 * </p>
 *
 * @author wan.liang(79274)
 * @date 2023/11/3 14:09
 */
@Entity(name ="shop_order")
@Data
public class Order {

    /**
     * 订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 商品id
     */
    private Integer pid;
    /**
     * 商品名称
     */
    private String pname;
    /**
     * 商品单价
     */
    private Double pprice;
    /**
     * 购买数量
     */
    private Integer number;

}
