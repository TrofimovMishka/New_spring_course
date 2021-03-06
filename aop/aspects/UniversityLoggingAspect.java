package aop.aspects;

import aop.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice(){   // Отработает ДО метода основной логики
//        System.out.println("beforeGetStudentsLoggingAdvice: add log get list of students BEFORE the method getStudents");
//    }

//    @AfterReturning("execution(* getStudents())")   // Отработает ПОСЛЕ метода основной логики
//    public void afterReturningGetStudentsLoggingAdvice(){
//        System.out.println("afterReturningGetStudentsLoggingAdvice: add log get list of students AFTER the method getStudents");
//    }

//    //Перехватим результат метода и изменим его:
//    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")   // Отработает ПОСЛЕ метода основной логики
//    public void afterReturningGetStudentsLoggingAdvice(JoinPoint joinPoint, List<Student> students){
//        //Поправим имя первого студента для примера:
//        Student st1 = students.get(0);
//        String nameSurname = st1.getNameSurname();
//        nameSurname = "Miss "+ nameSurname;
//        st1.setNameSurname(nameSurname);
//
//        double avgGrade = st1.getAvgGrade();
//        avgGrade = avgGrade - 2;
//        st1.setAvgGrade(avgGrade);
//        System.out.println("afterReturningGetStudentsLoggingAdvice: add log get list of students AFTER the method getStudents");
//    }

//    @AfterThrowing("execution(* getStudents())") // Работает только после падения метода с Exception
//    public void afterThrowingGetStudentsLoggingAdvice(){
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: Logging some Exception from the method");
//    }

//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")  // Достаем инфу о Exception
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: Logging some Exception from the method : " + exception);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice:  Logging normal finish of method or Exception");
    }
}
