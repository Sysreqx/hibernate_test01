package hibernate_test_package2;

import hibernate_test_package2.entity.Detail;
import hibernate_test_package2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            Detail detail = new Detail("LA", "+77051115544", "sh.diana@gmail.com");
            Employee employee = new Employee("Diana", "Shamet", "QA", 2000);
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);

            session.beginTransaction();
            session.save(detail);
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
