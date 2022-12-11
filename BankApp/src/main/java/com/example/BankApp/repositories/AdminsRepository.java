package com.example.BankApp.repositories;

import com.example.BankApp.users.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminsRepository  extends JpaRepository <Admins, Long> {
}
