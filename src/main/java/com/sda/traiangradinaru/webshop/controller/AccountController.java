package com.sda.traiangradinaru.webshop.controller;

import com.sda.traiangradinaru.webshop.model.Account;
import com.sda.traiangradinaru.webshop.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account/create")
    public ResponseEntity<String> createAccount(@RequestBody Account account){
        if (accountService.accountExists(account.getLogin())){
            return ResponseEntity.badRequest().build();
        }

        accountService.createAccount(account);
        return ResponseEntity.ok("Account created");
    }
}
