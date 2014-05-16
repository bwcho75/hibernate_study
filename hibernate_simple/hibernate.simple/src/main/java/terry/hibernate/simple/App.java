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
        System.out.println("Insert completed");

        session.beginTransaction();
        User myuser = (User)session.get(User.class, "cath@gmail.com");
        System.out.println("user name:"+myuser.getFirstName());
        myuser.setFirstName("Cath");
        session.getTransaction().commit();
        
        session.close();
        sessionFactory.close();
    }
}
