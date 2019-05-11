package Main;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import Datas.MatHangSqlData;
import Models.MatHang;
import Models.ResultModes;

public class MainMatHang {
	public static void main(String args[]) throws Exception{
		MatHangSqlData mathangSql = new MatHangSqlData();
		int n=-10;
		do {
			System.out.println("\n1.Hien thi mat hang!");
			System.out.println("2.Tim kiem mat hang!");
			System.out.println("3.Them mat hang!");
			System.out.println("4.Update Mat hang!");
			System.out.println("5.Dele Mat hang!");
			n = Integer.valueOf(GetStr());
			if(n==1) {
				ArrayList<MatHang> getMatHang = mathangSql.GetAll();
				for(MatHang item : getMatHang) {
					System.out.print(item.getMa()+"||");
					System.out.print(item.getTen()+"||");
					System.out.println(item.getGia());
				}
			}
			if(n==2) {
				System.out.println("Nhap ma mat hang can tim: ");
				String ma = GetStr();
				MatHang find = mathangSql.FindMatHang(ma);
				if(find==null) {
					System.out.println("Khong tim thay mat hang!");
				}
				else {
					System.out.print(find.getMa()+"||");
					System.out.print(find.getTen()+"||");
					System.out.println(find.getGia());
				}
			}
			if(n==3) {
				System.out.println("Nhap ma mat hang can them: ");
				String ma = GetStr();
				System.out.println("Nhap ten mat hang can them: ");
				String ten = GetStr();
				System.out.println("Nhap gia mat hang can them: ");
				String gia = GetStr();
				MatHang matHang = new MatHang(ma, ten, gia);
				ResultModes result = mathangSql.AddMatHang(matHang);
				System.out.println(result.getMessage());
			}
			if(n==4) {
				System.out.println("Nhap ma mat hang can update: ");
				String ma = GetStr();
				MatHang find = mathangSql.FindMatHang(ma);
				if(find==null) {
					System.out.println("Khong tim thay mat hang can update!");
				}
				else {
					System.out.print(find.getMa()+"||");
					System.out.print(find.getTen()+"||");
					System.out.println(find.getGia());
					System.out.println("Nhap ten muon sua: ");
					String ten = GetStr();
					System.out.println("Nhap gia muon sua: ");
					String gia = GetStr();
					MatHang matHang = new MatHang(ma, ten, gia);
					ResultModes result = mathangSql.UpdateMatHang(matHang);
					System.out.println(result.getMessage());
				}
			}
			if(n==5) {
				System.out.println("Nhap ma mat hang can delete");
				String ma = GetStr();
				MatHang find = mathangSql.FindMatHang(ma);
				if(find==null) {
					System.out.println("Khong tim thay mat hang can delete!");
				}
				else {
					System.out.print(find.getMa()+"||");
					System.out.print(find.getTen()+"||");
					System.out.println(find.getGia());
					ResultModes result = mathangSql.DeleMatHang(find);
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
