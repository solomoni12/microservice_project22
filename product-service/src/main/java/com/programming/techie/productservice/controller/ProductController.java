package com.programming.techie.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.productservice.dto.ProductRequest;
import com.programming.techie.productservice.dto.ProductResponse;
import com.programming.techie.productservice.model.Product;
import com.programming.techie.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService; 
   
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest){
        productService.addProduct(productRequest);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ProductResponse> getStock(){
       return productService.getStock();
    }
    // @GetMapping("/{skuCode}")
    // public ResponseEntity<Product> getProductBySkuCode(@PathVariable String skuCode){
    //     return ResponseEntity.ok(productService.getSkuCode(skuCode));
    // }
    @DeleteMapping("/delete")
    public ResponseEntity<Product> deleteBySkuCode(@RequestParam String skuCode){
        productService.deleteProduct(skuCode);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
