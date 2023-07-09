package com.chandara.phoneshop.Service.Impl;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.chandara.phoneshop.DTO.ProductSaleDTO;
import com.chandara.phoneshop.DTO.SaleDTO;
import com.chandara.phoneshop.Service.ProductService;
import com.chandara.phoneshop.Service.SaleService;
import com.chandara.phoneshop.entity.Product;
import com.chandara.phoneshop.entity.Sale;
import com.chandara.phoneshop.entity.SaleDetail;
import com.chandara.phoneshop.exception.ApiException;
import com.chandara.phoneshop.repository.ProductRepository;
import com.chandara.phoneshop.repository.SaleDetailRepository;
import com.chandara.phoneshop.repository.SaleRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class SaleServiceImpl implements SaleService{

	private final ProductService productService;
	private final ProductRepository productRepository;
	private final SaleDetailRepository saleDetailRepository;
	private final SaleRepository saleRepository;
	@Override
	public void sell(SaleDTO saleDTO) {
		List<Long> productIds = saleDTO.getProducts().stream()
				.map(ProductSaleDTO::getProductId)
				.toList();
			// validate product
		productIds.forEach(productService::getById);
		
		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
			.collect(Collectors.toMap(Product::getId, Function.identity()));
		
		
		// validate stock
		saleDTO.getProducts()
			.forEach(ps ->{
				Product product = productMap.get(ps.getProductId());
				if(product.getAvialableUnit() < ps.getNumberOfUnit()) {
					throw new ApiException(HttpStatus.BAD_REQUEST, "Product [%s] is not enough in stock".formatted(product.getName()));
				}
			});
		// Sale
				Sale sale = new Sale();
				sale.setSoldDate(saleDTO.getSaleDate());
				saleRepository.save(sale);
				
				// Sale Detail
				saleDTO.getProducts().forEach(ps ->{
					Product product = productMap.get(ps.getProductId());
					SaleDetail saleDetail = new SaleDetail();
					saleDetail.setAmount(product.getSalePrice());
					saleDetail.setProduct(product);
					saleDetail.setSale(sale);
					saleDetail.setUnit(ps.getNumberOfUnit());
					saleDetailRepository.save(saleDetail);
					
					// cut stock
					Integer availableUnit =  product.getAvialableUnit() - ps.getNumberOfUnit();
					product.setAvialableUnit(availableUnit);
					productRepository.save(product);
				});
			}
	private void saveSale(SaleDTO saleDTO) {
		Sale sale = new Sale();
		sale.setSoldDate(saleDTO.getSaleDate());
		saleRepository.save(sale);
		
		
		//Sale Detail
		saleDTO.getProducts().forEach(ps ->{
			SaleDetail saleDetail = new SaleDetail();
			saleDetail.setAmount(null);
		});
	}
	
	private void validate(SaleDTO saleDTO) {
		saleDTO.getProducts().forEach(ps ->{
			Product product = productService.getById(ps.getProductId());
			if(product.getAvialableUnit() < ps.getNumberOfUnit()) {
				throw new ApiException(HttpStatus.BAD_REQUEST, "Product [%s] is not enough in stock".formatted(product.getName()));
			}
		});
	}
	private void validate2(SaleDTO saleDTO) {
		List<Long> productIds = saleDTO.getProducts().stream()
			.map(ProductSaleDTO::getProductId)
			.toList();
		// validate product
		productIds.forEach(productService::getById);
		
		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
			.collect(Collectors.toMap(Product::getId, Function.identity()));
		
		
		// validate stock
		saleDTO.getProducts()
			.forEach(ps ->{
				Product product = productMap.get(ps.getProductId());
				if(product.getAvialableUnit() < ps.getNumberOfUnit()) {
					throw new ApiException(HttpStatus.BAD_REQUEST, "Product [%s] is not enough in stock".formatted(product.getName()));
				}
			});
		
	}
	
}

