package com.chandara.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chandara.phoneshop.DTO.BrandDTO;
import com.chandara.phoneshop.entity.Brand;
@Mapper
public interface BrandMapper{
	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
	
	Brand toBrand(BrandDTO dto);
	BrandDTO toBrandDTO(Brand brand);
}
