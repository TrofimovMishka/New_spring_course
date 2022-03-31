package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointCuts {
//    @Pointcut("execution(* get*())")
//    public void allGetMethods(){}

    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){}
}
