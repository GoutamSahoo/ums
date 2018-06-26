package com.jspiders.ums.controller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jspiders.ums.dto.RegisterDTO;
import com.jspiders.ums.model.service.RegistrationService;
@Controller
@RequestMapping("/")
public class RegistrationController 
{	
	final Logger logger=Logger.getLogger(RegistrationController.class);
	@Autowired
	private RegistrationService service;
	public RegistrationController() 
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	@RequestMapping(value="/register.do")
	public ModelAndView controllerRegister(RegisterDTO dto)
	{
		logger.info("inside controllerRegister method of RegistrationController class");
		System.out.println("inside controllerRegister method of RegistrationController class");
		
		service.serviceRegister(dto);
		
		logger.info("leaving controllerRegister method of RegistrationController class");
		
		return new ModelAndView("/register.jsp","key","registration successful,please login");
	}
}
