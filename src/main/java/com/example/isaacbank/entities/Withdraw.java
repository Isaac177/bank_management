package com.example.isaacbank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

//Another entity called "savingAccount" with constructor.
@Entity
@DiscriminatorValue("W")
public class Withdraw extends Operation{

    public Withdraw() {
        super();
    }

    public Withdraw(Date dateOperation, double amount, Account account) {
        super(dateOperation, amount, account);
    }
}
