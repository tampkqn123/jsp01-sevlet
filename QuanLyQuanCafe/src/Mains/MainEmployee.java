package Mains;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import Datas.EmployeeData;
import Models.EmployeeModel;
import Models.ResultModel;

public class MainEmployee {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int n=-1;
		EmployeeData employeeData = new EmployeeData();
		do {
			System.out.println("1. Hiển thị thông tin nhân viên!");
			System.out.println("2. Tìm kiếm thông tin nhân viên!");
			System.out.println("3. Thêm Nhân viên!");
			System.out.println("4. Sửa thông tin nhân viên!");
			System.out.println("5. Xóa thông tin nhân viên!");
			System.out.println("6. Về Menu chính!");
			n = Integer.valueOf(GetStr());
			if(n==1) {
				ArrayList<EmployeeModel> employee = employeeData.GetAllEmployee();
				for(EmployeeModel item:employee) {
					System.out.print(item.getId()+"||");
					System.out.print(item.getName()+"||");
					System.out.print(item.getRegency()+"||");
					System.out.print(item.getPhone()+"||");
					System.out.print(item.getMail()+"||");
					System.out.println(item.getAddress());
					System.out.println("--------------------");
				}
			}
			if(n==2) {
				System.out.println("Nhập ID nhân viên cần tìm: ");
				int id = Integer.valueOf(GetStr());
				EmployeeModel find = employeeData.FindEmployee(id);
				if(find==null) {
					System.out.println("Không tìm thấy thông tin nhân viên cần tìm!");
				}
				else {
					System.out.print(find.getId()+"||");
					System.out.print(find.getName()+"||");
					System.out.print(find.getRegency()+"||");
					System.out.print(find.getPhone()+"||");
					System.out.print(find.getMail()+"||");
					System.out.println(find.getAddress());
					System.out.println("--------------------");
				}
			}
			if(n==3) {
				System.out.println("Nhập ID: ");
				int id = Integer.valueOf(GetStr());
				System.out.println("Nhập tên: ");
				String name=GetStr();
				System.out.println("Nhập chức vụ: ");
				String regency=GetStr();
				System.out.println("Nhập sđt: ");
				int sdt=Integer.valueOf(GetStr());
				System.out.println("Nhập mail: ");
				String mail=GetStr();
				System.out.println("Nhập địa chỉ: ");
				String diachi=GetStr();
				EmployeeModel employee = new EmployeeModel(id, name, regency, sdt, mail, diachi);
				ResultModel result = employeeData.AddEmployee(employee);
				System.out.println(result.getMessage());
			}
			if(n==4) {
				System.out.println("Nhập ID nhân viên cần sửa: ");
				int id = Integer.valueOf(GetStr());
				EmployeeModel find = employeeData.FindEmployee(id);
				if(find==null) {
					System.out.println("Không có nhân viên cần sửa!");
				}
				else {
					System.out.print(find.getId()+"||");
					System.out.print(find.getName()+"||");
					System.out.print(find.getRegency()+"||");
					System.out.print(find.getPhone()+"||");
					System.out.print(find.getMail()+"||");
					System.out.println(find.getAddress());
					System.out.println("--------------------");
					System.out.println("Nhập tên: ");
					String name=GetStr();
					System.out.println("Nhập chức vụ: ");
					String regency=GetStr();
					System.out.println("Nhập sđt: ");
					int sdt=Integer.valueOf(GetStr());
					System.out.println("Nhập mail: ");
					String mail=GetStr();
					System.out.println("Nhập địa chỉ: ");
					String diachi=GetStr();
					EmployeeModel employee = new EmployeeModel(id, name, regency, sdt, mail, diachi);
					ResultModel result = employeeData.AddEmployee(employee);
					System.out.println(result.getMessage());
				}
				
			}
			if(n==5) {
				System.out.println("Nhập ID nhân viên cần xóa: ");
				int id=Integer.valueOf(GetStr());
				EmployeeModel find = employeeData.FindEmployee(id);
				if(find==null) {
					System.out.println("Không có nhân viên cần xóa!");
				}
				else {
					ResultModel result = employeeData.DeleteEmployee(id);
					System.out.println(result.getMessage());
				}
			}
		}while(n!=6);
	}
	private static String GetStr() {
		DataInputStream stream = new DataInputStream (System.in);
		try {
			return stream.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
