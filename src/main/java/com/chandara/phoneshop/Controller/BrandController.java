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
import com.chandara.phoneshop.DTO.ModelDTO;
import com.chandara.phoneshop.DTO.PageDTO;
import com.chandara.phoneshop.Service.BrandService;
import com.chandara.phoneshop.Service.ModelService;
import com.chandara.phoneshop.entity.Brand;
import com.chandara.phoneshop.entity.Model;
import com.chandara.phoneshop.mapper.BrandMapper;
import com.chandara.phoneshop.mapper.ModelMapper;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("brands")
public class BrandController {
	
	private final BrandService brandService;
	private final ModelService modelService;
	private final ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<?> Create(@RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO); 
		brand = brandService.create(brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable long id){
		Brand brand= brandService.getById(id);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	} 	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody BrandDTO brandDTO){
		Brand brand= BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand brandUpdate = brandService.update(id, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brandUpdate));
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getBrands(){
		List<BrandDTO> list = brandService.getBrands()
		.stream()
		.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
		.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("filter")
	public ResponseEntity<?> getBrands (@RequestParam("name")String name){
		List<BrandDTO> list = brandService.getBrands(name)
		.stream()
		.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
		.collect(Collectors.toList());
		return ResponseEntity.ok(list);
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
	 Page<Brand> page = brandService.getBrands(params);
	 PageDTO pageDTO = new PageDTO(page);
		return ResponseEntity.ok(pageDTO );
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		brandService.delete(id);
		return ResponseEntity.ok("delete success");
	}
	@GetMapping("{id}/models")
	public ResponseEntity<?> getModelByBrand(@PathVariable Integer id){
		
		List<Model> brands = modelService.getByBrand(id);
		List<ModelDTO> list = brands.stream()
		              .map(modelMapper::toModelDTO)
		              .toList();
		return ResponseEntity.ok(list);
	} 
	
}
