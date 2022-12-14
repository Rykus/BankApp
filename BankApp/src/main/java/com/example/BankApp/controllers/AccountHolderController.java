package com.example.BankApp.controllers;

import com.example.BankApp.models.Account;
import com.example.BankApp.services.AccountHoldersService;
import com.example.BankApp.services.AdminsService;
import com.example.BankApp.users.AccountHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountHolderController {

    @Autowired
    AccountHoldersService accountHoldersService;

    @GetMapping("/getAccountList-user")
    @ResponseStatus(HttpStatus.OK)
    private List<Account> getAccounts(Long id, String secretKey) {
        return accountHoldersService.getAccountHolderAccount(id, secretKey);
    }

    @GetMapping("/getAccount-user")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccount(Long id,String secretKey){
        return accountHoldersService.getAccount(id,secretKey);
    }



}
