package com.johnny.shop.product.service.impl;

import com.johnny.shop.entity.Product;
import com.johnny.shop.product.dao.ProductDao;
import com.johnny.shop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <b>请输入名称</b>
 * <p>
 * 描述<br/>
 * 作用：；<br/>
 * 限制：；<br/>
 * </p>
 *
 * @author wan.liang(79274)
 * @date 2023/11/3 14:33
 */
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Override
    public Product findById(Integer pid) {
        Optional<Product> productOptional = productDao.findById(pid);
        return productOptional.orElse(null);
    }
}
