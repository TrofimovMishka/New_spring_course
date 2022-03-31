package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("aop.aspects.MyPointCuts.allGetMethods()")  ///Если Пользуем готовый pointcut из другого класа - то необходимо
    // прописать полный путь к этому pointcut-у
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice : try get book or magazine");
    }
}
