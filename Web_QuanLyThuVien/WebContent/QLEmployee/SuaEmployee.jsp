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
if(request.getParameter("suaEmployee")!=null){
	String maNV=request.getParameter("maNV");
	String tenNV=request.getParameter("tenNV");
	String sdtNV=request.getParameter("sdtNV");
	String emailNV=request.getParameter("emailNV");
	String diachi=request.getParameter("diachi");
	EmployeeModel updateEmployee = new EmployeeModel(maNV, tenNV, sdtNV, emailNV, diachi);
	ResultModel result = employeeData.UpdateEmployee(updateEmployee);
}
String ma = request.getParameter("ma");
EmployeeModel employee = employeeData.FindEmployee(ma);
%>
<title>Sua Employee</title>
</head>
<body>
<form action="" method="post">
<table>
<tr>
<td>Ma</td>
<td><input name="maNV" value="<%=employee.getManv()%>" readonly="readonly"></td>
</tr>
<tr>
<td>Ten</td>
<td><input name="tenNV" value="<%=employee.getTennv()%>"></td>
</tr>
<tr>
<td>SDT</td>
<td><input name="sdtNV" value="<%=employee.getSdt()%>"></td>
</tr>
<tr>
<td>Email</td>
<td><input name="emailNV" value="<%=employee.getEmail()%>"></td>
</tr>
<tr>
<td>Dia Chi</td>
<td><input name="diachi" value="<%=employee.getAddress()%>"></td>
</tr>
<tr><td colspan="2"><button type="submit" name="suaEmployee">sua</button></td></tr>
</table>
</form>
<hr>
<a href="ShowEmployee.jsp">Tro Ve</a>
</body>
</html>