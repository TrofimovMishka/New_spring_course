package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotation1 {
    public static void main(String[] args) {
        Cat cat;
        Person person;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_3.xml")) {
            cat = context.getBean("catBean", Cat.class);
            person = context.getBean("personId", Person.class);
        }
//        cat.say();
        person.callYourPet();
        System.out.println(person.getSurName());
        System.out.println(person.getAge());
    }
}
