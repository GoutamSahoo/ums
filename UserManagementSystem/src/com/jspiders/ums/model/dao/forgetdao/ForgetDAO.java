package com.jspiders.ums.model.dao.forgetdao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.ums.dto.RegisterDTO;
@Repository
public class ForgetDAO 
{
	@Autowired
	private SessionFactory sf; 
	public ForgetDAO() 
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	public RegisterDTO daoForget(String email) 
	{
		Session sess=sf.openSession();
		String query="from RegisterDTO where email=:newemail";
		Query q=sess.createQuery(query);
		q.setParameter("newemail",email);
		RegisterDTO fromdb=(RegisterDTO) q.uniqueResult();
		return fromdb;
	}
	public int updatePassword(String email,String newpassword)
	{
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		String query="update RegisterDTO set password=:newpassword where email=:newemail";
		Query sqlQuery=sess.createQuery(query);
		sqlQuery.setParameter("newemail",email);
		sqlQuery.setParameter("newpassword",newpassword);
		int n=sqlQuery.executeUpdate();
		tx.commit();
		return n;
	}
}