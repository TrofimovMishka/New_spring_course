package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // Создаем фабрику создания сессий
                .configure("hibernate.cfg.xml") // Путь к файлу конфиг
                .addAnnotatedClass(Employee.class) // Класс кот. пишем  таблицу
                .addAnnotatedClass(Detail.class) // Класс кот. пишем  таблицу
                .buildSessionFactory(); // метод создания фабрики
        Session session = null;
        try {
            session = factory.getCurrentSession();  // создаем сессию
            // Пример связи
//            Employee emp = new Employee("Mika", "Bond", "HR", 18900);
//            Detail detail = new Detail("New York", "2692923786", "mika@Gmail.com");
//            emp.setDetail(detail);
//            detail.setEmployee(emp);

            session.beginTransaction(); // Открываем транзакцию
//            session.save(detail); // emp  тоже обновится из-за bi-dir.

            // Извлечем детали и поищем с кем связаны делати
            Detail detail = session.get(Detail.class, 7); // detail with id 7

            detail.getEmployee().setDetail(null); // Удаляем связь между работником и деталями чтобы удалить детали без удаления работника

//            System.out.println("------------------------------------------------------------------------------------");
//            System.out.println(detail.getEmployee());
//            System.out.println("------------------------------------------------------------------------------------");
////
//            //Удалим детали и проверим что все что с ними связао удалено
            session.delete(detail);


            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД
        } finally {
            session.close(); // Better way use it in catch block if we catch some Exception
            factory.close(); // Обязательно закрываем фабрику
        }
    }
}
