package Datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.EmployeeModel;
import Models.ResultModel;

public class EmployeeData {
	public ArrayList<EmployeeModel> GetAllEmployee() throws Exception {
		ArrayList<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		SqlConnectionDatas connectData = new SqlConnectionDatas();
		String sql="select * from employee";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id=result.getInt(1);
			String name=result.getString("name");
			String regency=result.getString("regency");
			int phone=result.getInt(4);
			String mail=result.getString("mail");
			String address=result.getString("address");
			EmployeeModel employee = new EmployeeModel(id, name, regency, phone, mail, address);
			employees.add(employee);
		}
		result.close();
		connectData.connect.close();
		return employees;
	}
	public EmployeeModel FindEmployee(int id) throws Exception {
		SqlConnectionDatas connectData = new SqlConnectionDatas();
		String sql="select * from employee where id=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		EmployeeModel employee=null;
		if(result.next()) {
			int id1=result.getInt(1);
			String name=result.getString("name");
			String regency=result.getString("regency");
			int phone=result.getInt(4);
			String mail=result.getString("mail");
			String address=result.getString("address");
			employee = new EmployeeModel(id1, name, regency, phone, mail, address);
		}
		result.close();
		connectData.connect.close();
		return employee;
	}
	public ResultModel AddEmployee(EmployeeModel employee) throws Exception {
		EmployeeModel check = FindEmployee(employee.getId());
		if(check!=null) {
			return new ResultModel(false, "Nhân viên cần thêm đã tồn tại");
		}
		else {
			SqlConnectionDatas connectData = new SqlConnectionDatas();
			String sql="insert into employee(id, name, regency, phone, mail, address) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setInt(1, employee.getId());
			statement.setString(2, employee.getName());
			statement.setString(3, employee.getRegency());
			statement.setInt(4, employee.getPhone());
			statement.setString(5, employee.getMail());
			statement.setString(6, employee.getAddress());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModel(false, "Thêm nhân viên thất bại!");
			}
			else {
				return new ResultModel(true, "Thêm nhân viên thành công!");
			}
		}
	}
	public ResultModel EditEmployee(EmployeeModel editEmployee) throws Exception {
		EmployeeModel check = FindEmployee(editEmployee.getId());
		if(check==null) {
			return new ResultModel(false, "Nhân viên cần sửa không tồn tại!");
		}
		else {
			SqlConnectionDatas connectData = new SqlConnectionDatas();
			String sql="update employee set name=?, regency=?, phone=?, mail=?, address=? where id=?";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, editEmployee.getName());
			statement.setString(2, editEmployee.getRegency());
			statement.setInt(3, editEmployee.getPhone());
			statement.setString(4, editEmployee.getMail());
			statement.setString(5, editEmployee.getAddress());
			statement.setInt(5, editEmployee.getId());
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
	public ResultModel DeleteEmployee(int id) throws Exception {
		SqlConnectionDatas connectData = new SqlConnectionDatas();
		String sql="delete from employee where id=?";
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
