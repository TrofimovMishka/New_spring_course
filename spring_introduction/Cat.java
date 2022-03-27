package spring_introduction;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Pet{
    @Override
    public void say() {
        System.out.println("Miau, Miau, Miau");
    }
}
