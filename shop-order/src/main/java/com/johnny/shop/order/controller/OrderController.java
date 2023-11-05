package com.johnny.shop.order.controller;

import com.alibaba.fastjson.JSON;
import com.johnny.shop.entity.Order;
import com.johnny.shop.entity.Product;
import com.johnny.shop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <b>请输入名称</b>
 * <p>
 * 描述<br/>
 * 作用：；<br/>
 * 限制：；<br/>
 * </p>
 *
 * @author wan.liang(79274)
 * @date 2023/11/3 14:59
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final RestTemplate restTemplate;

    @GetMapping("/order/prod/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
        //通过restTemplate调用商品微服务
        Product product = restTemplate.getForObject(
                "http://localhost:8081/product/" + id, Product.class);

        log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.save(order);
        return order;
    }

}
