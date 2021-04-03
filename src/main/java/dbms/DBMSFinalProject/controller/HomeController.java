package dbms.DBMSFinalProject.controller;

import dbms.DBMSFinalProject.model.Bank;
import dbms.DBMSFinalProject.model.User;
import dbms.DBMSFinalProject.repository.BankRepository;
import dbms.DBMSFinalProject.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    String applicationName;

    @Autowired
    private BankService bankService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("banks", bankService.getAllBankList());
        model.addAttribute("user_loggedIn", false);
        return "home";
    }

    @GetMapping("/forgot_password")
    public String forgotPassword(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "forgot_password";
    }
}
