<%@page import="Models.ResultModel"%>
<%@page import="Datas.BookSQLData"%>
<%@page import="Models.BookModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Datas.BookData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
BookSQLData bookSql = new BookSQLData();
ArrayList<BookModel> array = bookSql.GetAllBook();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="ThemSach.jsp">Them sach</a>
<hr>

<table border="1">
<thead>
<tr>
<th>Ma</th>
<th>Ten</th>
<th>Loai</th>
<th>Tac Gia</th>
<th>Thao tac</th>
</tr>
</thead>
<tbody>
<%
for(BookModel book: array){
	%>
	<tr>
	<td><%=book.getMa() %></td>
	<td><%=book.getTen() %></td>
	<td><%=book.getLoai() %></td>
	<td><%=book.getTacGia() %></td>
	<td>
	<a href="SuaBook.jsp?ma=<%=book.getMa()%>">Sua</a>
	<a href="XoaBook.jsp?ma=<%=book.getMa()%>">Xoa</a>
	</td>
	</tr>
	<%
}
%>
</tbody>
</table>
<hr>
<a href="Menu.jsp">Ve Menu</a>
</body>
</html>