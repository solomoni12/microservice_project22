package com.programming.techie.accountservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.accountservice.dto.AccountRequest;
import com.programming.techie.accountservice.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    
    private final AccountService accountservice;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addAccount(@RequestBody AccountRequest accountRequest){
        accountservice.addAccount(accountRequest);
        return "Account added successful";
    }

}
