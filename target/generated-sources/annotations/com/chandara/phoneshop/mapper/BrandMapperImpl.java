package com.chandara.phoneshop.mapper;

import com.chandara.phoneshop.DTO.BrandDTO;
import com.chandara.phoneshop.entity.Brand;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-14T20:55:39+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 19.0.1 (Eclipse Adoptium)"
)
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand toBrand(BrandDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setId( dto.getId() );
        brand.setName( dto.getName() );

        return brand;
    }

    @Override
    public BrandDTO toBrandDTO(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        BrandDTO brandDTO = new BrandDTO();

        brandDTO.setId( brand.getId() );
        brandDTO.setName( brand.getName() );

        return brandDTO;
    }
}
