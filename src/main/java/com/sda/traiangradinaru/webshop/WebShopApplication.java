package com.sda.traiangradinaru.webshop;

import com.sda.traiangradinaru.webshop.model.Account;
import com.sda.traiangradinaru.webshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(WebShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        // here we have the context --- now write your code
        Account account1 = new Account();
        account1.setId(1L);

        customerService.addCustomer(account1);

        customerService.getCustomerAccounts().forEach(System.out::println);

    }
}
