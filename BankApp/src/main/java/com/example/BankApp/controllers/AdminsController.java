package com.example.BankApp.controllers;

import com.example.BankApp.dto.AccountDto;
import com.example.BankApp.models.Account;
import com.example.BankApp.models.AccountStatus;
import com.example.BankApp.services.AdminsService;
import com.example.BankApp.users.AccountHolder;
import com.example.BankApp.users.Admins;
import com.example.BankApp.users.ThirdParty;
import com.example.BankApp.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AdminsController {
    @Autowired
    AdminsService adminsService;

    @PostMapping("/createChecking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createChecking (@RequestBody AccountDto accountDto){
        return adminsService.createChecking(accountDto);
    }
    @PostMapping("/createSaving")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createSaving (@RequestBody AccountDto accountDto){
        return adminsService.createSaving(accountDto);
    }
    @PostMapping("/createCreditCard")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createCreditCard (@RequestBody AccountDto accountDto){
        return adminsService.createCreditCard(accountDto);
    }
    @PostMapping("/createAccountHolder")
    @ResponseStatus(HttpStatus.CREATED)
    public User createAccountHolder (@RequestBody AccountHolder accountHolder){
        return adminsService.createAccountHolder(accountHolder);
    }

    @PostMapping("/createAdmins")
    @ResponseStatus(HttpStatus.CREATED)
    public User createAdmins (@RequestBody Admins admins){
        return adminsService.createAdmins(admins);
    }
    @PostMapping("/createThirdParty")
    @ResponseStatus(HttpStatus.CREATED)
    public User createThirdParty (@RequestBody ThirdParty thirdParty){
        return adminsService.createThirdParty(thirdParty);
    }

    @PatchMapping("/modifyBalance")
    @ResponseStatus(HttpStatus.OK)
    private Account modifyBalance(@RequestBody Account account, BigDecimal newBalance){
        return adminsService.modifyBalance(account, newBalance);
    }

    @DeleteMapping ("/deleteAccount")
    @ResponseStatus(HttpStatus.OK)
    private void deleteAccount(@RequestBody Account account){
        deleteAccount(account);
    }

    @DeleteMapping ("/deleteAccountHolder")
    @ResponseStatus(HttpStatus.OK)
    private void deleteAccountHolder(@RequestBody AccountHolder accountHolder){
        deleteAccountHolder(accountHolder);
    }









}
