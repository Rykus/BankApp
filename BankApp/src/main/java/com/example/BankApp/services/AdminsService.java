package com.example.BankApp.services;

import com.example.BankApp.dto.AccountDto;
import com.example.BankApp.models.*;
import com.example.BankApp.repositories.AccountHoldersRepository;
import com.example.BankApp.repositories.AccountRepository;
import com.example.BankApp.users.AccountHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;


public class AdminsService {
    @Autowired
    AccountHoldersRepository accountHoldersRepository;
    @Autowired
    AccountRepository accountRepository;

    public Account createChecking(AccountDto accountDto) {
        AccountHolder primaryOwner = accountHoldersRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe"));
        AccountHolder secondaryOwner = null;
        if(accountDto.getSecondaryOwnerId() != null) secondaryOwner =  accountHoldersRepository.findById(accountDto.getSecondaryOwnerId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe"));

        if(Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears() < 24){
            StudentChecking studentChecking = new StudentChecking();
            return accountRepository.save(studentChecking);
        }
        Checking checking = new Checking();
        return accountRepository.save(checking);
    }

    public Account createSaving (AccountDto accountDto){
        if (accountHoldersRepository.findById(accountDto.getPrimaryOwner().getId()).isPresent()){
            return accountRepository.save(new Saving(accountDto.getBalance(),accountDto.getPrimaryOwner(),BigDecimal.valueOf(12),AccountStatus.ACTIVE,accountDto.getSecretKey(),))
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");}
}
