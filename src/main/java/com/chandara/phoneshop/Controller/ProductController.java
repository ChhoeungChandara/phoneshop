package com.chandara.phoneshop.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chandara.phoneshop.DTO.ProductDTO;
import com.chandara.phoneshop.Service.ProductService;
import com.chandara.phoneshop.entity.Product;
import com.chandara.phoneshop.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("product")
public class ProductController {
	private final ProductService productService;
	private final ProductMapper  productMapper;
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ProductDTO productDTO ){
	Product product = productMapper.toProduct(productDTO);
	 product = productService.create(product);
	return ResponseEntity.ok(product);
	}
	
	
}
