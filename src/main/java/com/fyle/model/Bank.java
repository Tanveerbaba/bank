package com.fyle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bank")
    @JsonIgnore
    private List<BankBranches> bankBranches;

    public Bank() {}

    public Bank(String name, List<BankBranches> bankBranches) {
        this.name = name;
        this.bankBranches = bankBranches;
    }
}
