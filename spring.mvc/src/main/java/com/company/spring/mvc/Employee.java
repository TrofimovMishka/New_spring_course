package com.company.spring.mvc;

import com.company.spring.mvc.validation.CheckEmail;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    @Size(min = 2, max = 25, message = "name must be between 2-25 symbols") // Указываем мин или мах длину ввода и сообщение кот выпадет при не соблюдении условия
    private String name;
//    @NotNull //Метка что это поле обязательное и проверка только на null
//    @NotEmpty(message = "surname is required field") // Метка что это поле обязательное и проверка на null and empty
    @NotBlank(message = "surname is required field") // Метка что это поле обязательное и проверка на null, empty  и чтобы небыли одно пробелы или табы
    private String surname;

    @Min(value = 500, message = "must be grater than 499")
    @Max(value = 50000, message = "must be less than 49999")
    private int salary;
    private String department;
    private Map<String, String> departments;
    private String car;
    private Map<String, String> cars;
    private String[] languages;
    private Map<String, String> languagesList;

//    @CheckEmail(value = "abc.com", message = "email must ends abc.com") // Саме создали эту аннотацию
    @CheckEmail
    private String email;

    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "use pattern xxx-xx-xx") // Проверка вводимых данных по регулярке
    private String phoneNumber;

    public Employee() {
        departments = new HashMap<>();
        departments.put("Information Technology", "IT"); // key - то что запишем в поле department; value - то что видно в выпадающем списке
        departments.put("Human Resouse", "HR");
        departments.put("Sales", "Sales");

        cars = new HashMap<>();
        cars.put("BMW", "BMW");
        cars.put("Mercedes-Benz", "Mercedes");
        cars.put("Audi", "Audi");

        languagesList = new HashMap<>();
        languagesList.put("English", "EN");
        languagesList.put("Deutch", "DE");
        languagesList.put("French", "FR");

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, String> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(Map<String, String> languagesList) {
        this.languagesList = languagesList;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public Map<String, String> getCars() {
        return cars;
    }

    public void setCars(Map<String, String> cars) {
        this.cars = cars;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
