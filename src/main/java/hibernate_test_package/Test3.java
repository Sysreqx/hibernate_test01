package hibernate_test_package;

import hibernate_test_package.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<Employee> employees = session.createQuery("from Employee where salary>10500").getResultList();

            for (Employee e: employees) {
                System.out.println(e);
            }

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
