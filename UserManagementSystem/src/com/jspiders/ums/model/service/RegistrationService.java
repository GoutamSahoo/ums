package com.jspiders.ums.model.service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspiders.ums.dto.RegisterDTO;
import com.jspiders.ums.model.dao.RegistrationDAO;
@Service
public class RegistrationService 
{
	final Logger logger=Logger.getLogger(RegistrationService.class);
	@Autowired
	private RegistrationDAO dao;
	public RegistrationService() 
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	public void serviceRegister(RegisterDTO dto) 
	{
		logger.info("inside serviceRegister method of RegistrationService class");
		
		dao.daoRegister(dto);
		
		logger.info("leaving serviceRegister method of RegistrationService class");
	}
}
