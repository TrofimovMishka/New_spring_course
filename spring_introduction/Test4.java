package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext_2.xml");

        Dog myDog = context.getBean("myDog", Dog.class);
        Dog yourDog = context.getBean("myDog", Dog.class);
        System.out.println(myDog == yourDog); // true -  if use singleton scope

        myDog.setName("Belka");
        yourDog.setName("HotDog");
        System.out.println(myDog.getName()); // singleton object  if use singleton scope
        System.out.println(yourDog.getName()); // singleton object  if use singleton scope



    }
}
