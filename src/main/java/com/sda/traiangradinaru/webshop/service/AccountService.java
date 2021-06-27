package com.sda.traiangradinaru.webshop.service;

import com.sda.traiangradinaru.webshop.model.Account;
import com.sda.traiangradinaru.webshop.repository.AccountRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public AccountService(AccountRepository accountRepository, BCryptPasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findByLogin(login);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(account.getLogin(), account.getPassword(), new ArrayList<>());
    }
    public void createAccount(Account account) {
        Account accountToBeSaved = new Account();
        accountToBeSaved.setLogin(account.getLogin());
        accountToBeSaved.setPassword(passwordEncoder.encode(account.getPassword()));
        accountToBeSaved.setBillingAddress(account.getBillingAddress());
        accountToBeSaved.setCreationDate(account.getCreationDate());
        accountRepository.save(accountToBeSaved);
    }
    public Boolean accountExist(String login) {
        Account accountExisting = accountRepository.findByLogin(login);
        return accountExisting != null;
    }
    public List<Account> findAll() {
        return StreamSupport.stream(accountRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
