package com.springboot.rmbankingsystem.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;

    @Column(name = "account_number")
    private int accountNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
