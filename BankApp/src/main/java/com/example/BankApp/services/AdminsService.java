package com.example.BankApp.services;

import com.example.BankApp.dto.AccountDto;
import com.example.BankApp.models.*;
import com.example.BankApp.repositories.AccountHolderRepository;
import com.example.BankApp.repositories.AccountRepository;
import com.example.BankApp.repositories.AdminsRepository;
import com.example.BankApp.repositories.ThirdPartyRepository;
import com.example.BankApp.users.AccountHolder;
import com.example.BankApp.users.Admins;
import com.example.BankApp.users.ThirdParty;
import com.example.BankApp.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;


public class AdminsService {
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AdminsRepository adminsRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    public Account createChecking(AccountDto accountDto) {
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
        AccountHolder secondaryOwner = null;
        if (accountDto.getSecondaryOwnerId() != null)
            secondaryOwner = accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));

        if (Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears() < 24) {
            StudentChecking studentChecking = new StudentChecking(accountDto.getBalance(), primaryOwner, secondaryOwner, accountDto.getSecretKey());
            return accountRepository.save(studentChecking);
        }
        Checking checking = new Checking(accountDto.getBalance(), primaryOwner, secondaryOwner, accountDto.getSecretKey(), accountDto.getMinimumBalance(), accountDto.getMonthlyMaintenanceFee());
        return accountRepository.save(checking);
    }

    public Account createSaving(AccountDto accountDto) {
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
        AccountHolder secondaryOwner = null;
        if (accountDto.getSecondaryOwnerId() != null)
            secondaryOwner = accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
        Saving saving = new Saving(accountDto.getBalance(), primaryOwner, secondaryOwner, accountDto.getSecretKey(), accountDto.getMinimumBalance(), accountDto.getInterestRate());
        return accountRepository.save(saving);
    }

    public Account createCreditCard(AccountDto accountDto) {
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
        AccountHolder secondaryOwner = null;
        if (accountDto.getSecondaryOwnerId() != null)
            secondaryOwner = accountHolderRepository.findById(accountDto.getSecondaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
        CreditCard creditCard = new CreditCard(accountDto.getBalance(),primaryOwner,secondaryOwner,accountDto.getCreditLimit(),accountDto.getInterestRate());
        return accountRepository.save(creditCard);
     }

    public User createAccountHolder (AccountHolder accountHolder){
       return accountHolderRepository.save(accountHolder);
    }

    public User createAdmins (Admins admin){
     return adminsRepository.save(admin);
    }
    public User createThirdParty (ThirdParty thirdParty){
        return thirdPartyRepository.save(thirdParty);
    }

    public Account modifyBalance (Account account,BigDecimal newBalance){
        accountHolderRepository.findById(account.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

    public void deleteAccount (Account account){
        accountRepository.findById(account.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
        accountRepository.delete(account);
    }

    public void deleteAccountHolder (AccountHolder accountHolder){
        accountHolderRepository.findById(accountHolder.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
        accountHolderRepository.delete(accountHolder);
    }


}



