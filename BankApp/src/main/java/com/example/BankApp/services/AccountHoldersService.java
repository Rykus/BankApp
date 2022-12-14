package com.example.BankApp.services;


import com.example.BankApp.models.Account;
import com.example.BankApp.repositories.AccountHolderRepository;
import com.example.BankApp.repositories.AccountRepository;
import com.example.BankApp.users.AccountHolder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountHoldersService{

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAccountHolderAccount (AccountHolder accountHolder){
        return accountHolder.getAccountList();
    }



}
