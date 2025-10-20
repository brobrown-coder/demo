package com.example.demo.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.common.domain.Messenger;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage(Model model) {
		// Messenger 데이터 생성 및 모델에 추가
		List<Messenger> messages = new ArrayList<>();
		messages.add(new Messenger(1, "환영합니다! 웹사이트에 오신 것을 환영합니다."));
		messages.add(new Messenger(2, "새로운 기능이 업데이트되었습니다."));
		messages.add(new Messenger(3, "계산기 기능을 이용해보세요."));

		model.addAttribute("messages", messages);
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
