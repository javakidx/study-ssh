package idv.jk.fun.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
	private static final SessionFactory sessionFactory;
	
	static
	{
		try
		{
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = 
							new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties());

			sessionFactory = configuration.buildSessionFactory(builder.build());
		}
		catch(Throwable e)
		{
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
