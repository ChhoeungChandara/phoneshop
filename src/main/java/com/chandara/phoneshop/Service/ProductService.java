package com.chandara.phoneshop.Service;

import com.chandara.phoneshop.entity.Product;

public interface ProductService {
	Product create(Product product);
	Product getById(Long id);
}
