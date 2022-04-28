package com.example.springboot.springboot_rest.dao;


import com.example.springboot.springboot_rest.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
@Repository // Используется для DAO
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager; // управляет связями между обектом и БД

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//
//        List<Employee> allEmployee = session.createQuery("from Employee", Employee.class).getResultList();

        //Lesson_2 - Using JPA
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployee = query.getResultList();

        return allEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee); // Сохраняет или обновляет данные если такой работник есть в базе
        //Lesson_2 - Using JPA
        Employee newEmp = entityManager.merge(employee);
        employee.setId(newEmp.getId()); // Это нужно для корректного отображения ID нового работника у нас в браузере


    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        //Lesson_2 - Using JPA
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

        //Lesson_2 - Using JPA
        Query query = entityManager.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}