package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("personId")
public class Person {
//    @Autowired
//    @Qualifier("catBean") // use with field
    private Pet pet;
//    @Value("Sidoroff") // hardcode - do not use. Use properties file
//    @Value("${person.surName}")
    @Value("${person.surName}")
    private String surName;
//    @Value("30") // hardcode - do not use. Use properties file
//    @Value("${person.age}")
    @Value("${person.age}")
    private int age;

    public String getSurName() {
        return surName;
    }

//    public void setSurName(String surName) {
//        this.surName = surName;
//    }

    public int getAge() {
        return age;
    }

//    public void setAge(int age) {
//        this.age = age;
//    }

//    public Person() { // use for dependency injection with setters
//        super();
//    }

    public Person( Pet pet) { // use for dependency injection with constructors
        this.pet = pet;
    }
//    @Autowired
//    public Person(@Qualifier("dog") Pet pet) { // use for dependency injection with constructors
//        this.pet = pet;
//    }

    public void callYourPet(){
        System.out.println("Hello my pet!");
        pet.say();
    }
//    @Autowired
//    @Qualifier("catBean") // use with setters
    public void setPet(Pet pet) { // use for dependency injection with setters
        this.pet = pet;
    }
}
