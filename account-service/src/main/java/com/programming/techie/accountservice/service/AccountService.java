package com.programming.techie.accountservice.service;

import org.springframework.stereotype.Service;

import com.programming.techie.accountservice.dto.AccountRequest;
import com.programming.techie.accountservice.model.Account;
import com.programming.techie.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
    
    private final AccountRepository accountRepository;

    public void addAccount(AccountRequest accountRequest){
        Account account = Account.builder()
                .accountId(accountRequest.getAccountId())
                .name(accountRequest.getName())
                .mobile(accountRequest.getMobile())
                .email(accountRequest.getEmail())
                .build();

                accountRepository.insert(account);
    }
}
