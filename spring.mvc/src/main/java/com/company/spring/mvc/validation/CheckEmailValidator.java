package com.company.spring.mvc.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator
        implements ConstraintValidator<CheckEmail, String> { // CheckEmail -> какую аннотацию мы обрабатываем. String -> тип данных к которому мы будем применять анотацию
    private String endOfEmail;

    @Override
    public void initialize(CheckEmail checkEmail) {
        endOfEmail = checkEmail.value(); // получили конечную часть нашего email
    }

    // Тут происходит вся проверка
    @Override
    public boolean isValid(String enteredValue //enteredValue -> Это  то что приходит к нам после ввода
            , ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(endOfEmail);
    }
}
