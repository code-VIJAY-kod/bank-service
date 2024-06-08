package com.learning.bank.service.app.service;

import com.learning.bank.service.app.entity.BankCustomer;
import com.learning.bank.service.app.entity.Savings;
import com.learning.bank.service.app.repository.BankCustomerRepository;
import com.learning.bank.service.app.service.interfaces.BankCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankCustomerServiceImpl implements BankCustomerService {
    @Autowired
    private BankCustomerRepository bankCustomerRepository;
    @Override
    public String addCustomer(BankCustomer bankCustomer) {
         bankCustomerRepository.save(bankCustomer);
         return "Customer added successfully";
    }

    @Override
    public BankCustomer getCustomer(int id) {
        Optional<BankCustomer> customer = bankCustomerRepository.findById(id);
        if(customer.isPresent()){
          return   customer.get();
        }
        return null;
    }

    @Override
    public String deleteCustomer(int id) {
        Optional<BankCustomer> customer = bankCustomerRepository.findById(id);
        if(customer.isPresent()){
            bankCustomerRepository.deleteById(id);
            return "Customer delete successfully";
        }
        return "Customer not found";
    }
    @Override
    public String updateCustomer(BankCustomer bankCustomer) {
        Optional<BankCustomer> customer = bankCustomerRepository.findById(bankCustomer.getId());
        if(customer.isPresent()){
            bankCustomerRepository.save(bankCustomer);
            return "Customer updated successfully";
        }
        return "Customer not found";
    }

    @Override
    public Savings getBalance(int account) {
        return bankCustomerRepository.findById(account).get().getSavings();
    }
    @Override
    public BankCustomer accountDebit(int account,double amount) {
        Optional<BankCustomer> byId = bankCustomerRepository.findById(account);
        if(!byId.isPresent()){
            throw new RuntimeException("Account not found");
        }
        BankCustomer bankCustomer = byId.get();
        Savings savings = bankCustomer.getSavings();
        savings.setBalance(savings.getBalance()-amount);
        bankCustomer.setSavings(savings);
        bankCustomerRepository.save(bankCustomer);
        return bankCustomer;
    }

}
