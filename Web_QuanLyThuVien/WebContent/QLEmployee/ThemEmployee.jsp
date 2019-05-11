<%@page import="Models.ResultModel"%>
<%@page import="Models.EmployeeModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Datas.EmployeeSQLData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
EmployeeSQLData employeeData = new EmployeeSQLData();
ArrayList<EmployeeModel> employee = employeeData.GetAllEmployee();
if(request.getParameter("add")!=null){
	String manv=request.getParameter("maNV");
	String tennv=request.getParameter("tenNV");
	String sdtnv=request.getParameter("sdtNV");
	String email=request.getParameter("emailNV");
	String diachi=request.getParameter("diachiNV");
	EmployeeModel employees = new EmployeeModel(manv, tennv, sdtnv, email, diachi);
	ResultModel result = employeeData.AddEmployee(employees);
	out.print(result.getMessage());
}
%>
<title>Them NV</title>
</head>
<body>
<form action="" method='post'>
<label>Ma Nhan Vien</label>
<input name='maNV' type='text'><br><br>
<label>Ten Nhan Vien</label>
<input name='tenNV' type='text'><br><br>
<label>SDT Nhan Vien</label>
<input name='sdtNV' type='text'><br><br>
<label>Email Nhan Vien</label>
<input name='emailNV' type='text'><br><br>
<label>Dia Chi Nhan Vien</label>
<input name='diachiNV' type='text'><br><br>
<input type='submit' name='add' value='Gui'><br>
</form>
<hr>
<a href="ShowEmployee.jsp">Tro Ve</a>
</body>
</html>