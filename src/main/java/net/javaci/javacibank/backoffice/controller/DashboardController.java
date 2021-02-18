package net.javaci.javacibank.backoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	
	@GetMapping({"/","index"})
	public String renderTemp() {
		/*if(true) {
			throw new RuntimeException();
		}*/
        return "dashboard";		
	}
	
	@GetMapping("page1")
	public String renderPage1() {
		return "page1";
	}
	
	@GetMapping("page2")
	public String renderPage2() {
		return "page1";
	}
}
