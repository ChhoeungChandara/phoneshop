package com.chandara.phoneshop.Mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.chandara.phoneshop.DTO.BrandDTO;
import com.chandara.phoneshop.Entity.Brand;

@Mapper
public interface BrandMapper {
	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
	
	Brand toBrand(BrandDTO brandDTO);
	BrandDTO toBrandDTO(Brand brand);

}
