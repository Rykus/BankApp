package com.example.BankApp.models;

import com.example.BankApp.users.AccountHolder;
import com.example.BankApp.users.User;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class StudentChecking extends Account{

    private String secretKey;
    private LocalDate creationDate = LocalDate.now();
    public StudentChecking() {
            }

    public StudentChecking(BigDecimal balance, AccountHolder primaryOwner,
                           AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
