package com.example.BankApp.services;


import com.example.BankApp.models.Account;
import com.example.BankApp.repositories.AccountHolderRepository;
import com.example.BankApp.repositories.AccountRepository;
import com.example.BankApp.users.AccountHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.util.List;

public class AccountHoldersService{

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAccountHolderAccount (long id, String secretKey){
        accountHolderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
        return accountHolderRepository.findByIdAndSecretKey(id, secretKey);
    }

    public Account getAccount (long id, String secretKey){
       return accountRepository.findByIdAndSecretKey(id,secretKey);
    }



}
