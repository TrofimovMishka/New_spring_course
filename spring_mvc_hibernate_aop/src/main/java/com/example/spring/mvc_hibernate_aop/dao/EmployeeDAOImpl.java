package com.example.spring.mvc_hibernate_aop.dao;

import com.example.spring.mvc_hibernate_aop.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository // Используется для DAO
public class EmployeeDAOImpl implements EmployeeDAO{

    // Сoздает все бины описаны в contexte
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
        sessionFactory.getCurrentSession().save(employee);
    }
}
