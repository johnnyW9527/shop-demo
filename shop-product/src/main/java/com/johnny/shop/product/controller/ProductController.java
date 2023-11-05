package com.johnny.shop.product.controller;

import com.alibaba.fastjson.JSON;
import com.johnny.shop.entity.Product;
import com.johnny.shop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>请输入名称</b>
 * <p>
 * 描述<br/>
 * 作用：；<br/>
 * 限制：；<br/>
 * </p>
 *
 * @author wan.liang(79274)
 * @date 2023/11/3 14:36
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProductByPid(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        log.info("获取到产品信息，{}", JSON.toJSONString(product));
        return product;
    }


}
