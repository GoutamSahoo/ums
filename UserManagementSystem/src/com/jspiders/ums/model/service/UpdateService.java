package com.jspiders.ums.model.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspiders.ums.dto.RegisterDTO;
import com.jspiders.ums.model.dao.UpdateDAO;
@Service
public class UpdateService 
{
	@Autowired
	private UpdateDAO dao;
	public UpdateService() 
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	public void serviceUpdate(RegisterDTO dto) 
	{
		dao.daoUpdate(dto);
	}
}
