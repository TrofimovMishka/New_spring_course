package hibernate_test_OneToOne;

import hibernate_test_OneToOne.entity.Detail;
import hibernate_test_OneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // Создаем фабрику создания сессий
                .configure("hibernate.cfg.xml") // Путь к файлу конфиг
                .addAnnotatedClass(Employee.class) // Класс кот. пишем  таблицу
                .addAnnotatedClass(Detail.class) // Класс кот. пишем  таблицу
                .buildSessionFactory(); // метод создания фабрики
        Session session = null;
        try {
            session = factory.getCurrentSession();  // создаем сессию
                // Add one employee
//            Employee emp = new Employee("Liza", "Laurova", "AfterSales", 14000);
//            Detail detail = new Detail("New York", "12346138", "ham@Gmail.com");
//            emp.setDetail(detail);
            // Add second employee
//            Employee emp = new Employee("Monika", "Grid", "HR", 1000);
//            Detail detail = new Detail("New York", "8865432", "Monika_m@Gmail.com");
//            emp.setDetail(detail);

            session.beginTransaction(); // Открываем транзакцию


//            // Get one employee from DB
//            Employee employee = session.get(Employee.class, 1); // with id =1
//            System.out.println(employee.getDetail());
//            // and save his in DB
////            session.save(emp);


            // Delete one employee from DB
            Employee employee = session.get(Employee.class, 2); // with id =2
            session.delete(employee); // details will delete too

            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД
        } finally {
            session.close(); // Better way use it in catch block if we catch some Exception
            factory.close(); // Обязательно закрываем фабрику
        }
    }
}
