package com.chandara.phoneshop.mapper;

import com.chandara.phoneshop.DTO.BrandDTO;
import com.chandara.phoneshop.entity.Brand;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T19:43:27+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand toBrand(BrandDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Brand brand = new Brand();

        if ( dto.getId() != null ) {
            brand.setId( dto.getId().longValue() );
        }
        brand.setName( dto.getName() );

        return brand;
    }

    @Override
    public BrandDTO toBrandDTO(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        BrandDTO brandDTO = new BrandDTO();

        if ( brand.getId() != null ) {
            brandDTO.setId( brand.getId().intValue() );
        }
        brandDTO.setName( brand.getName() );

        return brandDTO;
    }
}
