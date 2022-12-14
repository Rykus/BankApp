package com.example.BankApp.transfer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal moneyToTransfer;
    private Long fromAccountId;
    private Long toAccountId;
    private String fromAccountName;
    private String fromSecretKey;

    public Transfer() {    }

    public Transfer(BigDecimal moneyToTransfer, Long fromAccountId, Long toAccountId, String fromAccountName, String fromSecretKey) {
        this.moneyToTransfer = moneyToTransfer;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.fromAccountName = fromAccountName;
        this.fromSecretKey = fromSecretKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMoneyToTransfer() {
        return moneyToTransfer;
    }

    public void setMoneyToTransfer(BigDecimal moneyToTransfer) {
        this.moneyToTransfer = moneyToTransfer;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public String getFromAccountName() {
        return fromAccountName;
    }

    public void setFromAccountName(String fromAccountName) {
        this.fromAccountName = fromAccountName;
    }

    public String getFromSecretKey() {
        return fromSecretKey;
    }

    public void setFromSecretKey(String fromSecretKey) {
        this.fromSecretKey = fromSecretKey;
    }
}
