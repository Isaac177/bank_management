package com.example.isaacbank.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


//Created another table "Client" with column code, name, email.

@Entity
public class Client implements Serializable {

    @Id @GeneratedValue
    private Long code;
    private String name;
    private String email;

    // Creating a one to many relationship between the client and the account.
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<Account> accounts;

    // Creating a constructor for the Client class.
    public Client() {
        super();
    }

    public Client(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }
    //Getters and Setters methods.
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }
}
