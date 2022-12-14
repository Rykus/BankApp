package com.example.BankApp.repositories;

import com.example.BankApp.models.Account;
import com.example.BankApp.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountHolderRepository extends JpaRepository <AccountHolder, Long> {

    List<Account> findByIdAndSecretKey(long id, String secretKey);
    AccountHolder findBySecretKey(String secretKey);
    Account findByIdAndSecretKeyAndId(Long id, String secretKey);
}
