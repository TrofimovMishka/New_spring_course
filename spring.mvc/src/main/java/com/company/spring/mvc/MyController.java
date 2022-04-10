package com.company.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/employee") // можно исп для класса
public class MyController {
    @RequestMapping("/")
    // Когда введем в адресс браузера  <url-pattern>/</url-pattern> из web.xml то вызовем под капотом этот метод
    public String showFirstView() {
        //Так как мы использовали в applicationContext
        // <property name="prefix" value="/WEB-INF/view/" />
        // <property name="suffix" value=".jsp" />
        // то все остальное добавится автоматом
        return "first-view"; // имя нашего view  в пакете WEB-INF/view

    }

//    @RequestMapping("/askDetails") // если есть RequestMapping у класса этот URL примет вид -> /employee/askDetails
//    public String askEmployeeDetails() {
//        return "ask-emp-details-view";
//    }

    @RequestMapping("/askDetails") // если есть RequestMapping у класса этот URL примет вид -> /employee/askDetails
    public String askEmployeeDetails(Model model) {
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showEmployeeDetails(@ModelAttribute("employee") Employee emp){ // указываем какой атрибут будет использовать метод - @ModelAttribute("employee") Employee emp
        // Тут можем изменять наш полученный обьект ка нам нужно
        return "show-emp-details-view";
    }

//    @RequestMapping("/showDetails")
//    public String showEmployeeDetails(){
//        return "show-emp-details-view";
//    }

//    @RequestMapping("/showDetails")
//    public String showEmployeeDetails(HttpServletRequest request, Model model) { // request - содержит всю инфу о запросе!!!
//        String empName = "Mr. " + request.getParameter("employeeName"); // employeeName - это имя из файла ask-epm-details-view
//        //Добавим в модель значение кот необходимо сохранить
//        model.addAttribute("nameAttribute", empName);//nameAttribute - имя атрибута(называй как нужно) и его значение - empName
//        model.addAttribute("description", " - teacher");
//
//        return "show-emp-details-view";
//    }

    // Другой метод получения данных из запроса
//    @RequestMapping("/showDetails")
//    public String showEmployeeDetails(@RequestParam("employeeName") String empName, Model model) { // employeeName - это имя из файла ask-epm-details-view
//        empName = "Mr. " + empName;
//        //Добавим в модель значение кот необходимо сохранить
//        model.addAttribute("nameAttribute", empName);//nameAttribute - имя атрибута(называй как нужно) и его значение - empName
//        model.addAttribute("description", " - teacher");
//
//        return "show-emp-details-view";
//    }
}
