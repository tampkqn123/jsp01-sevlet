import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import Datas.EmployeeData;
import Models.EmployeeModel;
import Models.ResultModel;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int n=-1;
	ArrayList<EmployeeModel> employees = new ArrayList<EmployeeModel>();
	EmployeeData employeeData = new EmployeeData();
	do {
		System.out.println("\n1.Hien thi danh sach nhan vien!");
		System.out.println("2. Them nhan vien!");
		System.out.println("3. Tim kiem nhan vien!");
		System.out.println("4. Xoa nhan vien!");
		System.out.println("5. Cap nhap nhan vien!");
		n = Integer.valueOf(GetStr());
		if(n==1) {
			for(EmployeeModel item: employees) {
				System.out.print(item.getManv()+"||");
				System.out.print(item.getTennv()+"||");
				System.out.print(item.getSdt()+"||");
				System.out.print(item.getEmail()+"||");
				System.out.println(item.getAddress()+"||");
			}
		}
		if(n==2) {
			System.out.print("Nhap ma nhan vien: ");
			String maNV=GetStr();
			System.out.print("Nhap ten nhan vien: ");
			String tenNV=GetStr();
			System.out.print("Nhap SDT nhan vien: ");
			String sdtNV=GetStr();
			System.out.print("Nhap Email nhan vien: ");
			String emailNV=GetStr();
			System.out.print("Nhap dia chi nhan vien: ");
			String diachi=GetStr();
			EmployeeModel employee = new EmployeeModel(maNV, tenNV, sdtNV, emailNV, diachi);
			ResultModel result = employeeData.AddEmployee(employees, employee);
			System.out.println(result.getMessage());
		}
		if(n==3) {
			System.out.print("Nhap ma nhan vien can tim: ");
			String ma=GetStr();
			EmployeeModel find = employeeData.FindEmployee(employees, ma);
			if(find==null) {
				System.out.println("Khong tim thay nhan vien!!");
			}
			else {
				System.out.print(find.getManv()+"||");
				System.out.print(find.getTennv()+"||");
				System.out.print(find.getSdt()+"||");
				System.out.print(find.getEmail()+"||");
				System.out.println(find.getAddress()+"||");
			}
		}
		if(n==4) {
			System.out.print("Nhap ma nhan vien can xoa: ");
			String ma=GetStr();
			ResultModel dele = employeeData.DeleEmployee(employees, ma);
			System.out.println(dele.getMessage());
		}
		if(n==5) {
			System.out.println("Nhap ma nhan vien can sua: ");
			String ma = GetStr();
			EmployeeModel find = employeeData.FindEmployee(employees, ma);
			if(find==null) {
				System.out.println("Khong tim thay nhan vien can sua!!");
			}
			else {
				System.out.print(find.getManv()+"||");
				System.out.print(find.getTennv()+"||");
				System.out.print(find.getSdt()+"||");
				System.out.print(find.getEmail()+"||");
				System.out.println(find.getAddress()+"||");
				System.out.print("Nhap ten nhan vien can sua: ");
				String tennv1=GetStr();
				System.out.print("Nhap sdt can sua: ");
				String sdtnv1=GetStr();
				System.out.print("Nhap email can sua: ");
				String email1=GetStr();
				System.out.print("Nhap dia chi can sua: ");
				String diachi1=GetStr();
				EmployeeModel employee1= new EmployeeModel(ma, tennv1, sdtnv1, email1, diachi1);
				ResultModel result = employeeData.UpdateEmployee(employees, employee1);
				System.out.println(result.getMessage());
			}
			
		}
	}while(n!=0);
	}
	private static String GetStr()
	{
		DataInputStream stream = new DataInputStream(System.in);
		try {
			return stream.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
