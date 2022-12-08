package com.example.BankApp.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class StudentChecking extends Account{

    private String secretKey;
    private LocalDate creationDate;
    public StudentChecking() {
    }

    public StudentChecking(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee, AccountStatus status, String secretKey, LocalDate creationDate) {
        super(balance, primaryOwner, penaltyFee, status);
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
