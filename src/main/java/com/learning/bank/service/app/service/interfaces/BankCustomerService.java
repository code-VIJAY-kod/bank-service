package com.learning.bank.service.app.service.interfaces;

import com.learning.bank.service.app.entity.BankCustomer;
import com.learning.bank.service.app.entity.Savings;

import java.beans.Customizer;

public interface BankCustomerService {
    String addCustomer(BankCustomer bankCustomer);
    BankCustomer getCustomer(int id);
    String deleteCustomer(int id);
    String updateCustomer(BankCustomer customer);

    Savings getBalance(int account);
    BankCustomer accountDebit(int account,double amount);
}
