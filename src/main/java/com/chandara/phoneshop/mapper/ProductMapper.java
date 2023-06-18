package com.chandara.phoneshop.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chandara.phoneshop.DTO.ProductDTO;
import com.chandara.phoneshop.Service.ColorService;
import com.chandara.phoneshop.Service.ModelService;
import com.chandara.phoneshop.entity.Product;

@Mapper(componentModel = "spring",uses = { ModelService.class,ColorService.class})
public interface ProductMapper {

	@Mapping(target = "model",source = "model_id")
	@Mapping(target = "color",source = "color_id")
	Product toProduct(ProductDTO productDTO);

}
