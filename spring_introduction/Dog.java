package spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
//@Scope("singleton") // by default scope
//@Scope("prototype")
public class Dog implements Pet{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void say(){
        System.out.println("Hau hau");
    }

//    @PostConstruct // for java 9 is deprecated. download javax.annatotion api 1.3.2
//    public void init(){
//        System.out.println("Class Dog : init method");
//    }
//
//    @PreDestroy // for java 9 is deprecated. download javax.annatotion api 1.3.2
//    public void destroy(){
//        System.out.println("Class dog : destroy");
//    }
}
