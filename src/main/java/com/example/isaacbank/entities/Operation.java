package com.example.isaacbank.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


 //Created a class "Operation" which is an abstract class that is the parent of the classes Withdrawal and Deposit.

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP",discriminatorType = DiscriminatorType.STRING , length = 1)
public abstract class Operation implements Serializable {

    // Table's columns.
    @Id @GeneratedValue
    private Long id;
    private Date dateOperation;
    private double Amount;

    // This is a relationship between the class Operation and the class Account.
    @ManyToOne
    @JoinColumn(name = "code_cc")
    private Account account;

    //Getters and Setters Methods.
    public com.example.isaacbank.entities.Account getAccount() {
        return account;
    }

    public void setAccount(com.example.isaacbank.entities.Account account) {
        this.account = account;
    }

    public Operation() {
        super();
    }

    public Operation(Date dateOperation, double Amount, Account account) {
        this.dateOperation = dateOperation;
        this.Amount = Amount;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }


}
