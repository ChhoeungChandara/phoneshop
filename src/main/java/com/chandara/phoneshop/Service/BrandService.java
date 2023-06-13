package com.chandara.phoneshop.Service;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.chandara.phoneshop.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id,Brand brandUpdate);
	void delete(Integer id);
	List<Brand> getBrands();
	List<Brand> getBrands(String name);
	//List<Brand> getBrands(Map<String, String> params);
	Page<Brand> getBrands(Map<String, String> params);

}
