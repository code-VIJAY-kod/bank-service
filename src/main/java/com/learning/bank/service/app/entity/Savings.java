package com.learning.bank.service.app.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double balance;
    private String cardType;
    @OneToOne(cascade = CascadeType.ALL)
    private BankCustomer bankCustomer;
}
