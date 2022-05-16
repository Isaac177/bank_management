package com.example.isaacbank.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

//I created a class called Account that I mapped to a single table named ACCOUNT
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
    @DiscriminatorColumn(name ="TYPE_ACC",discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Account implements Serializable {

    // Creating a table with the columns codeAccount, dateCreation, and balance.
    @Id
    private String codeAccount;
    private Date dateCreation;
    private double balance;

    // This is a many-to-one relationship between the table Account and table Client.
    @ManyToOne
    @JoinColumn(name = "CODE_CLI")
    private Client client;

    // Creating a one to many relationship between the table Account and table Operation.
    @OneToMany(mappedBy = "account")
    private Collection<Operation> operations;

    // Defined a constructor.
    public Account() {
        super();
    }
    // Created a constructor that is used to create an object of the class Account.
    public Account(String codeAccount, Date dateCreation, double balance, Client client) {
        this.codeAccount = codeAccount;
        this.dateCreation = dateCreation;
        this.balance = balance;
        this.client = client;
    }

    // Getters and setters methods.
    public String getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(String codeAccount) {
        this.codeAccount = codeAccount;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }
}
