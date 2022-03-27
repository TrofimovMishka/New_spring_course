package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        Dog dog;
        Dog myDog;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_3.xml")) {
            dog = context.getBean("dog", Dog.class);
            myDog = context.getBean("dog", Dog.class);
        }
        dog.say();
        System.out.println(dog == myDog); // is singleton?
    }
}
