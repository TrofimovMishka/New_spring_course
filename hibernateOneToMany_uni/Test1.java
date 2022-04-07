package hibernateOneToMany_uni;

import hibernateOneToMany_uni.entity.Department;
import hibernateOneToMany_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() // Создаем фабрику создания сессий
                .configure("hibernate.cfg.xml") // Путь к файлу конфиг
                .addAnnotatedClass(Employee.class) // Класс кот. пишем  таблицу
                .addAnnotatedClass(Department.class) // Класс кот. пишем  таблицу
                .buildSessionFactory(); // метод создания фабрики
        Session session = null;

                                //////////////\\\\\\\\\\\\\Создание//////////////\\\\\\\\\\\\\\\

//        try {
//            session = factory.getCurrentSession();  // создаем сессию
//
//            //Создадим департамент
//            Department department = new Department("HR", 300, 1000);
//            //Создадим работников
//            Employee emp1 = new Employee("Kriss", "Grid",  500);
//            Employee emp2 = new Employee("Masha", "Green",  1000);
//            // Добавим  работников в департамент
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction(); // Открываем транзакцию
//            // Сохраним все изм. в таблицах - Из-за связи обе таблицы обновятся и свяжутся соотв.колонами
//            session.save(department);
//
//            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД
//        } finally {
//            session.close(); // Better way use it in catch block if we catch some Exception
//            factory.close(); // Обязательно закрываем фабрику
//        }

                        //////////////\\\\\\\\\\\\\Извлечение из таблиц//////////////\\\\\\\\\\\\\\\

//        try {
//            session = factory.getCurrentSession();  // создаем сессию
//
//            session.beginTransaction(); // Открываем транзакцию
//
//            //Получим департамент c id=1 и всех его работников
//            Department department = session.get(Department.class, 2);
//            System.out.println("-------------------------------------------------------------------------------");
//            System.out.println(department);
//            System.out.println(department.getEmployees());
//            System.out.println("-------------------------------------------------------------------------------");
//
//            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД
//        } finally {
//            session.close(); // Better way use it in catch block if we catch some Exception
//            factory.close(); // Обязательно закрываем фабрику
//        }

                    //////////////\\\\\\\\\\\\\Удаление из таблицы//////////////\\\\\\\\\\\\\\\
//
        try {
            session = factory.getCurrentSession();  // создаем сессию

            session.beginTransaction(); // Открываем транзакцию

            // Получим департамент и все сущности кот.с ним связаны
            Department department = session.get(Department.class, 2);

            // Удаляем департамент - удалятся и все работники так как cascade = ALL
            session.delete(department); //

            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД
        } finally {
            session.close(); // Better way use it in catch block if we catch some Exception
            factory.close(); // Обязательно закрываем фабрику
        }
    }
}
