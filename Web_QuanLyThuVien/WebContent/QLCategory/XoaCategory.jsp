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
String ma= request.getParameter("ma");
CategoryModel find = categoryData.FindCategory(ma);
ResultModel result = categoryData.Dele(ma);
out.print(result.getMessage());
%>
<title>Xoa Category</title>
</head>
<body>
<hr>
<a href="ShowCategory.jsp">Tro Ve</a>
</body>
</html>