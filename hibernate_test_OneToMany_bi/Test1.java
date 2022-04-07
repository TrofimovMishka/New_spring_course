package hibernate_test_OneToMany_bi;

import hibernate_test_OneToMany_bi.entity.Department;
import hibernate_test_OneToMany_bi.entity.Employee;
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
//            Department department = new Department("IT", 1200, 3000);
//            //Создадим работников
//            Employee emp1 = new Employee("Monika", "Grid",  1500);
//            Employee emp2 = new Employee("Liza", "Laurova",  2000);
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
//            Department department = session.get(Department.class, 1);
//            System.out.println("-------------------------------------------------------------------------------");
//            System.out.println(department);
//            System.out.println(department.getEmployees());
//            System.out.println("-------------------------------------------------------------------------------");
//
//            // Получим работника и все сущности кот.с ним связаны
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println("-------------------------------------------------------------------------------");
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//            System.out.println("-------------------------------------------------------------------------------");
//
//            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД
//        } finally {
//            session.close(); // Better way use it in catch block if we catch some Exception
//            factory.close(); // Обязательно закрываем фабрику
//        }

                    //////////////\\\\\\\\\\\\\Удаление из таблицы//////////////\\\\\\\\\\\\\\\

        try {
            session = factory.getCurrentSession();  // создаем сессию

            session.beginTransaction(); // Открываем транзакцию

            // Получим работника и все сущности кот.с ним связаны
            Employee employee = session.get(Employee.class, 1);

            // Удаляем работника - но департамент не удалится - НЕ ИСП. CascadeType.AL
            session.delete(employee); //

            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД
        } finally {
            session.close(); // Better way use it in catch block if we catch some Exception
            factory.close(); // Обязательно закрываем фабрику
        }
    }
}
