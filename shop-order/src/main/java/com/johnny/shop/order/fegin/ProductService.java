package com.johnny.shop.order.fegin;

import com.johnny.shop.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-product")
public interface ProductService {

    @GetMapping(value = "/product/{id}")
    Product getProductByPid(@PathVariable("id") Integer pid);


}
