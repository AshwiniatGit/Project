package com.cts.homeservice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

	
	@RequestMapping(value="userPanelProfile.html", method=RequestMethod.GET)
	public String getUserPanelProfile()
	{
		return "userPanelProfile";
	}
	
	
	
	@RequestMapping(value="userRequestStatus.html", method=RequestMethod.GET)
	public String getUserRequestStatus()
	{
		return "userRequestStatus.html";
	}
	

	@RequestMapping(value="request.html", method=RequestMethod.GET)
	public ModelAndView getRequestPage(@RequestParam("service")String service)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("service", service);
		modelAndView.setViewName("request");
		return modelAndView;
	}
	
}
