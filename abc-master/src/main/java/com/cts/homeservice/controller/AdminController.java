package com.cts.homeservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("adminPanel.html")
	public String getAdminPanel() {
		return "adminPanel";
	}
}
