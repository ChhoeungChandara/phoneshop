package com.chandara.phoneshop.mapper;

import com.chandara.phoneshop.DTO.ProductDTO;
import com.chandara.phoneshop.Service.ColorService;
import com.chandara.phoneshop.Service.ModelService;
import com.chandara.phoneshop.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T19:43:27+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private ModelService modelService;
    @Autowired
    private ColorService colorService;

    @Override
    public Product toProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setModel( modelService.getById( productDTO.getModel_id() ) );
        product.setColor( colorService.getById( productDTO.getColor_id() ) );

        return product;
    }
}
