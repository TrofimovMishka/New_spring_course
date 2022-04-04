package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // Создаем фабрику создания сессий
                .configure("hibernate.cfg.xml") // Путь к файлу конфиг
                .addAnnotatedClass(Employee.class) // Класс кот. пишем  таблицу
                .buildSessionFactory(); // метод создания фабрики

        try {
            Session session = factory.getCurrentSession();  // создаем сессию
            session.beginTransaction(); // Открываем транзакцию

            //Получим всех работников и выведеи их на екран
//            List<Employee> employees = session.createQuery("from Employee").getResultList(); // "from Employee" - Пишем имя класса - На подчеркивание можн не обращать внимание
//            List<Employee> employees = session.createQuery("from Employee where name = 'Masha'").getResultList(); // Поиск по имени поля класа. name - это имя поля класса.
            List<Employee> employees = session.createQuery("from Employee where name = 'Masha' and salary>8000").getResultList(); // Поиск по имени и условии
            for (Employee emp :
                    employees) {
                System.out.println("---------------------------------------------------------------");
                System.out.println(emp);
                System.out.println("---------------------------------------------------------------");
            }

            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД


        } finally {
            factory.close(); // Обязательно закрываем фабрику
        }
    }
}
