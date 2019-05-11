import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import Datas.CategoryData;
import Models.CategoryModel;
import Models.ResultModel;

public class TestCotegory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = -1;
		ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
		CategoryData categoryData = new CategoryData();
		do {
			System.out.println("\n1. Hien thi danh sach danh muc!");
			System.out.println("2. Them danh muc!");
			System.out.println("3. Cap nhap danh muc!");
			System.out.println("4. Xoa danh muc!");
			System.out.println("5. Tim kiem danh muc!");
		n = Integer.valueOf(GetStr());
		if(n==1) {
			for(CategoryModel item: categories) {
				System.out.print(item.getMa()+"||");
				System.out.print(item.getTen()+"||");
				System.out.print(item.getMota()+"||");
			}
		}
		if(n==2) {
			System.out.print("Nhap ma: ");
			String ma=GetStr();
			System.out.print("Nhap ten: ");
			String ten=GetStr();
			System.out.print("Nhap mo ta: ");
			String mota=GetStr();
			CategoryModel categori = new CategoryModel(ma, ten, mota);
			ResultModel result = categoryData.AddCategory(categories, categori);
			System.out.println(result.getMessage());
		
		}
		if(n==3) {
			System.out.print("Nhap ma can sua: ");
			String ma=GetStr();
			CategoryModel category1 = categoryData.FindCategory(categories, ma);
			if(category1==null) {
				System.out.println("Khong tim thay danh muc nay!");
			}
			else {
				System.out.print(category1.getMa()+"||");
				System.out.print(category1.getTen()+"||");
				System.out.print(category1.getMota()+"||");
				System.out.print("Nhap ten can sua: ");
				String ten1=GetStr();
				System.out.print("Nhap mo ta can sua: ");
				String mota1=GetStr();
				CategoryModel category2 = new CategoryModel(ma, ten1, mota1);
				ResultModel result = categoryData.Update(categories, category2);
				System.out.println(result.getMessage());
			}
		}
		if(n==4) {
			System.out.println("Nhap ma danh muc can xoa: ");
			String madm=GetStr();
			ResultModel result = categoryData.DeleCategory(categories, madm);
			System.out.println(result.getMessage());
		}
		if(n==5) {
			System.out.print("Nhap ma danh muc can tim: ");
			String ma=GetStr();
			CategoryModel category1 = categoryData.FindCategory(categories, ma);
			if(category1 == null) {
				System.out.println("Khong tim thay danh muc nay!");
			}
			else {
				System.out.print(category1.getMa()+"||");
				System.out.print(category1.getTen()+"||");
				System.out.print(category1.getMota()+"||");
			}
		}
		}while(n!=0);

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
