<%@page import="Models.CategoryModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Datas.CategorySqlData"%>
<%@page import="Models.ResultModel"%>
<%@page import="Models.BookModel"%>
<%@page import="Datas.BookSQLData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
BookSQLData bookData = new BookSQLData();
CategorySqlData categoryData = new CategorySqlData();
ArrayList<CategoryModel> category = categoryData.GetAllCategory();
if(request.getParameter("add")!=null){
	String masach=request.getParameter("masach");
	String tensach=request.getParameter("tensach");
	String tacgia=request.getParameter("tacgia");
	String loaisach=request.getParameter("loaisach");
	BookModel book = new BookModel(masach, tensach, tacgia, loaisach);
	ResultModel result = bookData.AddBook(book);
	out.print(result.getMessage());
}
%>
<title>Them Sach</title>
</head>
<body>
<form method='post' action="">
<label>Ma sach</label>
<input name='masach' type='text'>
<label>Ten sach</label>
<input name='tensach' type='text'>
<label>Tac gia</label>
<input name='tacgia' type='text'>
<label>Loai sach</label>
<select name="loaiSach">
<%
for(CategoryModel item: category){
	%>
	<option value="<%=item.getMa()%>"><%=item.getTen()%></option>
	<%
}
%>
</select>
<input type="submit" name="add" value="Gui">
</form>
<hr>
<a href="TestDataBook.jsp">Tro Ve</a>
</body>
</html>