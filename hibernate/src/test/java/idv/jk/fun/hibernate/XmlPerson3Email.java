package idv.jk.fun.hibernate;

import idv.jk.fun.hibernate.entity.Person3;
import idv.jk.fun.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by javakid on 2015/10/28.
 */
public class XmlPerson3Email
{
    @Test
    public void testAdd()
    {
        Person3 person3 = new Person3();
        person3.setName("Mary");

        person3.getEmails().add("123@456.789.01");
        person3.getEmails().add("abc@cde.ef.gh");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(person3);
        session.getTransaction().commit();

        List list = session.createQuery("select p from Person3 p left join fetch p.emails e where e like '%@456%'").list();

        assertEquals(list.size(), 1);

        for (Person3 p : (List<Person3>)list)
        {
            assertEquals(p.getName(), "Mary");
            assertEquals(p.getEmails().size(), 2);
        }

        session.close();
    }
}
