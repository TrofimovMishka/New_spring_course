package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {

            Pet myDog = context.getBean("myDog", Pet.class);
            Pet myCat = context.getBean("myCat", Pet.class);
            myDog.say();
            myCat.say();
        }
    }
}
