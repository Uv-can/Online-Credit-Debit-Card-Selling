package dbms.DBMSFinalProject.controller;

import dbms.DBMSFinalProject.helper.PasswordAuthenticator;
import dbms.DBMSFinalProject.model.Bank;
import dbms.DBMSFinalProject.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BankController {

    @Autowired
    private BankRepository bankRepo;

    @RequestMapping(value = "/search_bank_by_name", method = RequestMethod.POST)
    public String homePage(Model model, @RequestParam("bankSearch") String bankSearch) throws Exception {
        List<Bank> banks = new ArrayList<>();
        for (Bank bank : bankRepo.findAll()) {
            if (bank.getBank_name().toLowerCase().contains(bankSearch.toLowerCase().strip())) {
                banks.add(bank);
            }
        }
        model.addAttribute("banks", banks);
        return "home";
    }
}
