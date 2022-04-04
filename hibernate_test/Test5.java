package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // Создаем фабрику создания сессий
                .configure("hibernate.cfg.xml") // Путь к файлу конфиг
                .addAnnotatedClass(Employee.class) // Класс кот. пишем  таблицу
                .buildSessionFactory(); // метод создания фабрики

        try {
            Session session = factory.getCurrentSession();  // создаем сессию
            session.beginTransaction(); // Открываем транзакцию

//            //Получим работника по ID и удалим его из БД:
//            Employee employee = session.get(Employee.class, 1); // Извлекаем работника c id = 1;
//            session.delete(employee);

            //Удаление обьектов по условию
            session.createQuery("delete Employee where name = 'Masha'").executeUpdate(); // Запрос на удаление всех Masha

            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД


        } finally {
            factory.close(); // Обязательно закрываем фабрику
        }
    }
}
