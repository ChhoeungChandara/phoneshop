package com.chandara.phoneshop.Service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.chandara.phoneshop.Entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	List<Brand> getAll();
	Brand getBrandById(Long id);
	Brand getBrandByName(String name);
	Page<Brand> pagenation(int page,int size);
	Brand Update(Brand brand,Long id);
	void Delete(Long id);
	Page<Brand> getBrands(Map<String, String> params);

}
