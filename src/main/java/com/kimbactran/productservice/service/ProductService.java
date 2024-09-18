package com.kimbactran.productservice.service;

import com.kimbactran.productservice.dto.ProductReq;
import com.kimbactran.productservice.dto.ProductRes;
import com.kimbactran.productservice.model.Product;
import com.kimbactran.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductReq productReq){
        Product product = Product.builder()
                .name(productReq.getName())
                .description(productReq.getDescription())
                .price(productReq.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} created", product.getId());
    }

    public List<ProductRes> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());

    }
    private ProductRes mapToProductResponse(Product product){
        return ProductRes.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
