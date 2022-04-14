package hibernate_test_package;

import hibernate_test_package.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            Employee employee = new Employee("Carlos", "Kastaneda", "HR", 17000);
            session.beginTransaction();
            session.save(employee);

            int myId = employee.getId();
            Employee employee1 = session.get(Employee.class, myId);

            System.out.println(employee1);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
