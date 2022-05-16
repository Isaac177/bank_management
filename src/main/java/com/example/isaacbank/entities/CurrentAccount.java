package com.example.isaacbank.entities;



import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Currency;
import java.util.Date;


//Created a subclass of Account, "CurrentAccount", which has an additional attribute called overdraft.

@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends Account {
    //Attribute
    private double overdraft;

    //Constructor
    public CurrentAccount() {
        super();
    }

    public CurrentAccount(String codeAccount, Date dateCreation, double balance, Client client, double overdraft) {
        super(codeAccount, dateCreation, balance, client);
        this.overdraft = overdraft;
    }

    //Getter and Setter Methods.
    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
}
