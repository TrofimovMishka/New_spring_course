<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>All employees</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>SurName</th>
        <th>Department</th>
        <th>Salary</th>
    </tr>
    <c:forEach var="emp" items="${allEmps}">
        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
        </tr>

    </c:forEach>

    <br>
<%--    Создаем кнопку Add. addNewEmployee - это метод из контролера кот.должен реализовать действие при нажатии на кнопку--%>
    <input type="button" value="Add"
           onclick="window.location.href = 'addNewEmployee'"/>
</table>

</body>

</html>>