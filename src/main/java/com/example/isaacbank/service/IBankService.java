package com.example.isaacbank.service;

import com.example.isaacbank.entities.Account;
import com.example.isaacbank.entities.Operation;
import org.springframework.data.domain.Page;

import java.util.Optional;

// An interface that defines the methods that will be implemented in the BankService class.
public interface IBankService {

    public Optional<Account>checkAccount(String codeAccount);
    public void depose(String codeAccount , double amount);
    public void withdraw(String codeAccount , double amount);
    public void transfert(String codeAccount1 , String codeAccount2 , double amount);
    public Page<Operation> listOperation(String codeAccount , int page , int size);
    Optional<Account> findById(String id);
}
