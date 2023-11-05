package com.johnny.shop.order.dao;

import com.johnny.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b>请输入名称</b>
 * <p>
 * 描述<br/>
 * 作用：；<br/>
 * 限制：；<br/>
 * </p>
 *
 * @author wan.liang(79274)
 * @date 2023/11/3 14:54
 */
public interface OrderDao extends JpaRepository<Order, Long> {
}
