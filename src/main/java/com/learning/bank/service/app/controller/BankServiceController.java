package com.learning.bank.service.app.controller;

import com.learning.bank.service.app.entity.BankCustomer;
import com.learning.bank.service.app.service.interfaces.BankCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BankServiceController {
    @Autowired
    private BankCustomerService bankCustomerService;

    @PostMapping("/add-customer")
    public ResponseEntity<String> addCustomer(@RequestBody BankCustomer bankCustomer){
        String rs = bankCustomerService.addCustomer(bankCustomer);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
    @GetMapping("/get-customer/{id}")
    public ResponseEntity<BankCustomer> getCustomer(@PathVariable("id") int id){
        BankCustomer rs = bankCustomerService.getCustomer(id);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
}
