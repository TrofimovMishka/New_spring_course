package hibernate_test_OneToMany_bi.entity;

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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
