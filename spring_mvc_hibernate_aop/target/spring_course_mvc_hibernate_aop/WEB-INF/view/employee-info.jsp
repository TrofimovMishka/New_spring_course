<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
!DOCTYPE html>
<html>
<body>
<h2>Employee info</h2>
<br>
<%--saveEmployee - Это метод из класса контроллер, кот.отвечет за сохраниение обьекта и вывод нового окна--%>
<%--employee - Это атрибут из модели, кот.создана в классе контроллера для создания нового работника--%>
<form:form action = "saveEmployee" modelAttribute="employee">

<%--    Создаем скрытую форму для id ее не будет видно в окне -
но это инфа нужна для того чтобы сохранить изменения в конкретном работнике при вызове метода saveEmployee класса Mycontroller--%>
    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br>
    Surname <form:input path="surname"/>
    <br>
    Department <form:input path="department"/>
    <br>
    Salary <form:input path="salary"/>
    <br>
    <input type="submit" value="Ok"/>
    <br>

</form:form>

</body>

</html>>