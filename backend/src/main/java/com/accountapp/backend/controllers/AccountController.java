package com.accountapp.backend.controllers;

import com.accountapp.backend.domain.Account;
import com.accountapp.backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController()
@RequestMapping(path = "/backend")
public class AccountController
{
    @Autowired
    private AccountRepository accountRepository;

    private final Logger logger = Logger.getLogger(AccountController.class.getName());

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public @ResponseBody String createUser(@RequestBody Account account)
    {
        //logger.info(account.getFirstName());
        accountRepository.save(account);
        return "New account has been added";
    }

    @GetMapping(path = "/all/{id}")
    public @ResponseBody Account getUserWithId(@PathVariable("id") Long id)
    {
        return accountRepository.getById(id);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Account> getExistingUsers()
    {
        return accountRepository.findAll();
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public @ResponseBody String updateUserWithId(@RequestBody Account account)
    {
        accountRepository.save(account);
        return "User account: " + account + " has been updated";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteUserWithId(@PathVariable("id") Long id)
    {
        Account account = accountRepository.getById(id);
        accountRepository.delete(account);
        //accountRepository.delete(account);
        return "Account: " + account + " has been deleted!";
    }
}
