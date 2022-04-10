<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Dear employee , you are welcome!</h2>
<br>
<br>
<br>
<%--<h3> Your name: ${param.employeeName} <h3/>--%>
<!-- employeeName - имя переменной из другого view кот отвечает за сохраниние данных от пользователя-->

<%--<h3> Your name: ${nameAttribute} ${description}<h3/>--%>
<!-- nameAttribute - это то имя которое мы присвоили в методе showEmployeeDetails() - model.addAttribute("nameAttribute", empName);-->

<!--Вынимаем из атрибута employee нужную инфу. То что ввел пользователь. Под капотом срабатывают getters-->
<h3> Your name: ${employee.name}
    <br>
    Your surname: ${employee.surname}
    <br>
    Your salary: ${employee.salary}
    <br>
    Your department: ${employee.department}
    <br>
    Your car: ${employee.car}
    <br>

    Language(s):
    <%--    Создаем не отсортиров. лист с помощью тега:--%>
    <ul>
        <%-- Создаем  forEach(переменная - откуда берется):--%>
        <c:forEach var="lang" items="${employee.languages}">
            <%--Что делаем в forEach? выводим переменную--%>
            <li>${lang}</li>
        </c:forEach>
    </ul>

    <br>
    Phone number: ${employee.phoneNumber}
    <h3/>
</body>

</html>