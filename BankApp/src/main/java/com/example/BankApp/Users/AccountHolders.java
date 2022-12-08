package com.example.BankApp.Users;

import com.example.BankApp.models.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountHolders extends User{

    private LocalDate dateOfBirth;
    @Embedded
    private PrimaryAddress address;
    @Embedded
    private PrimaryAddress mailingAddress;

    @OneToMany(mappedBy = "primaryOwner")
    @JsonIgnore
    private List<Account> accountList = new ArrayList<>();

    public AccountHolders() {
    }

    public AccountHolders(String name, LocalDate dateOfBirth, PrimaryAddress address, PrimaryAddress mailingAddress) {
        super(name);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.mailingAddress = mailingAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PrimaryAddress getAddress() {
        return address;
    }

    public void setAddress(PrimaryAddress address) {
        this.address = address;
    }

    public PrimaryAddress getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(PrimaryAddress mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
