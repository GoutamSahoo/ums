package com.jspiders.ums.model.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspiders.ums.dto.LoginDTO;
import com.jspiders.ums.dto.RegisterDTO;
import com.jspiders.ums.model.dao.LoginDAO;
@Service
public class LoginService 
{
	@Autowired
	private LoginDAO dao;
	public LoginService() 
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	public RegisterDTO serviceLogin(LoginDTO dto) 
	{
		return dao.daoLogin(dto);
	}
}
