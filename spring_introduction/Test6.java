package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class)) {
            Person person = context.getBean("personBean", Person.class);
            person.callYourPet();
//            Pet cat = context.getBean("catBean", Pet.class);
//            cat.say();
            System.out.println("My have "+person.getAge() +" years old");
        }
    }
}
