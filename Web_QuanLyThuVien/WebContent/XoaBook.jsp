<%@page import="Models.ResultModel"%>
<%@page import="Datas.BookSQLData"%>
<%@page import="Models.BookModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
BookSQLData bookData = new BookSQLData();

String ma = request.getParameter("ma");
BookModel book = bookData.FindBook(ma);
ResultModel result = bookData.DeleBook(book);
out.print(result.getMessage());
%>
<title>Xoa Sach</title>
</head>
<body>
<hr>
<a href="TestDataBook.jsp">Tro Ve</a>
</body>
</html>