<%@page import="Models.CategoryModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Datas.CategorySqlData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
CategorySqlData categoryData = new CategorySqlData();
ArrayList<CategoryModel> getCategory = categoryData.GetAllCategory();
%>
<title>Category</title>
</head>
<body>
<a href="ThemCategory.jsp">Them Category</a>
<hr>
<table border=1>
<thead>
<tr>
	<th>Ma</th>
	<th>Ten</th>
	<th>Mo ta</th>
	<th>Thao tac</th>
</tr>
</thead>
<tbody>
<%for(CategoryModel item:getCategory){
%>
<tr>
	<td><%=item.getMa()%></td>
	<td><%=item.getTen()%></td>
	<td><%=item.getMota() %></td>
	<td>
		<a href="SuaCategory.jsp?ma=<%=item.getMa() %>">Sua</a>
		<a href="XoaCategory.jsp?ma=<%=item.getMa() %>">Xoa</a></td>
</tr>
<%} %>
</tbody>
</table>
<hr>
<a href="../Menu.jsp">Ve Menu</a>
</body>
</html>