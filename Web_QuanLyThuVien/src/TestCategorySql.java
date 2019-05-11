import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import Datas.CategorySqlData;
import Models.CategoryModel;
import Models.ResultModel;

public class TestCategorySql {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CategorySqlData categorySql = new CategorySqlData();
		int n=-1;
		do {
			System.out.println("\n1.Hien thi danh muc!!");
			System.out.println("2.Them danh muc!!");
			System.out.println("3.Tim danh muc!!");
			System.out.println("4.Cap nhap danh muc!");
			System.out.println("5.Xoa danh muc!");
			System.out.println("6.Tro lai menu chinh");
			n=Integer.valueOf(GetStr());
			if(n==1) {
				ArrayList<CategoryModel> categoryGet = categorySql.GetAllCategory();
				for(CategoryModel item: categoryGet) {
					System.out.print(item.getMa()+"||");
					System.out.print(item.getTen()+"||");
					System.out.println(item.getMota());
				}
			}
			if(n==2) {
				System.out.println("Nhap ma danh muc can them: ");
				String ma=GetStr();
				System.out.println("Nhap ten danh muc can them: ");
				String ten=GetStr();
				System.out.println("Nhap mo ta can them: ");
				String mota=GetStr();
				CategoryModel category1 = new CategoryModel(ma, ten, mota);
				ResultModel result = categorySql.AddCategory(category1);
				System.out.println(result.getMessage());
			}
			if(n==3) {
				System.out.println("Nhap ma danh muc can tim: ");
				String ma=GetStr();
				CategoryModel find = categorySql.FindCategory(ma);
				if(find==null) {
					System.out.println("Khong co danh muc can tim!!");
				}
				else {
					System.out.print(find.getMa()+"||");
					System.out.print(find.getTen()+"||");
					System.out.println(find.getMota());
				}
			}
			if(n==4) {
				System.out.println("Nhap ma danh muc can cap nhap: ");
				String ma=GetStr();
				CategoryModel find = categorySql.FindCategory(ma);
				if(find==null) {
					System.out.println("Khong co danh muc can cap nhap");
				}
				else {
					System.out.println("Nhap ten can cap nhap: ");
					String ten1=GetStr();
					System.out.println("Nhap mo ta can cap nhap: ");
					String mota1=GetStr();
					CategoryModel category1 = new CategoryModel(ma, ten1, mota1);
					ResultModel result = categorySql.Update(category1);
					System.out.println(result.getMessage());
				}
			}
			if(n==5) {
				System.out.println("Nhap ma danh muc can xoa: ");
				String ma=GetStr();
				CategoryModel find = categorySql.FindCategory(ma);
				if(find==null) {
					System.out.println("Khong co danh muc can xoa!!");
				}
				else {
					ResultModel result = categorySql.Dele(ma);
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
