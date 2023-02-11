package com.programming.techie.accountservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("account")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Account {
    
    @Id
    private String id;
    private String accountId;
    private String name;
    private String mobile;
    private String email;
}
