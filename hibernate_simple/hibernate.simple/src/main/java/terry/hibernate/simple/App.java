package terry.hibernate.simple;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import terry.hibernate.simple.model.User;
import terry.hibernate.simple.utils.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        User user = new User();
        user.setEmail("cath@gmail.com");
        user.setFirstName("Terry");
        user.setLastName("Cho");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        System.out.println("Insert completed");
    }
}
