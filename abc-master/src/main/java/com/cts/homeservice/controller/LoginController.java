package com.cts.homeservice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.homeservice.bean.Admin;
import com.cts.homeservice.bean.User;
import com.cts.homeservice.bean.Worker;
import com.cts.homeservice.service.AdminService;
import com.cts.homeservice.service.UserService;
import com.cts.homeservice.service.WorkerService;

@Controller
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WorkerService workerService;	

@RequestMapping(value="loginUser.html", method=RequestMethod.GET)
public String getUserLogin()
{
	return "loginUser";
}

@RequestMapping(value="loginAdmin.html", method=RequestMethod.GET)
public String getAdminLoginPage()
{
	return "loginAdmin";
}

@GetMapping("loginWorker.html")
public String getWorkerLogin() {
	return "loginWorker";
}

@RequestMapping(value="loginAdmin.html", method=RequestMethod.POST)
public ModelAndView validateAdmin(@ModelAttribute Admin login,  HttpSession httpSession) 
{
	ModelAndView modelAndView = new ModelAndView();
	Admin admin1 = adminService.authenticateAdmin(login);
	if(adminService.authenticateAdmin(admin1)!=null)
	{
		modelAndView.setViewName("adminPanel");
	}
	return modelAndView;
}

@RequestMapping(value="loginUser.html", method=RequestMethod.POST)
public ModelAndView validateUser(@ModelAttribute User login,  HttpSession httpSession) 
{
	System.out.println("inside controller");
	ModelAndView modelAndView = new ModelAndView();
	User user1 = userService.authenticateUser(login);
	if(user1!=null)
	{
		httpSession.setAttribute("user", user1);
		modelAndView.addObject("user", user1);
		modelAndView.setViewName("userPanel");
	}
	return modelAndView;
}


@RequestMapping(value="registerUser.html", method=RequestMethod.GET)
public String registerUser()
{
	return "registerUser";
}


}
