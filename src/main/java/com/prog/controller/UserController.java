package com.prog.controller;

import com.prog.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userDetailsRepository.findAll());
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute com.prog.entity.UserDetails userDetails) {
        System.out.printf("saving %s", userDetails);
        userDetailsRepository.save(userDetails);
        System.out.printf("done saving %s", userDetails);
        return "redirect:/";
    }
}
