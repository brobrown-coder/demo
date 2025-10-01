package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String loginPage() {
		return "login"; // resolves to templates/login.html via Thymeleaf
	}

	@GetMapping("/main")
	public String mainPage() {
		return "main"; // resolves to templates/main.html
	}

	@GetMapping("/cal")
	public String calPage() {
		return "cal"; // resolves to templates/cal.html
	}
}


