package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // proceedingJoinPoint - означает связь с target методом,
        System.out.println("aroundReturnBookLoggingAdvice: In library try return book");

        long begin = System.currentTimeMillis(); // Засекаем время
        Object targetMethodResult = proceedingJoinPoint.proceed(); //  исп.его запустим target метод
        long end = System.currentTimeMillis(); // Засекаем время
        
        System.out.println("aroundReturnBookLoggingAdvice: In library return book");
        System.out.println("Method returnBook time executing: "+ (end - begin) + " millis");
        return targetMethodResult; // должен возвращать то же что и target (String  в нашем случае), но можно вернуть и Object
    }
}
