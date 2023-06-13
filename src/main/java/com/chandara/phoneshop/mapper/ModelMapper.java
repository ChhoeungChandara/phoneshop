package com.chandara.phoneshop.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.chandara.phoneshop.DTO.ModelDTO;
import com.chandara.phoneshop.Service.BrandService;
import com.chandara.phoneshop.entity.Model;
@Mapper(componentModel = "spring",uses = {BrandService.class})
public interface ModelMapper {
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	
	@Mapping(target = "brand" ,source = "brandId")
	Model toModel(ModelDTO dto);
	@Mapping(target = "brandId" ,source = "brand.id")
	ModelDTO toModelDTO(Model model);

}
