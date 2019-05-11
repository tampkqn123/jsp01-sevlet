<%@page import="Models.ResultModel"%>
<%@page import="Models.CategoryModel"%>
<%@page import="Datas.CategorySqlData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
CategorySqlData categoryData = new CategorySqlData();
String ma = request.getParameter("ma");
CategoryModel find = categoryData.FindCategory(ma);
if(request.getParameter("sua")!=null){
	String ma1=request.getParameter("MaDM");
	String ten=request.getParameter("TenDM");
	String mota=request.getParameter("Mota");
	CategoryModel category = new CategoryModel(ma1, ten, mota);
	ResultModel result = categoryData.Update(category);
	out.print(result.getMessage());
}
%>
<title>Sua Category</title>
</head>
<body>
<form action='' method='post'>
<table>
<tr>
	<td>Ma danh muc</td>
	<td><input name='MaDM' value='<%=find.getMa()%>' readonly='readonly'></td>
</tr>
<tr>
	<td>Ten danh muc</td>
	<td><input name='TenDM' value='<%=find.getTen()%>'></td>
</tr>
<tr>
	<td>Mo ta</td>
	<td><input name='Mota' value='<%=find.getMota()%>'></td>
</tr>
<tr>
	<td colspan='2'><button type='submit' name='sua'>SUA</button></td>
</tr>
</table>
</form>
<hr>
<a href="ShowCategory.jsp">Tro Ve</a>
</body>
</html>