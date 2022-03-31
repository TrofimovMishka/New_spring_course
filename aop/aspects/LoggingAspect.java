package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("aop.aspects.MyPointCuts.allAddMethods()")
    ///Если Пользуем готовый pointcut из другого класа - то необходимо
    // прописать полный путь к этому pointcut-у
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) { // use joinPoint for get some info from method
        System.out.println("beforeAddLoggingAdvice : try get book or magazine");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); // info about signature of method
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): " + methodSignature.getName()); // method name

        if (methodSignature.getName().equalsIgnoreCase("addBook")) {
            Object[] arguments = joinPoint.getArgs(); // info about arguments
            for (Object object :
                    arguments) {
                if (object instanceof Book) {
                    Book myBook = (Book) object;
                    System.out.println("info about book: " +
                            "\n Title of book - "+ myBook.getName() +
                            "\n Author - "+ myBook.getAuthor() +
                            "\n Years of publication - " + myBook.getYearOfPublication());
                }else if(object instanceof String){
                    System.out.println("Book add "+ object);
                }
            }
        }
        System.out.println("----------------------------------------------------------------------------");

    }
}
