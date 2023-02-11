package com.programming.techie.accountservice.dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequest {
    
    @Id
    private String id;
    private String accountId;
    private String name;
    private String mobile;
    private String email;
}
