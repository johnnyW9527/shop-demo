package com.johnny.shop.order.service.impl;

import com.johnny.shop.entity.Order;
import com.johnny.shop.order.dao.OrderDao;
import com.johnny.shop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <b>请输入名称</b>
 * <p>
 * 描述<br/>
 * 作用：；<br/>
 * 限制：；<br/>
 * </p>
 *
 * @author wan.liang(79274)
 * @date 2023/11/3 14:55
 */
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }
}
