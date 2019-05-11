package Datas;

import java.util.ArrayList;

import Models.EmployeeModel;
import Models.ResultModel;

public class EmployeeData {

	public ResultModel AddEmployee(ArrayList<EmployeeModel> employees, EmployeeModel employee)
	{
		for(EmployeeModel item: employees)
		{
			if(item.getManv().equals(employee.getManv())) {
				return new ResultModel(false, "Danh muc nay da ton tai!");
			}
		}
		employees.add(employee);
		return new ResultModel(true, "Them thanh cong!!");
	}
	public ResultModel DeleEmployee(ArrayList<EmployeeModel> employees, String ma)
	{
		for(EmployeeModel item: employees) {
			if(item.getManv().equals(ma)) {
				employees.remove(employees.indexOf(item));
				return new ResultModel(true, "Xoa thanh cong!!");
			}
		}
		return new ResultModel(false, "Xoa that bai!!");
	}
	public EmployeeModel FindEmployee(ArrayList<EmployeeModel> employees, String ma)
	{
		for(EmployeeModel item: employees) {
			if(item.getManv().equals(ma)) {
				return item;
			}
		}
		return null;
	}
	public ResultModel UpdateEmployee(ArrayList<EmployeeModel> employees, EmployeeModel employee)
	{
		for(EmployeeModel item: employees) {
			if(item.getManv().equals(employee.getManv())) {
				item.setTennv(employee.getTennv());
				item.setSdt(employee.getSdt());
				item.setEmail(employee.getEmail());
				item.setAddress(employee.getAddress());
				return new ResultModel(true, "Cap nhap thanh cong!!");
			}
		}
		return new ResultModel(false, "Cap nhap that bai!!");
	}
}
