package com.example.BankApp.repositories;


import com.example.BankApp.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ThirdPartyRepository  extends JpaRepository<ThirdParty, Long> {
}
