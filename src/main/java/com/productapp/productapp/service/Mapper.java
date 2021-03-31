package com.productapp.productapp.service;


import com.productapp.productapp.dto.ProductDto;
import com.productapp.productapp.entities.Product;


public interface Mapper {

    ProductDto toProductDto(Product product, ProductDto productDto);

    Product toProduct(ProductDto productDto, Product product);
}
