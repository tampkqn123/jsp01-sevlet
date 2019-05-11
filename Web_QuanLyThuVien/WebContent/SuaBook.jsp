<%@page import="Models.CategoryModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Datas.CategorySqlData"%>
<%@page import="Models.ResultModel"%>
<%@page import="Datas.BookSQLData"%>
<%@page import="Models.BookModel"%>
<%@page import="Datas.BookData"%>
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
if(request.getParameter("suaSach") != null){
	String maSach = request.getParameter("maSach");
	String tenSach = request.getParameter("tenSach");
	String loaiSach = request.getParameter("loaiSach");
	String tacGia = request.getParameter("tacGia");
	
	BookModel bookUpdate = new BookModel(maSach,tenSach,tacGia,loaiSach);
	ResultModel result = bookData.UpdateBook(bookUpdate);
	out.print(result.getMessage());
	
}
String ma = request.getParameter("ma");
BookModel book = bookData.FindBook(ma);
%>
<title>Sua sach</title>
</head>
<body>
<form action="" method="post">
<table>
<tr>
<td>Ma</td>
<td><input name="maSach" value="<%=book.getMa()%>" readonly="readonly"></td>
</tr>
<tr>
<td>Ten</td>
<td><input name="tenSach" value="<%=book.getTen()%>"></td>
</tr>
<tr>
<td>Loai</td>
	<td>
		<select name="loaiSach">
		<%
		for(CategoryModel item: category){
			%>
			<option value="<%=item.getMa()%>"><%=item.getTen()%></option>
			<%
		}
		%>
</select>
	</td>
</tr>
<tr>
<td>Tac gia</td>
<td><input name="tacGia" value="<%=book.getTacGia()%>"></td>
</tr>
<tr><td colspan="2"><button type="submit" name="suaSach">sua</button></td></tr>
</table>
</form>
<hr>
<a href="TestDataBook.jsp">Tro Lai</a>
</body>
</html>