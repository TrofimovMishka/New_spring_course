package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class)) {
            Library library = context.getBean("libraryBean", Library.class);
            library.getBook();

        }
    }
}
