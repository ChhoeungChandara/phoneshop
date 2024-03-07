package com.chandara.phoneshop.Service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.chandara.phoneshop.Entity.Brand;
import com.chandara.phoneshop.Exception.ResourceNotFoundException;
import com.chandara.phoneshop.Pagenation.PageUtil;
import com.chandara.phoneshop.Repository.BrandRepository;
import com.chandara.phoneshop.Service.BrandService;
import com.chandara.phoneshop.Service.Specificationn.brandFilter;
import com.chandara.phoneshop.Service.Specificationn.brandSpec;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class brandServiceImpl implements BrandService{

	private final BrandRepository brandRepository;
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}
	@Override
	public List<Brand> getAll() {
		return brandRepository.findAll();
	}
	@Override
	public Brand getBrandById(Long id) {
		return brandRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("brand",id));
	}
	@Override
	public Brand getBrandByName(String name) {
		return brandRepository.findByName(name);
	}
	@Override
	public Page<Brand> pagenation(int page, int size) {
		return brandRepository.findAll(PageRequest.of(page, size,Sort.by("id")));
	}
	@Override
	public Brand Update(Brand brand, Long id) {
		Brand brandId = getBrandById(id);
		brandId.setName(brand.getName());
		return brandRepository.save(brandId);
	}
	@Override
	public void Delete(Long id) {
		Brand brandId = getBrandById(id);
		brandRepository.delete(brandId);
		
	}
	@Override
	public Page<Brand> getBrands(Map<String, String> params) {
		brandFilter brandFilter = new brandFilter();
		
		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		
		if(params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Long.getLong(id));
		}
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		
		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		
		brandSpec brandSpec = new brandSpec(brandFilter);
		
		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
		
		
		 Page<Brand> page = brandRepository.findAll(brandSpec, pageable);
		return page;
	}
}
