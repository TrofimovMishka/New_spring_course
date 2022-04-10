package com.company.spring.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // К какой обл. приенима наша аннотация
@Retention(RetentionPolicy.RUNTIME) // Инфа о нашей фннот. сохраняется вплоть до выполнения кода
@Constraint(validatedBy = CheckEmailValidator.class) // Указваем какой класс будет обрабатывать нашу аннотацию - необходимо этот класс создать
public @interface CheckEmail {
    public String value() default "xyz.com";
    public String message() default "email must ends with xyz.com";

    public Class<?>[] groups() default {}; // Позволяет разбивать аннот. по группам
    public Class<? extends Payload>[] payload() default {}; // Исп. для переноса метаданных о информации клиента

}
