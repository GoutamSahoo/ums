package com.jspiders.ums.model.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jspiders.ums.dto.LoginDTO;
import com.jspiders.ums.dto.RegisterDTO;
@Repository
public class LoginDAO 
{
	@Autowired
	private SessionFactory sf; 
	public LoginDAO() 
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	public RegisterDTO daoLogin(LoginDTO dto) 
	{
		Session sess=sf.openSession();
		String query="from RegisterDTO where email=:newemail and password=:newpassword";
		Query q=sess.createQuery(query);
		q.setParameter("newemail",dto.getEmail());
		q.setParameter("newpassword",dto.getPassword());
		RegisterDTO fromdb=(RegisterDTO) q.uniqueResult();
		return fromdb;
	}
}
