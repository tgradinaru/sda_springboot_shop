package com.sda.traiangradinaru.webshop.service;

import com.sda.traiangradinaru.webshop.model.Account;
import com.sda.traiangradinaru.webshop.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final AccountRepository accountRepository;

    // Injected by Spring by constructor
    public CustomerService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addCustomer(Account account){
        accountRepository.save(account);
    }
    public List<Account> getCustomerAccounts(){
        return accountRepository.getAll();
    }
}
