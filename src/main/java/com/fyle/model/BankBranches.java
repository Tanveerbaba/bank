package com.fyle.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="bank_branches")
public class BankBranches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ifsc")
    private String ifsc;

    @Column(name = "branch")
    private String branch;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "bank_name")
    private String bankName;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public BankBranches() {}

    public BankBranches(String branch, String address, String city, String district, String state, String bankName, Bank bank) {
        this.branch = branch;
        this.address = address;
        this.city = city;
        this.district = district;
        this.state = state;
        this.bankName = bankName;
        this.bank = bank;
    }
}
