package com.chandara.phoneshop.mapper;

import com.chandara.phoneshop.DTO.ProductDTO;
import com.chandara.phoneshop.DTO.ProductImportDTO;
import com.chandara.phoneshop.Service.ColorService;
import com.chandara.phoneshop.Service.ModelService;
import com.chandara.phoneshop.entity.Product;
import com.chandara.phoneshop.entity.ProductImportHistories;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-27T13:51:27+0700",
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

    @Override
    public ProductImportHistories toProductImportHistories(ProductImportDTO productImportDTO, Product product) {
        if ( productImportDTO == null && product == null ) {
            return null;
        }

        ProductImportHistories productImportHistories = new ProductImportHistories();

        if ( productImportDTO != null ) {
            productImportHistories.setDateImport( productImportDTO.getImportDate() );
            if ( productImportDTO.getProductUnit() != null ) {
                productImportHistories.setImport_unit( productImportDTO.getProductUnit().longValue() );
            }
            productImportHistories.setPricePerUnit( productImportDTO.getImportPrice() );
        }
        productImportHistories.setProduct( product );

        return productImportHistories;
    }
}
