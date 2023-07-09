package com.chandara.phoneshop.Service.Impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.chandara.phoneshop.Service.BrandService;
import com.chandara.phoneshop.Specification.BrandFilter;
import com.chandara.phoneshop.Specification.BrandSpec;
import com.chandara.phoneshop.entity.Brand;
import com.chandara.phoneshop.exception.ResourceNotFoundException;
import com.chandara.phoneshop.repository.BrandRepository;
import com.chandara.phoneshop.util.PageUtil;
@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}
	@Override
	public Brand getById(Long id) {
		return brandRepository.findById(id)
			  // .orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("brand with id = %d not found",id)));
				.orElseThrow(()-> new ResourceNotFoundException("Brand",id));
	}
	@Override
	public Brand update(Long id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName()); 
		return brandRepository.save(brand);
	}
	@Override
	public List<Brand> getBrands() {
		return brandRepository.findAll();
	}
	@Override
	public List<Brand> getBrands(String name) {
		return brandRepository.findByName(name);
	}
	/*
	@Override
	public List<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();
		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		if(params.containsKey("id")) {
			String id  = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
//		int PageNumebr=1;
//		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
//			PageNumebr = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
//		}
//		int PageSize=10;
//		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
//			PageSize = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
//	Pageable pageable = PageUtil.getPageable(PageNumebr,PageSize);
//		}
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		return brandRepository.findAll(brandSpec);
	
	}
	*/
	@Override
	public Page<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();
		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		if(params.containsKey("id")) {
			String id  = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		int PageNumebr=PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			PageNumebr = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		int Pagelimit=PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			Pagelimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));  
		}
		Pageable pageable = PageUtil.getPageable(PageNumebr,Pagelimit);
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		Page<Brand> page = brandRepository.findAll(brandSpec,pageable);
		return page;
	
	}
	@Override
	public void delete(Long id){
		 Brand bandid = brandRepository.findById(id)
					                   .orElseThrow(()-> new ResourceNotFoundException("Brand",id));
		 brandRepository.delete(bandid);
	}
	
}
