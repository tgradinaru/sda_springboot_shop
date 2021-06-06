package com.sda.traiangradinaru.webshop.service;

import com.sda.traiangradinaru.webshop.model.Account;
import com.sda.traiangradinaru.webshop.model.Customer;
import com.sda.traiangradinaru.webshop.repository.AccountRepository;
import com.sda.traiangradinaru.webshop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    // Injected by Spring  constructor
    public CustomerService(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void addCustomer(Account account, Customer customer) {
        accountRepository.save(account);
        customerRepository.save(customer);
    }

    public Iterable<Account> getCustomerAccounts() {
        return accountRepository.findAll();
    }
}
