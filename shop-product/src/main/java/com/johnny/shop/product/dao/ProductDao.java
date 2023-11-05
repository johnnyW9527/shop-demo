package com.johnny.shop.product.dao;

import com.johnny.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * <b>请输入名称</b>
 * <p>
 * 描述<br/>
 * 作用：；<br/>
 * 限制：；<br/>
 * </p>
 *
 * @author wan.liang(79274)
 * @date 2023/11/3 14:31
 */
@Component
public interface ProductDao extends JpaRepository<Product, Integer> {
}
