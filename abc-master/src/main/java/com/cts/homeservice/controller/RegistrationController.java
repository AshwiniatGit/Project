package com.cts.homeservice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.homeservice.bean.User;
import com.cts.homeservice.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("registerAdmin")
	public String getAdminRegistration() {
		return "registerAdmin";
	}
	
	@GetMapping("registerWorker")
	public String getWorkerRegistration() {
		return "registerWorker";
	}
	
	@GetMapping("registerUser")
	public String getUserRegistration(){
		return "registerUser";
	}
	
	
	@RequestMapping(value="registerUser.html", method=RequestMethod.POST)
	public ModelAndView validateAdmin(@ModelAttribute User user,  HttpSession httpSession) 
	{

		ModelAndView modelAndView = new ModelAndView();
		if(!userService.checkUser(user.getEmail())){
			int id = userService.getLastId() +1;
			user.setUserId(id);
			
		if("success".equals(userService.addUser(user)))
			modelAndView.setViewName("loginUser");
		}
		else	
		{
			modelAndView.addObject("error", "EmailId Already Exists!!");
			modelAndView.addObject("user", user);
			modelAndView.setViewName("registerUser");
		}
		return modelAndView;
	}
}



