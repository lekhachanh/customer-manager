package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService ;
    @GetMapping ("/view")
    public ModelAndView findAll (){
        List <Customer> customerList = customerService.findAll();

        ModelAndView modelAndView = new ModelAndView("/customer/view");
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }
    @GetMapping("/create")//
    public String create(Model model) {
        model.addAttribute("customers", new Customer());
        return "/customer/create";
    }
    @PostMapping("/save")
    //handle method save()
    public ModelAndView save(Customer customer, RedirectAttributes redirect) {
        customer.setId((int)(Math.random() * 10000));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return findAll ();
    }

}
