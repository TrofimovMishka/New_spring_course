package com.company.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/")   // Когда введем в адресс браузера  <url-pattern>/</url-pattern> из web.xml то вызовем под капотом этот метод
    public String showFirstView(){
        //Так как мы использовали в applicationContext
        // <property name="prefix" value="/WEB-INF/view/" />
        // <property name="suffix" value=".jsp" />
        // то все остальное добавится автоматом
        return "first-view"; // имя нашего view  в пакете WEB-INF/view

    }
}
