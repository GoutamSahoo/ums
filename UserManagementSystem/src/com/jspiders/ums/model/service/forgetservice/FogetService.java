package com.jspiders.ums.model.service.forgetservice;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.jspiders.ums.dto.RegisterDTO;
import com.jspiders.ums.model.dao.forgetdao.ForgetDAO;
@Service
public class FogetService 
{
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	private ForgetDAO dao;
	
	public FogetService() 
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	public RegisterDTO serviceForget(String email) 
	{
		return dao.daoForget(email);
	}
	/*public void updatePassword(String email)
	{
		System.out.println(email+"in service");
		UUID uuid=UUID.randomUUID();
		String newpassword=uuid.toString();
		System.out.println(newpassword);
		dao.updatePassword(email,newpassword);
	}*/
	public boolean updatePassword(String email)
	{
		System.out.println(email+"in service");
		UUID uuid=UUID.randomUUID();
		String newpassword=uuid.toString();
		System.out.println(newpassword);
		int id=dao.updatePassword(email,newpassword);
		if(id!=0)
		{
			System.out.println("started sending mail");
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			mailMessage.setTo("goutamsahoo100@gmail.com");
			mailMessage.setFrom("goutamsahoo100@gmail.com");
			mailMessage.setSubject("new generated password");
			mailMessage.setText("hi user, /n this is new generated password"
					+ " please use the same for next login"+mailMessage);
			mailSender.send(mailMessage);
			return true;
		}
		else
		{
			return false;
		}
	}
}
