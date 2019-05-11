package Datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.EmployeeModel;
import Models.ResultModel;

public class EmployeeSQLData {
	
	public ArrayList<EmployeeModel> GetAllEmployee() throws Exception
	{
		ArrayList<EmployeeModel> employee = new ArrayList<EmployeeModel>();
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="select * from employee";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			String manv=result.getString("ma");
			String tennv=result.getString("ten");
			String sdt=result.getString("sdt");
			String email=result.getString("email");
			String diachi=result.getString("diachi");
			EmployeeModel employee1=new EmployeeModel(manv, tennv, sdt, email, diachi);
			employee.add(employee1);
		}
		result.close();
		connectData.connect.close();
		return employee;
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
			String manv=result.getString("ma");
			String tennv=result.getString("ten");
			String sdt=result.getString("sdt");
			String email=result.getString("email");
			String diachi=result.getString("diachi");
			employee = new EmployeeModel(manv, tennv, sdt, email, diachi);
		}
		result.close();
		connectData.connect.close();
		return employee;
		
	}
	public ResultModel AddEmployee(EmployeeModel employee) throws Exception
	{
		EmployeeModel check = FindEmployee(employee.getManv());
		if(check!=null) {
			return new ResultModel(false, "Nhan vien can them da ton tai!");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="insert into employee(ma, ten, sdt, email, diachi) values(?, ?, ?, ?, ?)";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, employee.getManv());
			statement.setString(2, employee.getTennv());
			statement.setString(3, employee.getSdt());
			statement.setString(4, employee.getEmail());
			statement.setString(5, employee.getAddress());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModel(false, "Them that bai!");
			}
			else {
				return new ResultModel(true, "Them thanh cong");
			}
		}
	}
	public ResultModel UpdateEmployee(EmployeeModel employee) throws Exception
	{
		EmployeeModel check = FindEmployee(employee.getManv());
		if(check==null) {
			return new ResultModel(false, "Nhan vien can update khong ton tai");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="update employee set ten=?, sdt=?, email=?, diachi=? where ma=?";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, employee.getTennv());
			statement.setString(2, employee.getSdt());
			statement.setString(3, employee.getEmail());
			statement.setString(4, employee.getAddress());
			statement.setString(5, employee.getManv());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModel(false, "Update that bai!");
			}
			else {
				return new ResultModel(true, "Update thanh cong");
			}
		}
	}
	public ResultModel DeleEmployee(String ma) throws Exception
	{
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="delete from employee where ma=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setString(1, ma);
		int i = statement.executeUpdate();
		connectData.connect.close();
		if(i==0) {
			return new ResultModel(false, "Xoa that bai!");
		}
		else {
			return new ResultModel(true, "Xoa thanh cong!");
		}
	}
}
