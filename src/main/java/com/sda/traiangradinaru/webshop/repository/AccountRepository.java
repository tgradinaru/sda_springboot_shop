package com.sda.traiangradinaru.webshop.repository;

import com.sda.traiangradinaru.webshop.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
/**
 * this Class is a mock for a functional database
 * */
@Repository
public class AccountRepository {
    private List<Account> accounts = new ArrayList<>();
    public List<Account> getAll(){
        return accounts;
    }
    public void save(Account account){
        accounts.add(account);
    }
}
