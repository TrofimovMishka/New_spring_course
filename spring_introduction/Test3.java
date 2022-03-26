package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        Person person;
//        Pet pet;
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {
            person = context.getBean("myPerson", Person.class);
//            pet = context.getBean("myDog", Pet.class);
        }
//        Person person = new Person(pet); // добавляем зависимость вручную. Hard code injection!!! Bad practice!
        person.callYourPet();
        System.out.println(person.getAge());
        System.out.println(person.getSurName());

    }
}
