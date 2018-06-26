package com.jspiders.ums.controller.forgetcontroller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jspiders.ums.dto.RegisterDTO;
import com.jspiders.ums.model.service.forgetservice.FogetService;
@Controller
@RequestMapping("/")
public class ForgetController 
{
	@Autowired
	private FogetService service;
	public ForgetController()
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	
	@RequestMapping(value="/forget.do")
	public ModelAndView controllerForget(HttpServletRequest req)
	{
		String email=req.getParameter("email");
		RegisterDTO fromdb=service.serviceForget(email);
		if(fromdb!=null)
		{
			service.updatePassword(fromdb.getEmail());
			return new ModelAndView("/login.jsp","key","allow user to chnage password");
		}
		else
		{
			return new ModelAndView("/forget.jsp","key","invalid credidentals");
		}
	}
}
