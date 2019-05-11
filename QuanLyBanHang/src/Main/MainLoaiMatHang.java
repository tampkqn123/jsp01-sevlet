package Main;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import Datas.LoaiMatHangSqlData;
import Models.EmployeeModel;
import Models.LoaiMatHangModel;
import Models.ResultModes;

public class MainLoaiMatHang {

	public static void main(String[] args) throws Exception{
		LoaiMatHangSqlData loaimathangSql = new LoaiMatHangSqlData();
		int n=-10;
		do {
			System.out.println("\n1. Hien thi cac loai mat hang!");
			System.out.println("2. Tim kiem");
			System.out.println("3. Add mat hang");
			System.out.println("4. Update Mat hang");
			System.out.println("5. Delete");
			System.out.println("6. Tro ve menu chinh!");
			n = Integer.valueOf(GetStr());
			if(n==1) {
				ArrayList<LoaiMatHangModel> loaiMHs = loaimathangSql.GetAllLoaiMH();
				for(LoaiMatHangModel item: loaiMHs) {
					System.out.print(item.getMa()+"||");
					System.out.print(item.getTen()+"||");
					System.out.println(item.getLoai());
				}
			}
			if(n==2) {
				System.out.println("Nhap ma loai mat hang can tim kiem: ");
				String ma= GetStr();
				LoaiMatHangModel find = loaimathangSql.FindLoaiMH(ma);
				if(find==null) {
					System.out.println("Khong tim thay loai mat hang nay!");
				}
				else {
					System.out.print(find.getMa()+"||");
					System.out.print(find.getTen()+"||");
					System.out.println(find.getLoai());
				}
			}
			if(n==3) {
				System.out.println("Nhap ma:");
				String ma=GetStr();
				System.out.println("Nhap ten:");
				String ten=GetStr();
				System.out.println("Nhap loai mat hang(nam/nu): ");
				String loai=GetStr();
				LoaiMatHangModel loaiMH = new LoaiMatHangModel(ma, ten, loai);
				ResultModes result = loaimathangSql.AddLoaiMH(loaiMH);
				System.out.println(result.getMessage());
			}
			if(n==4) {
				System.out.println("Nhap ma loai mat hang can edit: ");
				String ma=GetStr();
				LoaiMatHangModel find = loaimathangSql.FindLoaiMH(ma);
				if(find==null) {
					System.out.println("Khong tim thay loai mat hang can sua!");
				}
				else {
					System.out.print(find.getMa()+"||");
					System.out.print(find.getTen()+"||");
					System.out.println(find.getLoai());
					System.out.println("Nhap ten: ");
					String ten=GetStr();
					System.out.println("Nhap loai(nam/nu): ");
					String loai=GetStr();
					LoaiMatHangModel loaiMH = new LoaiMatHangModel(ma, ten, loai);
					ResultModes result = loaimathangSql.UpdateLoaiMH(loaiMH);
					System.out.println(result.getMessage());
				}
			}
			if(n==5) {
				System.out.println("Nhap ma mat hang can delete: ");
				String ma=GetStr();
				LoaiMatHangModel find = loaimathangSql.FindLoaiMH(ma);
				if(find==null) {
					System.out.println("Khong co mat hang can delete");
				}
				else {
					System.out.print(find.getMa()+"||");
					System.out.print(find.getTen()+"||");
					System.out.println(find.getLoai());
					ResultModes result = loaimathangSql.DeleLoaiMH(find);
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
