package com.example.isaacbank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

//Created a JPA entity that extends the Operation class and is mapped to the D value of the discriminator column.
@Entity
@DiscriminatorValue("D")
public class Deposit extends Operation {

    public Deposit() {
        super();
    }
    // A constructor that is calling the super class constructor.
    public Deposit(Date dateOperation, double amount, Account account) {
        super(dateOperation, amount, account);
    }
}
