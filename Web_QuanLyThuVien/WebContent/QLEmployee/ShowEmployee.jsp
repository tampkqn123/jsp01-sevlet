<%@page import="Models.CategoryModel"%>
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
ArrayList<EmployeeModel> getEmployee = employeeData.GetAllEmployee();
%>
<title>Employee</title>
</head>
<body>
<a href="ThemEmployee.jsp">Them NV</a>
<hr>
<table border=1>
<thead>
<tr>
	<th>Ma</th>
	<th>Ten</th>
	<th>SDT</th>
	<th>Email</th>
	<th>Address</th>
	<th>Thao tac</th>
</tr>
</thead>
<tbody>
<%for(EmployeeModel item:getEmployee){
	%>
	<tr>
		<td><%=item.getManv()%></td>
		<td><%=item.getTennv()%></td>
		<td><%=item.getSdt()%></td>
		<td><%=item.getEmail()%></td>
		<td><%=item.getAddress()%></td>
		<td>
			<a href="SuaEmployee.jsp?ma=<%=item.getManv()%>">Sua</a>
			<a href="XoaEmployee.jsp?ma=<%=item.getManv()%>">Xoa</a>
		</td>
	</tr>
<%} %>
</tbody>
</table>
<hr>
<a href="../Menu.jsp">Ve Menu</a>
</body>
</html>