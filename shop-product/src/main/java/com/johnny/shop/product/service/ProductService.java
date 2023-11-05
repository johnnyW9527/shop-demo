package com.johnny.shop.product.service;

import com.johnny.shop.entity.Product;

/**
 * <b>请输入名称</b>
 * <p>
 * 描述<br/>
 * 作用：；<br/>
 * 限制：；<br/>
 * </p>
 *
 * @author wan.liang(79274)
 * @date 2023/11/3 14:32
 */
public interface ProductService {

    Product findById(Integer pid);

}
