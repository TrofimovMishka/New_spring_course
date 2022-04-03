package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // Создаем фабрику создания сессий
                .configure("hibernate.cfg.xml") // Путь к файлу конфиг
                .addAnnotatedClass(Employee.class) // Класс кот. пишем  таблицу
                .buildSessionFactory(); // метод создания фабрики

        try {
            Session session = factory.getCurrentSession();  // создаем сессию

            Employee emp = new Employee("Liza", "Volkova", "IT", 12000);
            // Обязательные шаги:
            session.beginTransaction(); // Открываем транзакцию
            session.save(emp); // Сохрн. обьект в БД
            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД
        } finally {
            factory.close(); // Обязательно закрываем фабрику
        }
    }
}
