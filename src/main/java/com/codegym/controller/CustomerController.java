package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ModelAndView findAll(){
        List <Customer> customerList = customerService.findAll();

        ModelAndView modelAndView = new ModelAndView("customer/view");
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }
    @GetMapping("/create")//
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }
    @PostMapping("/save")
    //handle method save()
    public String save(Customer customer, RedirectAttributes redirect) {
        customer.setId((int)(Math.random() * 10000));
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Saved customer successfully!");
        return "redirect:/customer/create";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id-1));
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirect) {
        customerService.update(customer.getId(), customer);
        redirect.addFlashAttribute("message", "Modified customer successfully!");
        return "redirect:/customer/edit";
    }

}
