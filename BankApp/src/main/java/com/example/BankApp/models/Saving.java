package com.example.BankApp.models;

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
    @DecimalMin(value = "100")
    private BigDecimal minimumBalance;
    private LocalDate creationDate;
    private BigDecimal interestRate;

    public Saving() {
    }

    public Saving(BigDecimal balance, User primaryOwner, BigDecimal penaltyFee, AccountStatus status, String secretKey, BigDecimal minimumBalance, LocalDate creationDate, BigDecimal interestRate) {
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
        if(minimumBalance.compareTo(BigDecimal.valueOf(100)) == 1)
            this.minimumBalance = minimumBalance;
           else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
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
