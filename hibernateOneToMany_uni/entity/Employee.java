package hibernateOneToMany_uni.entity;

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

    @Column(name = "salary")
    private int salary;

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

    public Employee() {
    }

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
