package com.chandara.phoneshop.mapper;

import com.chandara.phoneshop.DTO.ModelDTO;
import com.chandara.phoneshop.Service.BrandService;
import com.chandara.phoneshop.entity.Brand;
import com.chandara.phoneshop.entity.Model;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-14T20:55:39+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 19.0.1 (Eclipse Adoptium)"
)
@Component
public class ModelMapperImpl implements ModelMapper {

    @Autowired
    private BrandService brandService;

    @Override
    public Model toModel(ModelDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Model model = new Model();

        model.setBrand( brandService.getById( dto.getBrandId() ) );
        model.setName( dto.getName() );

        return model;
    }

    @Override
    public ModelDTO toModelDTO(Model model) {
        if ( model == null ) {
            return null;
        }

        ModelDTO modelDTO = new ModelDTO();

        modelDTO.setBrandId( modelBrandId( model ) );
        modelDTO.setName( model.getName() );

        return modelDTO;
    }

    private Integer modelBrandId(Model model) {
        if ( model == null ) {
            return null;
        }
        Brand brand = model.getBrand();
        if ( brand == null ) {
            return null;
        }
        Integer id = brand.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
