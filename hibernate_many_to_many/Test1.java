package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;

        ////////Создадим секцию и детей. В секцию добавим детей. Из-за связей таблица детей тоже наполнится\\\\\\\\\\\

        try {
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Football");
//
//            Child child1 = new Child("Oleg", 12);
//            Child child2 = new Child("Masha", 9);
//            Child child3 = new Child("Vika", 10);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.persist(section1);  // !!!!!!!Чтобы работало каскадное сохраниение без CaskadeType.ALL
//
//            session.getTransaction().commit();
//            System.out.println("Done");

            //*************************************************************************************************\\
     ////////Создадим секции и ребенка. В сребенку добавим секции Из-за связей таблица секций тоже наполнится\\\\\\\\\\\

//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Box");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Dancing");
//
//            Child child1 = new Child("Igor", 12);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.persist(child1);  // !!!!!!!Чтобы работало каскадное сохраниение без CaskadeType.ALL
//
//            session.getTransaction().commit();
//            System.out.println("Done");

            //*************************************************************************************************\\
                      ////////Получим секцию. И выведем инфу о ней и о детях кот. в ней занимаются\\\\\\\\\\\

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//            System.out.println("------------------------------------------------------------------------------");
//            System.out.println(section);
//            System.out.println(section.getChildren());
//            System.out.println("------------------------------------------------------------------------------");
//
//            session.getTransaction().commit();
//            System.out.println("Done");

            //*************************************************************************************************\\
            ////////Получим ребенка. И выведем инфу о нем и о секциях кот. в он занимается\\\\\\\\\\\

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 4);
//            System.out.println("------------------------------------------------------------------------------");
//            System.out.println(child);
//            System.out.println(child.getSections());
//            System.out.println("------------------------------------------------------------------------------");
//
//            session.getTransaction().commit();
//            System.out.println("Done");

            //*************************************************************************************************\\
             ////////Удалим секцию. И если было CaskadeType.ALL - удалятся все дети\\\\\\\\\\\

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done");

            //*************************************************************************************************\\
                                            ////////Удалим ребенка.\\\\\\\\\\\

            session = factory.getCurrentSession();
            session.beginTransaction();

            Child child = session.get(Child.class, 4);
            session.delete(child);

            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            session.close();
            factory.close();

        }
    }
}
