package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("method main start");
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class)) {
            UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
            String bookName = uniLibrary.returnBook();
            System.out.println("In library return book: " + bookName);
        }
        System.out.println("method main end");
    }
}
