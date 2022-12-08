package com.example.BankApp.controllers;

import com.example.BankApp.dto.AccountDto;
import com.example.BankApp.models.Account;
import com.example.BankApp.services.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminsController {
    @Autowired
    AdminsService adminsService;

    @PostMapping("/createChecking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createChecking (@RequestBody AccountDto accountDto){
        return adminsService.createChecking(accountDto);
    }









}
