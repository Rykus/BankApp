package com.example.BankApp.services;


import com.example.BankApp.dto.TransferDto;
import com.example.BankApp.models.Account;
import com.example.BankApp.repositories.AccountHolderRepository;
import com.example.BankApp.repositories.AccountRepository;
import com.example.BankApp.users.AccountHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.math.BigDecimal;
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

    public void transfer (TransferDto transferDto){
        BigDecimal money = transferDto.getMoneyToTransfer();
        Long IdmoneyTo = transferDto.getToAccountId();
        Long IdmoneyFrom = transferDto.getFromAccountId();
        Account accountTo = accountRepository.getReferenceById(IdmoneyTo);
        Account accountFrom = accountRepository.getReferenceById(IdmoneyFrom);
        BigDecimal AccountMoneyFrom = accountFrom.getBalance();
        BigDecimal AccountMoneyTo = accountTo.getBalance();
        AccountMoneyFrom.add(money);
        AccountMoneyTo.subtract(money);
        accountTo.setBalance(AccountMoneyTo);
        accountFrom.setBalance(AccountMoneyFrom);
        accountRepository.save(accountTo);
        accountRepository.save(accountFrom);
    }



}
