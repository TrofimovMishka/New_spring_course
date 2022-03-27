package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        Dog myDog;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_2.xml")) {

            myDog = context.getBean("myDog", Dog.class);

        }
        myDog.say();
    }
}
