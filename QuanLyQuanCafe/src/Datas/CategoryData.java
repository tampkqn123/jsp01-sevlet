package Datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.CategoryModel;
import Models.ResultModel;

public class CategoryData {
	public ArrayList<CategoryModel> GetAllCategory() throws Exception {
		ArrayList<CategoryModel> category = new ArrayList<CategoryModel>();
		SqlConnectionDatas connectData = new SqlConnectionDatas();
		String sql="select * from category";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id=result.getInt("id");
			String name=result.getString("name");
			CategoryModel categorys = new CategoryModel(id, name);
			category.add(categorys);
		}
		result.close();
		connectData.connect.close();
		return category;
	}
	public CategoryModel FindCategory(int id) throws Exception {
		SqlConnectionDatas connectData = new SqlConnectionDatas();
		String sql="select * from category where id=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		CategoryModel categorys = null;
		if(result.next()) {
			int id1=result.getInt("id");
			String name=result.getString("name");
			categorys = new CategoryModel(id1, name);
		}
		result.close();
		connectData.connect.close();
		return categorys;
	}
	public ResultModel AddCategory(CategoryModel addCategory) throws Exception {
		CategoryModel find = FindCategory(addCategory.getId());
		if(find!=null) {
			return new ResultModel(false, "Danh mục cần thêm đã tồn tại!");
		}
		else {
			SqlConnectionDatas connectData = new SqlConnectionDatas();
			String sql="insert into category (id, name) values (?, ?)";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setInt(1, addCategory.getId());
			statement.setString(2, addCategory.getName());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModel(false, "Thêm thất bại!");
			}
			else {
				return new ResultModel(true, "Thêm thành công!");
			}
		}
	}
	public ResultModel EditCategory(CategoryModel editCategory) throws Exception {
		CategoryModel find = FindCategory(editCategory.getId());
		if(find==null) {
			return new ResultModel(false, "Không tìm thấy danh mục cần sửa!");
		}
		else {
			SqlConnectionDatas connectData = new SqlConnectionDatas();
			String sql="update category set name=? where id=?";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, editCategory.getName());
			statement.setInt(2, editCategory.getId());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModel(false, "Sửa thất bại!");
			}
			else {
				return new ResultModel(true, "Sửa thành công!");
			}
		}
	}
	public ResultModel DeleteCategory(int id) throws Exception {
		CategoryModel find = FindCategory(id);
		if(find==null) {
			return new ResultModel(false, "Danh mục cần xóa không tồn tại!");
		}
		else {
			SqlConnectionDatas connectData = new SqlConnectionDatas();
			String sql="delete from category where id=?";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setInt(1, id);
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModel(false, "Xóa thất bại!");
			}
			else {
				return new ResultModel(true, "Xóa thành công!");
			}
		}
	}
}
