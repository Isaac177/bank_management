package com.example.isaacbank;

import com.example.isaacbank.dao.AccountRepository;
import com.example.isaacbank.dao.ClientRepository;
import com.example.isaacbank.dao.OperationRepository;
import com.example.isaacbank.entities.*;
import com.example.isaacbank.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

/**
 * This class is the main class of the application.
 */
@SpringBootApplication
public class IsaacbankApplication implements CommandLineRunner {

    // Used to inject the dependencies of the class.
    @Autowired
    public ClientRepository clientRepository;
    @Autowired
    public AccountRepository accountRepository;
    @Autowired
    public OperationRepository operationRepository;
    @Autowired
    public IBankService iBankService;

    //The main function of our app.
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(IsaacbankApplication.class, args);
    }

    // A method that is called when the application starts. It is used to initialize the database with some data.
    @Override
    public void run(String... args) throws Exception {

        Client c1 = clientRepository.save(new Client("KHALIL","Khalil@gmail.com"));
        Client c2 = clientRepository.save(new Client("OUSSAMA","Oussa@gmail.com"));
        Client c3 = clientRepository.save(new Client("NIYA","abdo@gmail.com"));

        Account cp1  = accountRepository.save(new CurrentAccount("0001",new Date(),9000,c1,6000 ));
        Account cp2  = accountRepository.save(new CurrentAccount("0002",new Date(),8000,c2,6000 ));
        Account cp3  = accountRepository.save(new CurrentAccount("0003",new Date(),7000,c3,6000 ));

        Account cp4 = accountRepository.save(new SavingAccount("0004",new Date(),5000,c1,5));
        Account cp5 = accountRepository.save(new SavingAccount("0005",new Date(),4000,c2,6));
        Account cp6 = accountRepository.save(new SavingAccount("0006",new Date(),3000,c3,7));

        Operation op1 = operationRepository.save(new Deposit(new Date() , 3000 , cp1));
        Operation op2 = operationRepository.save(new Deposit(new Date() , 3000 , cp1));
        Operation op3 = operationRepository.save(new Deposit(new Date() , 3000 , cp1));
        Operation op4 = operationRepository.save(new Deposit(new Date() , 3000 , cp1));
        Operation op5 = operationRepository.save(new Deposit(new Date() , 3000 , cp1));
        Operation op6 = operationRepository.save(new Deposit(new Date() , 3000 , cp1));
        Operation op7 = operationRepository.save(new Deposit(new Date() , 3000 , cp1));
        Operation op8 = operationRepository.save(new Deposit(new Date() , 3000 , cp1));
        Operation op9 = operationRepository.save(new Deposit(new Date() , 3000 , cp1));
        Operation op10 = operationRepository.save(new Deposit(new Date() , 3000 , cp1));
        Operation op11 = operationRepository.save(new Deposit(new Date() , 2000 , cp2));
        Operation op12 = operationRepository.save(new Withdraw(new Date() , 1000 , cp3));
    }
}
