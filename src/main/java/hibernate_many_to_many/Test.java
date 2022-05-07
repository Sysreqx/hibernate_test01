package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            Section section1 = new Section("Footbal");
            Child child1 = new Child("Kaisar", 5);
            Child child2 = new Child("Dias", 6);
            Child child3 = new Child("Temir", 7);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.save(section1);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
