package spring_introduction;

public class Person {
    private Pet pet;
    private String surName;
    private int age;

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() { // use for dependency injection with setters
        super();
    }

    public Person(Pet pet) { // use for dependency injection with constructors
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello my pet!");
        pet.say();
    }

    public void setPet(Pet pet) { // use for dependency injection with setters
        this.pet = pet;
    }
}
