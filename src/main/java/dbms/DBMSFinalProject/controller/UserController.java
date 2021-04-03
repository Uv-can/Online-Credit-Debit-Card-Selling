package dbms.DBMSFinalProject.controller;

import dbms.DBMSFinalProject.helper.BankSystemConstants;
import dbms.DBMSFinalProject.model.Bank;
import dbms.DBMSFinalProject.model.User;
import dbms.DBMSFinalProject.repository.BankRepository;
import dbms.DBMSFinalProject.service.BankService;
import dbms.DBMSFinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private BankService bankService;

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String signInPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("user") User user, Model model, HttpServletRequest request) throws Exception {
        int result = userService.doLogin(user);
        String userType = userService.getUserType(user);
        if (result == BankSystemConstants.success && !StringUtils.isEmpty(userType)) {
            if (BankSystemConstants.customer.equalsIgnoreCase(userType)) {
                model.addAttribute("banks", bankService.getAllBankList());
                model.addAttribute("user_loggedIn", true);
                model.addAttribute("user_name", userService.getUserName(user));
                return "home";
            } else {
                return "admin_portal";
            }
        } else {
            model.addAttribute("error_i", "The email or password is incorrect");
            return "signin";
        }
    }

}
