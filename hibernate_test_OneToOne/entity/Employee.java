package hibernate_test_OneToOne.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees") //Указывать имя таблицы как в MySQL называется таблица
public class Employee { // если клас и табл. имеют одинаковые имена - то вышенаписанное можно пропустить
    @Id //Указывает что это Primery Key
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Стратегия по созданию значения с Primery Key
    @Column(name="id") // name -> имя столбца в таблице БД
    private int id; // если поле называется так же как столбец то выше указаное можно не писать. Но лучше писать

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL) // Выполняются операции и на связанных с ним елементов
    @JoinColumn(name = "details_id")
    private Detail detail;


    public Employee() {
    }

    public Employee(String name, String surName, String department, int salary) {
        this.name = name;
        this.surname = surName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
