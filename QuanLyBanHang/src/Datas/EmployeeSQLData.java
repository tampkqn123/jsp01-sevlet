package Datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.EmployeeModel;
import Models.ResultModes;

public class EmployeeSQLData {
	public ArrayList<EmployeeModel> GetAllEmployee() throws Exception
	{
		ArrayList<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="select * from employee";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			String ma = result.getString("ma");
			String ten = result.getString("ten");
			String sdt = result.getString("sdt");
			String email = result.getString("email");
			String diachi = result.getString("diachi");
			EmployeeModel employee = new EmployeeModel(ma, ten, sdt, email, diachi);
			employees.add(employee);
		}
		result.close();
		connectData.connect.close();
		return employees;
	}
	public EmployeeModel FindEmployee(String ma) throws Exception
	{
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="select * from employee where ma=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setString(1, ma);
		ResultSet result = statement.executeQuery();
		EmployeeModel employee = null;
		if(result.next()) {
			String ma1 = result.getString("ma");
			String ten = result.getString("ten");
			String sdt = result.getString("sdt");
			String email = result.getString("email");
			String diachi = result.getString("diachi");
			employee = new EmployeeModel(ma1, ten, sdt, email, diachi);
		}
		connectData.connect.close();
		result.close();
		return employee;
	}
	public ResultModes AddEmployee(EmployeeModel employee) throws Exception
	{
		EmployeeModel check = FindEmployee(employee.getMa());
		if(check!=null) {
			return new ResultModes(false, "Nhan vien da ton tai!");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="insert into employee(ma, ten, sdt, email, diachi) values(?, ?, ?, ?, ?)";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, employee.getMa());
			statement.setString(2, employee.getTen());
			statement.setString(3, employee.getSdt());
			statement.setString(4, employee.getEmail());
			statement.setString(5, employee.getDiachi());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModes(false, "Them that bai!");
			}
			else {
				return new ResultModes(true, "Them thanh cong!");
			}
		}
	}
	public ResultModes UpdateEmployee(EmployeeModel update) throws Exception
	{
		EmployeeModel check = FindEmployee(update.getMa());
		if(check==null) {
			return new ResultModes(false, "Nhan vien nay khong ton tai!");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="update employee set ten=?, sdt=?, email=?, diachi=? where ma=?";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, update.getTen());
			statement.setString(2, update.getSdt());
			statement.setString(3, update.getEmail());
			statement.setString(4, update.getDiachi());
			statement.setString(5, update.getMa());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModes(false, "Update that bai!");
			}
			else {
				return new ResultModes(true, "Update thanh cong!");
			}
		}
	}
	public ResultModes DeleEmployee(EmployeeModel dele) throws Exception
	{
		EmployeeModel check = FindEmployee(dele.getMa());
		if(check==null) {
			return new ResultModes(false, "Khong tim thay nhan vien can xoa!");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="delete from employee where ma=?";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, dele.getMa());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModes(false, "Delete that bai!");
			}
			else {
				return new ResultModes(true, "Delete thanh cong!");
			}
		}
	}
}
