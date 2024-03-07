package com.chandara.phoneshop.Controller;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chandara.phoneshop.DTO.BrandDTO;
import com.chandara.phoneshop.DTO.PageDTO;
import com.chandara.phoneshop.Entity.Brand;
import com.chandara.phoneshop.Mapper.BrandMapper;
import com.chandara.phoneshop.Service.BrandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class brandController {
	private final BrandService brandService;
	@PostMapping
	public ResponseEntity<?> save(@RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brandService.create(brand)));
	}
	
	@GetMapping("/getAllBrand")
	public ResponseEntity<?> getAll(){
		List<BrandDTO> list = brandService.getAll().stream()
				                                   .map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
				                                   .collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getBrandById(@PathVariable Long id){
		return ResponseEntity.ok(brandService.getBrandById(id));
	}
	@GetMapping("filter")
	public ResponseEntity<?> getBrandByName(@RequestParam("name")String name){
		return ResponseEntity.ok(brandService.getBrandByName(name));
	}
	/*
	@GetMapping
	public ResponseEntity<?> pagenation(@RequestParam(value = "page",defaultValue = "0") int page,
			                            @RequestParam(value = "size",defaultValue = "10") int size ){
		return ResponseEntity.ok(brandService.pagenation(page, size));
	}
	*/
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateBrand(@RequestBody Brand brand,@PathVariable Long id){
		return ResponseEntity.ok(brandService.Update(brand, id));
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable Long id){
		brandService.Delete(id);
		return ResponseEntity.ok().build();
	}
	/*
	@GetMapping
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){
		List<BrandDTO> list = brandService.getBrands(params)
		.stream()
		.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
		.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
	*/
	@GetMapping
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){
		 Page<Brand> pages = brandService.getBrands(params);
		 PageDTO pageDTO = new PageDTO(pages);
		return ResponseEntity.ok(pageDTO);
	}
}
