<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<!--Создаем зголовок -->
<h2>Dear employee, please enter you details: </h2>
<br> <!--Пустая строка -->
<br> <!--Пустая строка -->

<%--<!--Создаем форму -->--%>
<%--<!--action связан с кнопкой submit на странице. Когда мы ее нажимаем должен произойти переход по адресу showDetails-->--%>
<%--<form action="showDetails" method="get">--%>
<%--    <!--type="text" - какой тип данных, name="employeeName" - имя поля которое будет хранить введенное значение . placeholder="Write your name" - то что видит пользователь в поле ввода-->--%>
<%--    <input type="text" name="employeeName" placeholder="Write your name"/>--%>
<%--    <!-- type="submit" - обозначает тип используемой кнопки в окне клиента-->--%>
<%--    <input type="submit"/>--%>

<form:form action="showDetails" modelAttribute="employee"> <!-- modelAttribute="employee" - это то что создаем в методе askEmployeeDetails контроллера-->
    Name <form:input path="name"/> <!-- Создаем форму ввода с надписью Name кот будет хранить в переменной name введенную пользователем инфу и это поле из атрибута modelAttribute="employee"-->
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    <input type="submit" value="Ok"> <!-- Создаем нопку с надписью Ok-->
</form:form>

</form>
</body>

</html>