package idv.jk.fun.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import idv.jk.fun.hibernate.entity.Cat;
import idv.jk.fun.hibernate.util.HibernateUtil;

public class CatTest
{
	@Test
	public void testInsert()
	{
		try
		{
			Cat mother = new Cat();
			mother.setName("Mary");
			mother.setDescription("The Mommy cat");
			mother.setCreateDate(new Date());

			Cat catKid1 = new Cat();
            catKid1.setMother(mother);
            catKid1.setName("Jonny");
            catKid1.setDescription("Hi, I am John");
            catKid1.setCreateDate(new Date());
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.persist(mother);
            session.persist(catKid1);
			tx.commit();
			session.close();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
