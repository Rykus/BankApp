package com.example.BankApp.controllers;

import com.example.BankApp.services.AccountHoldersService;
import com.example.BankApp.services.AdminsService;
import com.example.BankApp.users.AccountHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountHolderController {

    @Autowired
    AccountHoldersService accountHoldersService;
}
