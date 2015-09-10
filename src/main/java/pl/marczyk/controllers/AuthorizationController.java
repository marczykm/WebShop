package pl.marczyk.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MMARCZYK on 2015-09-10.
 */
@Controller
public class AuthorizationController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityContextHolder.clearContext();
        return "redirect:/login?logout";
    }
}
