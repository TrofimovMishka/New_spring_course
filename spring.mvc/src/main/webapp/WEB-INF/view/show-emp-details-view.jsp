<!DOCTYPE html>
<html>
<body>
<h2>Dear employee , you are welcome!</h2>
<br>
<br>
<br>
<%--<h3> Your name: ${param.employeeName} <h3/>--%>
<!-- employeeName - имя переменной из другого view кот отвечает за сохраниние данных от пользователя-->

<h3> Your name: ${nameAttribute} ${description}<h3/>
    <!-- nameAttribute - это то имя которое мы присвоили в методе showEmployeeDetails() - model.addAttribute("nameAttribute", empName);-->

</body>

</html>