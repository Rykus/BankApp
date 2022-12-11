package com.example.BankApp.repositories;

import com.example.BankApp.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository <AccountHolder, Long> {
}
