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
    <%--    Указываем что поле может выбросить сообщение отб не правильных данных--%>
    <form:errors path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <%--    Указываем что поле может выбросить сообщение отб не правильных данных--%>
    <form:errors path="surname"/>
    <br><br>
    Salary <form:input path="salary" />
    <%--    Указываем что поле может выбросить сообщение отб не правильных данных--%>
    <form:errors path="salary"/>
    <br><br>
<%--    <!-- Организовываем выпадающий список: hard code-->--%>
<%--    Department <form:select path="department">--%>
<%--        <!--Опции при раскрытии списка:-->--%>
<%--        <form:option value="Information Technology" label="IT"/>--%>
<%--        <form:option value="Human Resouse" label="HR"/>--%>
<%--        <form:option value="Sales" label="Sales"/>--%>
<%--    </form:select>--%>
<%--    <br><br>--%>
    <!-- Организовываем выпадающий список: Чтобы не хардкодить имена департаментов создадим в классе Employee мапу с департаментами-->
    Department <form:select path="department">--%>
            <!--Опции при раскрытии списка:-->
            <form:options items="${employee.departments}"/>
        </form:select>
        <br><br>

<%--    <!-- Организовываем переключатель:  hard code-->--%>
<%--    Witch car do you want?--%>
<%--    BMW <form:radiobutton path="car" value="BMW"/>--%>
<%--    Mercedes <form:radiobutton path="car" value="Mercedes-Benz"/>--%>
<%--    Audi <form:radiobutton path="car" value="Audi"/>--%>
<%--    <br><br>--%>

    <!-- Организовываем переключатель:  Чтобы не хардкодить имена марок создадим в классе Employee мапу с марками авто-->
    Witch car do you want?
    <form:radiobuttons path="car" items="${employee.cars}"/>
    <br><br>

<%--    <!-- Организовываем флаги()множеств. выбор HARD CODE-->--%>
<%--    Foreign languages?--%>
<%--    EN <form:checkbox path="languages" value="English"/>--%>
<%--    DE <form:checkbox path="languages" value="Deutch"/>--%>
<%--    FR <form:checkbox path="languages" value="France"/>--%>
<%--    <br><br>--%>

    <!-- Организовываем флаги()множеств. Чтобы не хардкодить языки создадим в классе Employee мапу с языками -->
    Foreign languages?
    <form:checkboxes path="languages" items="${employee.languagesList}"/>
    <br><br>

    phone number <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>

    <br><br>

    <input type="submit" value="Ok"> <!-- Создаем нопку с надписью Ok-->


    
</form:form>

</form>
</body>

</html>