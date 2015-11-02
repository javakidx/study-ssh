package idv.jk.fun.hibernate;

import idv.jk.fun.hibernate.entity.Email;
import idv.jk.fun.hibernate.entity.Person2;
import idv.jk.fun.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by javakid on 2015/10/28.
 */
public class PersonEmailTest
{
    @Test
    public void testAddPerson()
    {
        Email email = new Email();
        email.setEmail("abc_xyz@bbb.ccc.dd");

        Email email2 = new Email();
        email2.setEmail("abc_xyz@123.456.78");

        Person2 person2 = new Person2();
        person2.setName("Javakid");
        person2.setEmailList(Arrays.asList(email, email2));

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(email);
        session.persist(email2);

        session.persist(person2);
        session.getTransaction().commit();

        List list = session.createQuery("select p from Person2 p left join fetch p.emailList e").list();

        //因為是join，所以會有兩筆資料
        assertEquals(list.size(), 2);

        for(Person2 p : (List<Person2>)list)
        {
            assertEquals(p.getName(), "Javakid");
            assertNotNull(p.getEmailList());
        }

        session.beginTransaction();
        session.delete(person2);
        session.getTransaction().commit();
        session.close();
    }
}
