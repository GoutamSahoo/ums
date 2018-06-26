package com.jspiders.ums.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jspiders.ums.dto.LoginDTO;
import com.jspiders.ums.dto.RegisterDTO;
import com.jspiders.ums.model.service.LoginService;
@Controller
@RequestMapping("/")
public class LoginController
{
	@Autowired
	private LoginService service;
	public LoginController(){
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	
	@RequestMapping(value="/login.do")
	public ModelAndView controllerLogin(LoginDTO dto,HttpServletRequest req)
	{
		RegisterDTO fromdb=service.serviceLogin(dto);
		HttpSession session=req.getSession();
		if(fromdb!=null)
		{
			session.setAttribute("key1", fromdb);
			return new ModelAndView("/home.jsp","key",fromdb.getName());
		}
		else
		{
			return new ModelAndView("/login.jsp","key","invalid Crededentals");
		}
	}
}
