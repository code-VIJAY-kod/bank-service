package com.learning.bank.service.app.repository;

import com.learning.bank.service.app.entity.BankCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCustomerRepository extends JpaRepository<BankCustomer,Integer> {
}
