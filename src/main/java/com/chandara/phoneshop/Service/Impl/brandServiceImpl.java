package com.chandara.phoneshop.Service.Impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.chandara.phoneshop.Entity.Brand;
import com.chandara.phoneshop.Exception.ResourceNotFoundException;
import com.chandara.phoneshop.Repository.BrandRepository;
import com.chandara.phoneshop.Service.BrandService;

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
		return brandRepository.findAll(PageRequest.of(page, size,Sort.by("name")));
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

}
