package com.chandara.phoneshop.ServiceImpl;

import org.springframework.stereotype.Service;

import com.chandara.phoneshop.Service.ProductService;
import com.chandara.phoneshop.entity.Product;
import com.chandara.phoneshop.exception.ResourceNotFoundException;
import com.chandara.phoneshop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ProdductServiceImpl implements ProductService{
	private final ProductRepository productRepository;

	@Override
	public Product create(Product product) {
		String name = "%s %s ".formatted(product.getModel().getName(),product.getColor().getName());
		product.setName(name);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id)
				                .orElseThrow(()-> new ResourceNotFoundException("product", id));
	}

}
