package com.example.isaacbank.service;

import com.example.isaacbank.dao.AccountRepository;
import com.example.isaacbank.dao.ClientRepository;
import com.example.isaacbank.dao.OperationRepository;
import com.example.isaacbank.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;



 //This class is a service class that implements the IBankService interface. It has three repositories as attributes

@Service
@Transactional
public class IBankServiceImp implements IBankService {
    @Autowired
    public AccountRepository accountRepository;
    @Autowired
    public OperationRepository operationRepository;
    @Autowired
    public ClientRepository clientRepository;


     //We created a  function to check if the account exists in the database
    @Override
    public Optional<Account> checkAccount(String codeAccount) {
        Optional<Account> cp = accountRepository.findById(codeAccount);
        if(cp==null) throw new RuntimeException("No such account!");
        return cp;
    }

    //We created a function that returns an Optional object that contains an Account object if the account exists in the database, or
    //an empty Optional object if the account does not exist in the database

    @Override
    public Optional<Account> findById(String codeAccount) {
        return accountRepository.findById(codeAccount);
    }

   //Then we created a function that deposits money into the account.
    @Override
    public void depose(String codeAccount, double amount) {
        if(findById(codeAccount).isPresent()){
        Optional<Account> cp = findById(codeAccount);

        Deposit v = new Deposit(new Date() , amount, cp.get());
        operationRepository.save(v);

        cp.get().setBalance(cp.get().getBalance()+amount);
        accountRepository.save(cp.get());
        }
    }


    // A function that withdraws money from the account.
    @Override
    public void withdraw(String codeAccount, double amount) {
        Optional<Account> cp = findById(codeAccount);

        // It checks if the account exists, if it is a current account and if the balance is sufficient.
        if (findById(codeAccount).isPresent()) {

            // It checks if the account is a current account.
            if (cp.get() instanceof CurrentAccount) {

                // It checks if the balance is sufficient.
                if (cp.get().getBalance() < amount) {
                    throw new RuntimeException("You have an insufficient balance for this operation !");

                // This is the code that is executed when the account is a current account and the balance is sufficient.
                } else {
                    Withdraw r = new Withdraw(new Date(), amount, cp.get());
                    operationRepository.save(r);
                    cp.get().setBalance(cp.get().getBalance() - amount);
                    accountRepository.save(cp.get());
                }
            }
        }
    }

    // A function that transfers money from one account to another.
    @Override
    public void transfert(String codeAccount1, String codeAccount2, double amount) {
        if (!codeAccount1.equals(codeAccount2)) {
            withdraw(codeAccount1, amount);
            depose(codeAccount2, amount);
        }
        else{
            throw new RuntimeException("You can't send money to yourself");
        }

    }

    // A function that returns a page of operations.
    @Override
    public Page<Operation> listOperation(String codeAccount, int page, int size) {
        return operationRepository.listOperatiion(codeAccount,PageRequest.of(page,size));
    }
}
