package com.example.BankApp.Users;

import jakarta.persistence.Entity;

@Entity
public class Admins extends User{

    public Admins() {
    }
    public Admins(String name) {
        super(name);
    }
}
