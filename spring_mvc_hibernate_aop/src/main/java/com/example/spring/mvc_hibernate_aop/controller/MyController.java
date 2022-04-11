package com.example.spring.mvc_hibernate_aop.controller;

import com.example.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.example.spring.mvc_hibernate_aop.entity.Employee;
import com.example.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

//    @Autowired
//    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model){
        List<Employee> allEmployees = employeeService.getAllEmployees();

        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    // Метод который реализовывает дейтвие нажатия а кнопку Add
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model  model){
        //Создаем нового работника
        Employee employee = new Employee();
        //Помещаем его в атрибут модели
        model.addAttribute("employee", employee);
        //Вызывает новый view
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){ // Получаем из модели наш employee
        // Сохраняем его в базе использую Service:
        employeeService.saveEmployee(employee);

        //Вернуть обновленный вид первого окна
        return "redirect:/";
    }

    //empId - это переменная созданная в all-employee в которой сохранено id работника. Используем его для поиска нашего работника
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        //Получим работника из базы:
        Employee employee = employeeService.getEmployee(id);
        //Так как наш view employee-info работает с modelAttribute="employee" то добавим атрибут с таким же именем
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id, Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
