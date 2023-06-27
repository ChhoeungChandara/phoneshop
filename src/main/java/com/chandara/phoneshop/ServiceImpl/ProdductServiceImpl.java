package com.chandara.phoneshop.ServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.chandara.phoneshop.DTO.ProductImportDTO;
import com.chandara.phoneshop.Service.ProductService;
import com.chandara.phoneshop.entity.Product;
import com.chandara.phoneshop.entity.ProductImportHistories;
import com.chandara.phoneshop.exception.ApiException;
import com.chandara.phoneshop.exception.ResourceNotFoundException;
import com.chandara.phoneshop.mapper.ProductMapper;
import com.chandara.phoneshop.repository.ProductImportHistoryRepository;
import com.chandara.phoneshop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ProdductServiceImpl implements ProductService{
	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository importHistoryRepository;
	private final ProductMapper productMapper;

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

	@Override
	public void importProduct(ProductImportDTO productImportDTO) {  
		Product product = getById(productImportDTO.getProductId());
		
		Integer availableUnit = 0;
		if(product.getAvialableUnit()!=null) {
			availableUnit=product.getAvialableUnit();
		}
		product.setAvialableUnit(availableUnit+productImportDTO.getProductUnit());
		
		productRepository.save(product);
		// save product import history
		ProductImportHistories ImportHistories = productMapper.toProductImportHistories(productImportDTO, product);
	    importHistoryRepository.save(ImportHistories);
	}


}
