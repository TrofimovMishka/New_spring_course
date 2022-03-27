package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotation1 {
    public static void main(String[] args) {
        Cat cat;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_3.xml")) {
            cat = context.getBean("cat", Cat.class);
        }
        cat.say();
    }
}
