package com.prog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class UserController {
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
    
	
	@PostMapping("/register")
	public String register(@ModelAttribute com.prog.entity.UserDetails u )
	{
		System.out.println(u);
		return "redirect:/";
		
	}
	
}
