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
<%--        Добавим шапку--%>
        <th>Operations</th>
    </tr>
    <c:forEach var="emp" items="${allEmps}">
<%--        Создадим ссылку по которой будем проходить когда нажимаем кнопку Update и получать инфу об Id--%>
<%--        updateInfo - Это метод из контроллера.  updateButton - имя ссылки используем в кнопке--%>
        <c:url var="updateButton" value="/updateInfo">
<%--            Эта ссылка создает переменную empId и сохраняет в ней id из работника.
 Эту переменную мы используем в контролере для того чтобы понять с каким работником работаем--%>
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

<%--        Создадим ссылку по которой будем проходить когда нажимаем кнопку Delete и получать инфу об Id--%>
<%--        deleteEmployee - Это метод из контроллера.  deleteButton - имя ссылки используем в кнопке--%>
        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
<%--            Создаем кнопку с именем Update кот.по нажатию вызывает вышеописанную ссылку updateButton--%>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>
<%--            Создаем кнопку с именем Delete кот.по нажатию вызывает вышеописанную ссылку deleteButton--%>
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>

    </c:forEach>

    <br>
<%--    Создаем кнопку Add. addNewEmployee - это метод из контролера кот.должен реализовать действие при нажатии на кнопку--%>
    <input type="button" value="Add"
           onclick="window.location.href = 'addNewEmployee'"/>
</table>

</body>

</html>>