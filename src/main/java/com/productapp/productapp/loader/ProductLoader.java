package com.productapp.productapp.loader;

import com.productapp.productapp.entities.Product;
import com.productapp.productapp.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@Log4j2
@RequiredArgsConstructor
@Component
public class ProductLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("products created...");

        Product product = Product.builder()
                .title("Apple mac book")
                .localDateTime(LocalDateTime.now())
                .price(getPrice())
                .ups("YUYUY").build();

        Product product2 = Product.builder()
                .title("Samsung not 12")
                .localDateTime(LocalDateTime.now())
                .price(getPrice())
                .ups("GHGHG").build();


        Product product3 = Product.builder()
                .title("Samsung galaxy s10")
                .localDateTime(LocalDateTime.now())
                .price(getPrice())
                .ups("IOIOI").build();

        Product product4 = Product.builder()
                .title("Xiaomi not 10")
                .localDateTime(LocalDateTime.now())
                .ups("KLKLK").build();

        Product product5 = Product.builder()
                .title("Asus Rog")
                .localDateTime(LocalDateTime.now())
                .price(getPrice())
                .ups("QWQWQ").build();

        log.info("products created ...");

        this.productRepository.save(product);
        this.productRepository.save(product2);
        this.productRepository.save(product3);
        this.productRepository.save(product4);
        this.productRepository.save(product5);
    }

    private BigDecimal getPrice() {
        return new BigDecimal(new Random().nextDouble()*1000);
    }
}
