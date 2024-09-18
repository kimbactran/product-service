package com.kimbactran.productservice.controller;

import com.kimbactran.productservice.dto.ProductReq;
import com.kimbactran.productservice.dto.ProductRes;
import com.kimbactran.productservice.model.Product;
import com.kimbactran.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductReq productReq){
        productService.createProduct(productReq);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRes> getAllProduct(){
        return productService.getAllProducts();
    }


}
