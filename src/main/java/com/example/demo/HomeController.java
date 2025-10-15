package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage() {
		return "index"; // resolves to templates/index.html via Thymeleaf
	}

	@GetMapping("/cal")
	public String calPage() {
		return "contents/calculator/cal"; // resolves to templates/cal.html
	}

	@GetMapping("/contents/calculator/plus")
	public String plusPage() {
		return "contents/calculator/plus"; // resolves to templates/cal.html
	}

	@GetMapping("/contents/calculator/minus")
	public String minusPage() {
		return "contents/calculator/minus"; // resolves to templates/cal.html
	}

	@GetMapping("/contents/calculator/gob")
	public String gobPage() {
		return "contents/calculator/gob"; // resolves to templates/cal.html
	}

	@GetMapping("/contents/calculator/nanum")
	public String nanumPage() {
		return "contents/calculator/nanum"; // resolves to templates/cal.html
	}

	@GetMapping("/login")
	public String loginPage() {
		return "auth/login"; // resolves to templates/auth/login.html
	}
}


