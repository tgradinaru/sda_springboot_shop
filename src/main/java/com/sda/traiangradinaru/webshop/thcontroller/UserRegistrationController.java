package com.sda.traiangradinaru.webshop.thcontroller;

import com.sda.traiangradinaru.webshop.model.Account;
import com.sda.traiangradinaru.webshop.service.AccountService;
import com.sda.traiangradinaru.webshop.service.dto.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private final AccountService accountService; //final sa il injectam prin constructor

    public UserRegistrationController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDTO userDTO, BindingResult bindingResult) {
        if(accountService.accountExist(userDTO.getLogin())){
            bindingResult.rejectValue("login", "account already exists");
        }
        if(bindingResult.hasErrors()){
            return "registration";
        }
        Account account = new Account();
        account.setLogin(userDTO.getLogin());
        account.setPassword(userDTO.getPassword());
        account.setBillingAddress(userDTO.getEmail());
        account.setCreationDate(new Date());
        account.setClosed(false);
        account.setClosedDate(new Date());

        accountService.createAccount(account);

        return "redirect:/registration?success";
    }

}
