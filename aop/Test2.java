package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        University university;
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class)) {

            university = context.getBean("university", University.class);
        }
        university.addStudent();
        List<Student> students = university.getStudents();
        System.out.println(students);
    }
}
