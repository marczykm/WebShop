package pl.marczyk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marczyk.service.ProductService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by marcin on 07.09.15.
 */
@Controller
public class IndexController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("products", productService.getRecommendedProducts());
        return "index";
    }
}
