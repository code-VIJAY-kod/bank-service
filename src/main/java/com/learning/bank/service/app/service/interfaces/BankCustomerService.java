package com.learning.bank.service.app.service.interfaces;

import com.learning.bank.service.app.entity.BankCustomer;

import java.beans.Customizer;

public interface BankCustomerService {
    String addCustomer(BankCustomer bankCustomer);
    BankCustomer getCustomer(int id);
    String deleteCustomer(int id);
    String updateCustomer(BankCustomer customer);
}
