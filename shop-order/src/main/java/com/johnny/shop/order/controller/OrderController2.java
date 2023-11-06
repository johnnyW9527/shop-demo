package com.johnny.shop.order.controller;

import com.alibaba.fastjson.JSON;
import com.johnny.shop.entity.Order;
import com.johnny.shop.entity.Product;
import com.johnny.shop.order.fegin.ProductService;
import com.johnny.shop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class OrderController2 {

    private final OrderService orderService;
    private final ProductService productService;

    @GetMapping("/order2/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接受到{}号商品的下单请求，接下来调用商品微服务查询此商品信息", pid);

        Product product = productService.getProductByPid(pid);
        log.info("查询到{}号商品的信息，内容是：{}", pid, JSON.toJSONString(product));

        // 模拟一次网络延时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        // orderService.save(order);
        log.info("创建订单成功，订单信息为{}", JSON.toJSONString(order));
        return order;
    }

    @GetMapping("/order/message")
    public String message() {
        return "高并发下问题测试";
    }
}
