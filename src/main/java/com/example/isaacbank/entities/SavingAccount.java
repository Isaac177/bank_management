package com.example.isaacbank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

//Another entity called "savingAccount" with constructor with get and set methods.
@Entity
@DiscriminatorValue("SA")
public class SavingAccount extends Account {

    private double rate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(String codeAccount, Date dateCreation, double balance, Client client, double rate) {
        super(codeAccount, dateCreation, balance, client);
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
