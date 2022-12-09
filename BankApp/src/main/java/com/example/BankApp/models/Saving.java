package com.example.BankApp.models;

import com.example.BankApp.users.AccountHolder;
import com.example.BankApp.users.User;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Saving extends Account{

    private String secretKey;
    @DecimalMin(value = "1000")
    private BigDecimal minimumBalance = BigDecimal.valueOf(1000.00);
    private LocalDate creationDate = LocalDate.now();
    @DecimalMax(value = "0.5")
    private BigDecimal interestRate = BigDecimal.valueOf(0.0025);

    public Saving() {
    }

    public Saving(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                  String secretKey, BigDecimal minimumBalance, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
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
        if(minimumBalance.compareTo(BigDecimal.valueOf(100)) == 1)
            this.minimumBalance = minimumBalance;
           else throw new IllegalArgumentException("minimum balance must be at least 100€");
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
