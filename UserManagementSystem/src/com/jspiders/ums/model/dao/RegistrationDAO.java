package com.jspiders.ums.model.dao;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.ums.dto.RegisterDTO;
@Repository
public class RegistrationDAO 
{
	final Logger logger=Logger.getLogger(RegistrationDAO.class);
	@Autowired
	private SessionFactory sf; 
	public RegistrationDAO() 
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	public void daoRegister(RegisterDTO dto) 
	{
		logger.info("inside daoRegister method of RegistrationDAO class");

		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			tx.begin();
			sess.save(dto);
			tx.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			logger.info("leaving daoRegister method of RegistrationDAO class");

			sess.close();
		}
	}
}
