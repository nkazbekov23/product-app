package com.productapp.productapp.service;

import com.productapp.productapp.dto.ProductDto;
import com.productapp.productapp.entities.Product;
import com.productapp.productapp.exception.NotFoundException;
import com.productapp.productapp.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final Mapper mapper;

    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = new Product();

        product.setLocalDateTime(productDto.getLocalDateTime());
        product.setTitle(productDto.getTitle());
        product.setUps(productDto.getUps());
        product.setPrice(productDto.getPrice());

        this.productRepository.save(product);

        return product;
    }

    @Override
    public List<ProductDto> getAll() {
        return this.productRepository.findAll()
                .stream()
                .map(product -> mapper.toProductDto(product, new ProductDto()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getBbyId(int id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("not found"));
        return mapper.toProductDto(product, new ProductDto());
    }

    @Override
    public void deleteProduct(int id) {
        Product product = productRepository.findById(id).orElseThrow(NotFoundException::new);
        this.productRepository.delete(product);
    }

    @Override
    public void updateProduct(int id, ProductDto productDto) {
        Product product = this.productRepository.findById(id).orElseThrow(NotFoundException::new);
        product.setTitle(productDto.getTitle());
        product.setLocalDateTime(productDto.getLocalDateTime());
        product.setUps(productDto.getUps());

    }
}
