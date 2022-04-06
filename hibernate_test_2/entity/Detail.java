package hibernate_test_2.entity;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

//    @OneToOne(mappedBy = "detail", cascade = CascadeType.ALL)  // Для реализации bi-derectional.// При удалении деталей удалаяем и работника при CascadeType.ALL
    // "detail" - это имя поля в классе Employee где связь уже есть . mappedBy - указывает что связь буже есть и еее нужно искать в поле detail
    @OneToOne(mappedBy = "detail", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}) // так можно установить чтобы при удалении деталей мы не удаляли работника из таблицы
    private Employee employee;

    public Detail() {
    }

    public Detail(String city, String phoneNumber, String email) {
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
