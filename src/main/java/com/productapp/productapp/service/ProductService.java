package com.productapp.productapp.service;

import com.productapp.productapp.dto.ProductDto;
import com.productapp.productapp.entities.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto productDto);

    List<ProductDto> getAll();

    ProductDto getBbyId(int id);

    void deleteProduct(int id);

    void updateProduct(int id, ProductDto productDto);
}
