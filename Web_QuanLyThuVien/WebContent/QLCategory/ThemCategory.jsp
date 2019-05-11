<%@page import="Models.ResultModel"%>
<%@page import="Datas.CategorySqlData"%>
<%@page import="Models.CategoryModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Datas.CategoryData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%


CategorySqlData categoryData = new CategorySqlData();
ArrayList<CategoryModel> category = categoryData.GetAllCategory();
if(request.getParameter("add")!=null){
	String ma=request.getParameter("MaDM");
	String ten=request.getParameter("TenDM");
	String mota=request.getParameter("Mota");
	CategoryModel categorys = new CategoryModel(ma, ten, mota);
	ResultModel result = categoryData.AddCategory(categorys);
	out.print(result.getMessage());
}
%>
<title>Them Category</title>
</head>
<body>
<form action="" method="post">
<label>Ma danh muc</label>
<input name='MaDM' type='text'><br><br>
<label>Ten danh muc</label>
<input name='TenDM' type='text'><br><br>
<label>Mo ta</label>
<input name='Mota' type='text'><br><br>
<input type='submit' name='add' value='THEM'>
</form>
<hr>
<a href="ShowCategory.jsp">Tro ve</a>
</body>
</html>