package hibernate_test_package2;

import hibernate_test_package2.entity.Employee;
import hibernate_test_package2.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            Employee employee = new Employee("Kaisar", "Yerdenbekov", "IT", 1500);
            Detail detail = new Detail("Almaty", "+77013012131", "y.kaisar@gmail.com");
            employee.setEmpDetail(detail);

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
