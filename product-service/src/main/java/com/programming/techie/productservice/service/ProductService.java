package com.programming.techie.productservice.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.programming.techie.productservice.dto.ProductRequest;
import com.programming.techie.productservice.dto.ProductResponse;
import com.programming.techie.productservice.model.Product;
import com.programming.techie.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void addProduct(ProductRequest productRequest){
        Product product = Product.builder()
                        .skuCode(productRequest.getSkuCode())
                        .name(productRequest.getName())
                        .description(productRequest.getDescription())
                        .price(productRequest.getPrice())
                        .build();
        productRepository.insert(product);
        log.info("product {} is saved", product.getId());
    }

     public void updateProduct(Product product){
         Product saveProduct = productRepository.findBySkuCode(product.getSkuCode())
             .orElseThrow(()->new RuntimeException(
                 String.format("can not find product by SkuCode %s", product.getSkuCode())
             ));
             saveProduct.setName(product.getName());
             saveProduct.setDescription(product.getDescription());
             saveProduct.setPrice(product.getPrice());
          
             productRepository.save(saveProduct);
     }

    public List<ProductResponse> getStock(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                // .id(product.getId())
                .skuCode(product.getSkuCode())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public Product getSkuCode(String skuCode){
        return productRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new RuntimeException(
            String.format("can not find product by name %s", skuCode)
        ));
    }

    public void deleteProduct(String skuCode){
        productRepository.deleteBySkuCode(skuCode);
    }
    
}
