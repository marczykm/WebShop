package pl.marczyk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.marczyk.service.ProductService;

/**
 * Created by marcin on 07.09.15.
 */
@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String products(@RequestParam(value = "page", required = false) Integer page, Model model){
        if (page == null)
            page = new Integer(0);
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("products", productService.findAll(page));
        model.addAttribute("totalPages", productService.getTotalPages());
        model.addAttribute("pages", productService.getListOfPagesNumber());
        model.addAttribute("currentPage", page);
        return "products";
    }

    @RequestMapping("/{id}")
    public String productDetails(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("product", productService.findOneBy(id));
        return "productDetails";
    }
}
