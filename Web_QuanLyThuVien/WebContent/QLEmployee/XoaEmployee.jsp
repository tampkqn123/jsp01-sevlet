<%@page import="Models.ResultModel"%>
<%@page import="Models.EmployeeModel"%>
<%@page import="Datas.EmployeeSQLData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
EmployeeSQLData employeeData = new EmployeeSQLData();
String ma=request.getParameter("ma");
EmployeeModel deleEmployee = employeeData.FindEmployee(ma);
ResultModel result = employeeData.DeleEmployee(ma);
out.print(result.getMessage());
%>
<title>Xoa Employee</title>
</head>
<body>
<hr>
<a href="ShowEmployee.jsp">Tro Ve</a>
</body>
</html>