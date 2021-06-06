package com.sda.traiangradinaru.webshop;

import com.sda.traiangradinaru.webshop.model.Account;
import com.sda.traiangradinaru.webshop.service.CustomerService;
import com.sda.traiangradinaru.webshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sda.traiangradinaru.webshop.repository")
@EntityScan(basePackages = "com.sda.traiangradinaru.webshop.model")
public class WebShopApplication implements CommandLineRunner {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MailService mailService;

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

        mailService.sendMail("traian.gradinaru@gmail.com",
                "client@example.com",
                "Mock subject example",
                "Mock mail body example");

    }
}
