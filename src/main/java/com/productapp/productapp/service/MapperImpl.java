package com.productapp.productapp.service;

import com.productapp.productapp.dto.ProductDto;
import com.productapp.productapp.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements Mapper {

    @Override
    public ProductDto toProductDto(Product product, ProductDto productDto) {
        productDto.setId(product.getId());
        productDto.setVersion(product.getVersion());
        productDto.setLocalDateTime(product.getLocalDateTime());
        productDto.setTitle(product.getTitle());
        product.setUps(product.getTitle());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    @Override
    public Product toProduct(ProductDto productDto, Product product) {
        return null;
    }
}
