package com.example.BankApp.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Saving extends Account{

    private String secretKey;
    private BigDecimal minimumBalance;
    private LocalDate creationDate;
    private BigDecimal interestRate;

    public Saving() {
    }

    public Saving(BigDecimal balance, String primaryOwner, BigDecimal penaltyFee, AccountStatus status, String secretKey, BigDecimal minimumBalance, LocalDate creationDate, BigDecimal interestRate) {
        super(balance, primaryOwner, penaltyFee, status);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.interestRate = interestRate;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
