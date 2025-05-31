package ua.opnu.shop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/user/home")
    public String userHome(){
        return "userHome";
    }
    @GetMapping("/admin/home")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/default")
    public String defaultAfterLogin(Authentication authentication){
        if (authentication.getAuthorities().stream().anyMatch(a-> a.getAuthority().equals("ROLE_ADMIN"))){
            return "redirect:/admin/home";
        }
        else if (authentication.getAuthorities().stream().anyMatch(a-> a.getAuthority().equals("ROLE_USER"))){
            return "redirect:/user/home";
        }
        else return "redirect:/login";
    }

}
