package Datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.DrinksModel;
import Models.ResultModel;

public class DrinksDatas {
	public ArrayList<DrinksModel> GetAllDrinks() throws Exception	{
		ArrayList<DrinksModel> drinks = new ArrayList<DrinksModel>();
		SqlConnectionDatas connectData = new SqlConnectionDatas();
		String sql="select * from drinks";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int ma=result.getInt(1);
			String name=result.getString("name");
			String category=result.getString("category");
			int price=result.getInt(4);
			DrinksModel drink = new DrinksModel(ma, name, category, price);
			drinks.add(drink);
		}
		result.close();
		connectData.connect.close();
		return drinks;
	}
	public DrinksModel FindDrinks(int id) throws Exception {
		SqlConnectionDatas connectData = new SqlConnectionDatas();
		String sql="select * from drinks where id=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		DrinksModel drink = null;
		if(result.next()) {
			int ma1=result.getInt(1);
			String name=result.getString("name");
			String category=result.getString("category");
			int price=result.getInt(4);
			drink = new DrinksModel(ma1, name, category, price);
		}
		result.close();
		connectData.connect.close();
		return drink;
	}
	public ResultModel AddDrinks(DrinksModel addDrinks) throws Exception {
		DrinksModel check = FindDrinks(addDrinks.getId());
		if(check!=null) {
			return new ResultModel(false, "Đồ uống cần thêm đã tồn tại!");
		}
		else {
			SqlConnectionDatas connectData = new SqlConnectionDatas();
			String sql="insert into drinks(id, name, category, price) values(?, ?, ?, ?)";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setInt(1, addDrinks.getId());
			statement.setString(2, addDrinks.getName());
			statement.setString(3, addDrinks.getCategory());
			statement.setInt(4, addDrinks.getPrice());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModel(false, "Thêm đồ uống thất bại!");
			}
			else {
				return new ResultModel(true, "Thêm đồ uống thành công!");
			}
		}
	}
	public ResultModel EditDrinks(DrinksModel editDrinks) throws Exception {
		DrinksModel check = FindDrinks(editDrinks.getId());
		if(check==null) {
			return new ResultModel(false, "Đồ uống cần thêm không tồn tại!");
		}
		else {
			SqlConnectionDatas connectData = new SqlConnectionDatas();
			String sql="update drinks set name=?, category=?, price=? where id=?";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, editDrinks.getName());
			statement.setString(2, editDrinks.getCategory());
			statement.setInt(3, editDrinks.getPrice());
			statement.setInt(4, editDrinks.getId());
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
	public ResultModel DeleteDrinks(int id) throws Exception {
		SqlConnectionDatas connectData = new SqlConnectionDatas();
		String sql="delete from drinks where id=?";
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
