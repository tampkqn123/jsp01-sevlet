package Main;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import Datas.EmployeeSQLData;
import Models.EmployeeModel;
import Models.ResultModes;

public class MainEmployee {

	public static void main(String[] args) throws Exception{
		EmployeeSQLData employeeData = new EmployeeSQLData();
		int n=-10;
		do {
			System.out.println("\n1. Hien thi nhan vien!");
			System.out.println("2. Tim kiem nhan vien!");
			System.out.println("3. Them nhan vien!");
			System.out.println("4. Edit nhan vien!");
			System.out.println("5. Delete nhan vien!");
			System.out.println("6. Tro ve menu chinh!");
			n = Integer.valueOf(GetStr());
			if(n==1) {
				ArrayList<EmployeeModel> employees = employeeData.GetAllEmployee();
				for(EmployeeModel item: employees) {
					System.out.print(item.getMa()+"||");
					System.out.print(item.getTen()+"||");
					System.out.print(item.getSdt()+"||");
					System.out.print(item.getEmail()+"||");
					System.out.println(item.getDiachi());
				}
			}
			if(n==2) {
				System.out.println("Nhap ma nhan vien can tim:");
				String ma = GetStr();
				EmployeeModel find = employeeData.FindEmployee(ma);
				if(find==null) {
					System.out.println("Khong tim thay nv can tim!");
				}
				else {
					System.out.print(find.getMa()+"||");
					System.out.print(find.getTen()+"||");
					System.out.print(find.getSdt()+"||");
					System.out.print(find.getEmail()+"||");
					System.out.println(find.getDiachi());
				}
			}
			if(n==3) {
				System.out.println("Nhap ma: ");
				String ma = GetStr();
				System.out.println("Nhap ten: ");
				String ten = GetStr();
				System.out.println("Nhap sdt: ");
				String sdt = GetStr();
				System.out.println("Nhap email: ");
				String email = GetStr();
				System.out.println("Nhap dia chi: ");
				String diachi = GetStr();
				EmployeeModel employee = new EmployeeModel(ma, ten, sdt, email, diachi);
				ResultModes result = employeeData.AddEmployee(employee);
				System.out.println(result.getMessage());
				
			}
			if(n==4) {
				System.out.println("Nhap ma nv can sua: ");
				String ma = GetStr();
				EmployeeModel find = employeeData.FindEmployee(ma);
				if(find==null) {
					System.out.println("Khong tim thay nv can edit!");
				}
				else {
					System.out.print(find.getMa()+"||");
					System.out.print(find.getTen()+"||");
					System.out.print(find.getSdt()+"||");
					System.out.print(find.getEmail()+"||");
					System.out.println(find.getDiachi());
					System.out.println("Nhap ten edit: ");
					String ten = GetStr();
					System.out.println("Nhap sdt edit: ");
					String sdt = GetStr();
					System.out.println("Nhap email edit: ");
					String email = GetStr();
					System.out.println("Nhap dia chi edit: ");
					String diachi = GetStr();
					EmployeeModel employee = new EmployeeModel(ma, ten, sdt, email, diachi);
					ResultModes result = employeeData.UpdateEmployee(employee);
					System.out.println("----Thong tin sau khi edit----");
					System.out.print(employee.getMa()+"||");
					System.out.print(employee.getTen()+"||");
					System.out.print(employee.getSdt()+"||");
					System.out.print(employee.getEmail()+"||");
					System.out.println(employee.getDiachi());
					System.out.println(result.getMessage());
				}
			}
			if(n==5) {
				System.out.println("Nhap ma nv can delete: ");
				String ma = GetStr();
				EmployeeModel find = employeeData.FindEmployee(ma);
				if(find==null) {
					System.out.println("Khong tim thay nhan vien can delete!");
				}
				else {
					System.out.print(find.getMa()+"||");
					System.out.print(find.getTen()+"||");
					System.out.print(find.getSdt()+"||");
					System.out.print(find.getEmail()+"||");
					System.out.println(find.getDiachi());
					System.out.println("---------------------");
					ResultModes result = employeeData.DeleEmployee(find);
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
