package Datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Models.CategoryModel;
import Models.ResultModel;

public class CategorySqlData {
	public ArrayList<CategoryModel> GetAllCategory() throws Exception{
		ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
		SqlConnectionData connectData=new SqlConnectionData();
		String sql="Select * From Category";
		Statement statement = connectData.connect.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while(result.next()) {
			String ma = result.getString("ma");
			String ten = result.getString("ten");
			String mota = result.getString("mota");
			CategoryModel category = new CategoryModel(ma, ten, mota);
			categories.add(category);
		}
		result.close();
		connectData.connect.close();
		return categories;
	}
	public CategoryModel FindCategory(String ma) throws Exception
	{
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="select * from Category where ma=" + ma;
		Statement statement = connectData.connect.createStatement();
		ResultSet result = statement.executeQuery(sql);
		CategoryModel category = null;
		if(result.next()) {
			String ma1 = result.getString("ma");
			String ten = result.getString("ten");
			String mota = result.getString("mota");
		category = new CategoryModel(ma1, ten, mota);
		}
		result.close();
		connectData.connect.close();
		return category;
	}
	public ResultModel AddCategory(CategoryModel categoryAdd) throws Exception
	{
		CategoryModel find = FindCategory(categoryAdd.getMa());
		if(find!=null) {
			return new ResultModel(false, "Danh muc da ton tai!");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="insert into category(ma, ten, mota) values(?,?,?)";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, categoryAdd.getMa());
			statement.setString(2, categoryAdd.getTen());
			statement.setString(3, categoryAdd.getMota());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i == 0) {
				return new ResultModel(false, "Them that bai");
			}
			else {
				return new ResultModel(true, "Them thanh cong");
			}
		}
	}
	public ResultModel Update(CategoryModel category) throws Exception
	{
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="update category set ten=?, mota=? where ma=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setString(1, category.getTen());
		statement.setString(2, category.getMota());
		statement.setString(3, category.getMa());
		int i = statement.executeUpdate();
		connectData.connect.close();
		if(i==0) {
			return new ResultModel(false, "Cap nhap that bai!");
		}
		else {
			return new ResultModel(true, "Cap nhap thanh cong!");
		}
	}
	public ResultModel Dele(String ma) throws Exception
	{
		SqlConnectionData connecData = new SqlConnectionData();
		String sql="delete from category where ma=?";
		PreparedStatement statement = connecData.connect.prepareStatement(sql);
		statement.setString(1, ma);
		int i = statement.executeUpdate();
		connecData.connect.close();
		if(i==0) {
			return new ResultModel(false, "Xoa that bai!");
		}
		else {
			return new ResultModel(true, "Xoa thanh cong!!");
		}
	}
}
