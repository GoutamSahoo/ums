package com.jspiders.ums.model.dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jspiders.ums.dto.RegisterDTO;
@Repository
public class UpdateDAO 
{
	@Autowired
	private SessionFactory sf; 
	public UpdateDAO() 
	{
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	public void daoUpdate(RegisterDTO dto) 
	{
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			tx.begin();
			sess.merge(dto);
			tx.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			sess.close();
		}
	}
}


/*Session sess=sf.openSession();
Transaction tx=sess.beginTransaction();
tx.begin();
String query="update RegisterDTO set name=:nname,phone=:nphone,city=:ncity,age=:nage,country=:ncountry,password=:npassword where email=:nemail";
Query q=sess.createQuery(query);
q.setParameter("nname",dto.getName());
q.setParameter("nemail",dto.getEmail());
q.setParameter("nphone",dto.getPhone());
q.setParameter("ncity",dto.getCity());
q.setParameter("nage",dto.getAge());
q.setParameter("ncountry",dto.getCountry());
q.setParameter("npassword",dto.getPassword());
int no=q.executeUpdate();
tx.commit();
System.out.println("no. of records updated:"+no);*/