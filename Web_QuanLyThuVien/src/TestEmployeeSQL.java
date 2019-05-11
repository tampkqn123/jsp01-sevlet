import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import Datas.EmployeeSQLData;
import Models.EmployeeModel;
import Models.ResultModel;

public class TestEmployeeSQL {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		EmployeeSQLData employeeSQL = new EmployeeSQLData();
		int n = -1;
		do {
			System.out.println("\n1.Hien thi danh sach nhan vien");
			System.out.println("2. Nhap them danh sach nhan vien");
			System.out.println("3. Tim kiem");
			System.out.println("4. Update nhan vien");
			System.out.println("5. Xoa nhan vien");
			System.out.println("6. Quay lai menu chinh");
			n=Integer.valueOf(GetStr());
			if(n==1) {
				ArrayList<EmployeeModel> employeeGet = employeeSQL.GetAllEmployee(); 
				for(EmployeeModel item: employeeGet) {
					System.out.print(item.getManv()+"||");
					System.out.print(item.getTennv()+"||");
					System.out.print(item.getSdt()+"||");
					System.out.print(item.getEmail()+"||");
					System.out.println(item.getAddress()+"||");
				}
			}
			if(n==2) {
				System.out.println("Them ma nhan vien:");
				String ma=GetStr();
				System.out.println("Them ten nhan vien: ");
				String ten=GetStr();
				System.out.println("Them sdt nhan vien:");
				String sdt=GetStr();
				System.out.println("Them Email nhan vien:");
				String email=GetStr();
				System.out.println("Them dia chi nhan vien: ");
				String diachi=GetStr();
				EmployeeModel employee = new EmployeeModel(ma, ten, sdt, email, diachi);
				ResultModel result = employeeSQL.AddEmployee(employee);
				System.out.println(result.getMessage());
			}
			if(n==3) {
				System.out.println("Nhap ma nhan vien can tim:");
				String ma=GetStr();
				EmployeeModel find = employeeSQL.FindEmployee(ma);
				if(find==null) {
					System.out.println("Khong tim thay nhan vien can tim!");
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
				System.out.println("Nhap ma nhan vien can update:");
				String ma=GetStr();
				EmployeeModel find = employeeSQL.FindEmployee(ma);
				if(find==null) {
					System.out.println("Khong tim thay nhan vien can update");
				}
				else {
					System.out.print(find.getManv()+"||");
					System.out.print(find.getTennv()+"||");
					System.out.print(find.getSdt()+"||");
					System.out.print(find.getEmail()+"||");
					System.out.print(find.getAddress()+"||");
					System.out.println("Nhap ten nhan vien can sua:");
					String ten=GetStr();
					System.out.println("Nhap sdt can sua: ");
					String sdt=GetStr();
					System.out.println("Nhap email can sua: ");
					String email=GetStr();
					System.out.println("Nhap dia chi can sua: ");
					String diachi=GetStr();
					EmployeeModel employeeEdit = new EmployeeModel(ma, ten, sdt, email, diachi);
					ResultModel result = employeeSQL.UpdateEmployee(employeeEdit);
					System.out.println(result.getMessage());
				}
			}
			if(n==5) {
				System.out.println("Nhap ma nhan vien can xoa:");
				String ma=GetStr();
				EmployeeModel find = employeeSQL.FindEmployee(ma);
				if(find==null) {
					System.out.println("Khong tim thay nhan vien can xoa!");
				}
				else {
					ResultModel result = employeeSQL.DeleEmployee(ma);
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
