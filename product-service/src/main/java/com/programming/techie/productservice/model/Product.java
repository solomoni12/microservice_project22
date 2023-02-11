package com.programming.techie.productservice.model;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    private String id;
    @Field("skuCode")
    private String skuCode;
    @Field(name = "name")
    @Indexed(unique = true)
    private String name;
    @Field(name = "description")
    private String description;
    @Field(name = "price")
    private BigDecimal price;

}
