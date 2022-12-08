package com.example.BankApp.dto;

import com.example.BankApp.models.AccountStatus;
import com.example.BankApp.users.User;
import jakarta.persistence.ManyToOne;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {


    private BigDecimal balance;
    private User primaryOwner;
    private User secondaryOwner;

    private String secretKey;

    public AccountDto() {
    }

    public AccountDto(BigDecimal balance, User primaryOwner, String secretKey) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secretKey = secretKey;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(User primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public User getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(User secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
