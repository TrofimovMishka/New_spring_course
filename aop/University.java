package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudent() {
        Student st1 = new Student("Liza Volkova", 4, 8.8);
        Student st2 = new Student("Kira Chu", 3, 7.8);
        Student st3 = new Student("Milana Gray", 5, 6.9);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents(){
        System.out.println("information from method getStudents");
        System.out.println(students);
        return students;
    }

}