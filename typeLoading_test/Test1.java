package typeLoading_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import typeLoading_test.entity.Department;
import typeLoading_test.entity.Employee;

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
//            Employee emp3 = new Employee("Masha", "Nikola",  2200);
//            // Добавим  работников в департамент
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//            department.addEmployeeToDepartment(emp3);
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

        try {
            session = factory.getCurrentSession();  // создаем сессию

            session.beginTransaction(); // Открываем транзакцию

            //Получим департамент c id=5 и всех его работников
            System.out.println("Get department");
            Department department = session.get(Department.class, 5);
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Show Employee of the department");
            System.out.println(department.getEmployees());
            System.out.println("-------------------------------------------------------------------------------");

            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД
        } finally {
            session.close(); // Better way use it in catch block if we catch some Exception
            factory.close(); // Обязательно закрываем фабрику
        }

                    //////////////\\\\\\\\\\\\\Удаление из таблицы//////////////\\\\\\\\\\\\\\\

//        try {
//            session = factory.getCurrentSession();  // создаем сессию
//
//            session.beginTransaction(); // Открываем транзакцию
//
////            // Получим работника и все сущности кот.с ним связаны
////            Employee employee = session.get(Employee.class, 1);
//
//            //Получим департамент и удалим его
//            Department department = session.get(Department.class, 4);
//
//            // Удаляем дупартамент
//            session.delete(department);
//
//            // Удаляем работника
////            session.delete(employee);
//
//            session.getTransaction().commit(); // Закрываем транзакцию  и сохрн. измнения в БД
//        } finally {
//            session.close(); // Better way use it in catch block if we catch some Exception
//            factory.close(); // Обязательно закрываем фабрику
//        }
    }
}
