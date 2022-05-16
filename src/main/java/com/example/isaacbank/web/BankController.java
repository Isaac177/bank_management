package com.example.isaacbank.web;

import com.example.isaacbank.entities.Account;
import com.example.isaacbank.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
public class BankController {

    // Injecting the IBankService interface into the BankController class.
    @Autowired
    public IBankService iBankService;

    //This returns the string "accounts" when the user navigates to the /operations URL
    @RequestMapping(value = "/operations")
    public String index(){
        return "accounts";
    }

    //This function is used to check the account by the codeAccount and return the account and the list of operations of
    //this account
     //@param model The model is an object that contains all the data that will be displayed on the view page.
     //@param codeAccount the account number
     //@param page the page number
     //@param size The number of elements per page.
    ///@return A list of operations

    @RequestMapping(value = "/checkAccount" , method = RequestMethod.GET)
    public String checkAccount(Model model, String codeAccount,
                            @RequestParam(name = "page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "4") int size){
        try{
            Account cp = iBankService.checkAccount(codeAccount).get();
            Page listOperations = iBankService.listOperation(codeAccount,page,size);
            model.addAttribute("account",cp);
            model.addAttribute("listOperations",listOperations);
            int[] pages = new int[listOperations.getTotalPages()];
            model.addAttribute("pages",pages);
            model.addAttribute("codeAccount",codeAccount);
        }catch (Exception e){
            model.addAttribute("exception","Account not found !");
        }
        return "accounts";
    }

     //A function that allows you to make a deposit, a withdrawal or a transfer.

    //@param model The model is a Map that is used to store the data that needs to be displayed on the view page.
     //@param typeOperation The type of operation to be performed.
     //@param codeAccount The account number
     //@param amount The amount of money to be deposited or withdrawn.
     //@param codeAccount2 The account number to which the transfer is made.
     //@return A String

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveOperation(Model model,  String typeOperation, String codeAccount, double amount, String codeAccount2){
      try{
          if(typeOperation.equals("DEP")){
              iBankService.depose(codeAccount, amount);
          }        if(typeOperation.equals("WITH")){
              iBankService.withdraw(codeAccount, amount);
          }  if(typeOperation.equals("TR")){
              iBankService.transfert(codeAccount, codeAccount2, amount);
          }
      }catch (Exception e){
          model.addAttribute("exception", e);
          return "redirect:/checkAccount?codeAccount="+codeAccount+"&error="+e.getMessage();
      }
        return "redirect:/checkAccount?codeAccount="+codeAccount;
    }
    @RequestMapping(value = "/")
    public String home(){
        return "redirect:operations";
    }
}
