package com.productapp.productapp.controller;

import com.productapp.productapp.dto.ProductDto;
import com.productapp.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProduct() {
       return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<?> findProductById(@PathVariable int productId) {
        return new ResponseEntity<>(productService.getBbyId(productId), HttpStatus.OK);
    }

//    @PostMapping("/update")
//    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductDto productDto) {
//        return new ResponseEntity<>(productService.updateProduct(id, productDto), HttpStatus.NO_CONTENT);
//    }
//
//    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
//        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
//    }
}
