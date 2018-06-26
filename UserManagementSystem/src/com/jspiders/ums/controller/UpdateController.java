package com.jspiders.ums.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jspiders.ums.dto.RegisterDTO;
import com.jspiders.ums.model.service.UpdateService;
@Controller
@RequestMapping("/")
public class UpdateController 
{
	@Autowired
	private UpdateService service;
	public UpdateController() 
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	@RequestMapping(value="/update.do")
	public ModelAndView controllerUpdate(RegisterDTO dto,HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		RegisterDTO dto1=(RegisterDTO) session.getAttribute("key1");
		dto.setId(dto1.getId());
		
		HttpSession session1=req.getSession();
		session1.setAttribute("key1",dto);
		
		service.serviceUpdate(dto);
		return new ModelAndView("/update.jsp","key","updation successful");
	}
}
