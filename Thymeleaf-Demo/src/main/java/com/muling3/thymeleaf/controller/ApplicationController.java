package com.muling3.thymeleaf.controller;

import com.muling3.thymeleaf.entity.Employee;
import com.muling3.thymeleaf.svc.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApplicationController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("employees", staffService.getAllEmployees());
        model.addAttribute("total", staffService.getAllEmployees().size());
        model.addAttribute("male", staffService.getMaleEmployees());
        model.addAttribute("female", staffService.getFemaleEmployees());
        return "home_page";
    }

    @GetMapping("/new")
    public String addEmployee( Model model){
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    @PostMapping("/new")
    public String createEmployee(@ModelAttribute("employee") Employee employee){
        staffService.addAnEmployee(employee);
        return  "redirect:/";
    }
    @PostMapping("/{id}")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, @PathVariable int id){
        staffService.updateEmployee(id, employee);
        return  "redirect:/";
    }
    @GetMapping("/{id}")
    public String editEmployee(@PathVariable int id, Model model){
        model.addAttribute("employee", staffService.getEmployee(id));
        return "edit_employee";
    }

    @GetMapping("/remove/{id}")
    public String deleteEmployee(@PathVariable int id){
        staffService.deleteEmployee(id);
        return "redirect:/";
    }
}
