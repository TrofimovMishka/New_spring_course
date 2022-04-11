package com.example.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {
    // Сделаем логирование всех методов кот. работают с базой данных
    @Around("execution (* com.example.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature =
                (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("begin of: "+ methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("end of : "+methodName);
        return targetMethodResult;
    }
}
