package com.example.BankApp.services;

import com.example.BankApp.dto.AccountDto;
import com.example.BankApp.models.Account;
import com.example.BankApp.models.AccountStatus;
import com.example.BankApp.models.Checking;
import com.example.BankApp.models.StudentChecking;
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
        if (accountHoldersRepository.findById(accountDto.getPrimaryOwner().getId()).isPresent()){
            AccountHolder accountHolders = accountHoldersRepository.findById(accountDto.getPrimaryOwner().getId()).get();
            Period intervalPeriod = Period.between(accountHolders.getDateOfBirth(), LocalDate.now());
            if (intervalPeriod.getYears() < 24){
                return accountRepository.save(new StudentChecking(accountDto.getBalance(), accountDto.getPrimaryOwner(), BigDecimal.valueOf(0),
                        AccountStatus.ACTIVE,accountDto.getSecretKey(),LocalDate.now()));
            }else return accountRepository.save(new Checking(accountDto.getBalance(),accountDto.getPrimaryOwner(),BigDecimal.valueOf(40),AccountStatus.ACTIVE,accountDto.getSecretKey(),
                    BigDecimal.valueOf(250),BigDecimal.valueOf(12),LocalDate.now()));
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
    }
}
