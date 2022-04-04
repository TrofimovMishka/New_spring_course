package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // Создаем фабрику создания сессий
                .configure("hibernate.cfg.xml") // Путь к файлу конфиг
                .addAnnotatedClass(Employee.class) // Класс кот. пишем  таблицу
                .buildSessionFactory(); // метод создания фабрики

        try {
            Session session = factory.getCurrentSession();  // создаем сессию
            session.beginTransaction(); // Открываем транзакцию

            //Получим работника по ID и поменяем ему зарплату:
//            Employee employee = session.get(Employee.class, 1); // Извлекаем работника
//            employee.setSalary(30000); // Устанавливаем новое ЗП. Так можно имз. все поля класа в БД
            session.createQuery("update Employee set salary=40555 where name = 'Masha'").executeUpdate();

            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД


        } finally {
            factory.close(); // Обязательно закрываем фабрику
        }
    }
}
