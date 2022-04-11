package com.example.spring.mvc_hibernate_aop.dao;

import com.example.spring.mvc_hibernate_aop.entity.Employee;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Repository // Используется для DAO
public class EmployeeDAOImpl implements EmployeeDAO{

    // Сoздает все бины описаны в AplicationContext.xml
    @Autowired
    private SessionFactory sessionFactory;

    @Override
//    @Transactional // авто открытие и закрытие транзакци
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();

        List<Employee> allEmployee  = session.createQuery("from Employee", Employee.class).getResultList();

        return allEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee); // Сохраняет или обновляет данные если такой работник есть в базе
//        sessionFactory.getCurrentSession().save(employee); - Только созраняет работников
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
