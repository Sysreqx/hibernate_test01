package hibernate_one_to_many_bi_directional;

import hibernate_one_to_many_bi_directional.entity.Department;
import hibernate_one_to_many_bi_directional.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
//            session = sessionFactory.getCurrentSession();
//
//            Department department = new Department("IT", 1200, 300);
//            Employee employee1 = new Employee("Kaisar", "Yerdenbekov", 800);
//            Employee employee2 = new Employee("Dias", "Zakirov", 1000);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//
//            session.beginTransaction();
//            session.save(department);
//
//            session.getTransaction().commit();
//            System.out.println("DOne!");

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            Department department = session.get(Department.class, 1);

            System.out.println(department);
            System.out.println(department.getEmps());

            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
