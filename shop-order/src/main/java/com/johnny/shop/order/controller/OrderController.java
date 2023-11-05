package com.johnny.shop.order.controller;

import com.alibaba.fastjson.JSON;
import com.johnny.shop.entity.Order;
import com.johnny.shop.entity.Product;
import com.johnny.shop.order.fegin.ProductService;
import com.johnny.shop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.hypermedia.DiscoveredResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

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
//    private final RestTemplate restTemplate;
//    private final DiscoveryClient discoveryClient;
    private final ProductService productService;

    @GetMapping("/order/prod/{id}")
    public Order getOrder(@PathVariable("id") Integer id) {
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");

        // 从naco获取服务地址
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        int index = new Random().nextInt(instances.size());
//        String url = instances.get(index).getHost() + ":" + instances.get(index).getPort();
//        log.info(">>从nacos中获取到的微服务地址为:" + url);
//        //通过restTemplate调用商品微服务
//        Product product = restTemplate.getForObject(
//                "http://" + url +"/product/" + id, Product.class);
        Product product = productService.getProductByPid(id);

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
