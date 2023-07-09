package com.chandara.phoneshop.Service;

import java.math.BigDecimal;

import com.chandara.phoneshop.DTO.ProductImportDTO;
import com.chandara.phoneshop.entity.Product;

public interface ProductService {
	Product create(Product product);
	Product getById(Long id);
	void importProduct(ProductImportDTO productImportDTO);
	void setSellPrice(Long productId, BigDecimal price);
	void validateStock(Long productId,Integer numberofUnit);
}
