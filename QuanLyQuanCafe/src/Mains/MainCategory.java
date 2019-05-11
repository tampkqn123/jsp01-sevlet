package Mains;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.EncodingMap;

import Datas.CategoryData;
import Datas.EmployeeData;
import Models.CategoryModel;
import Models.ResultModel;

public class MainCategory {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n=-1;
		CategoryData categoryData=new CategoryData();
		do {
			System.out.println("1. Hiển thị danh mục!");
			System.out.println("2. Tìm kiếm danh mục!");
			System.out.println("3. Thêm danh mục!");
			System.out.println("4. Sửa danh mục!");
			System.out.println("5. Xóa danh mục!");
			System.out.println("6. Trở về Menu chính!");
			n=Integer.valueOf(GetStr());
			if(n==1) {
				ArrayList<CategoryModel> getCategory = categoryData.GetAllCategory();
				for(CategoryModel item:getCategory) {
					System.out.print(item.getId()+"||");
					System.out.println(item.getName());
					System.out.println("----------------------");
				}
			}
			if(n==2) {
				System.out.println("Nhập ID cần tìm kiếm: ");
				int id=Integer.valueOf(GetStr());
				CategoryModel find = categoryData.FindCategory(id);
				if(find==null) {
					System.out.println("Không tìm thấy danh mục cần tìm!");
				}
				else {
					System.out.print(find.getId()+"||");
					System.out.println(find.getName());
					System.out.println("----------------------");
				}
			}
			if(n==3) {
				System.out.println("Nhập ID: ");
				int id=Integer.valueOf(GetStr());
				System.out.println("Nhập tên danh mục: ");
				String name=GetStr();
				CategoryModel category = new CategoryModel(id, name);
				ResultModel result = categoryData.AddCategory(category);
				System.out.println(result.getMessage());
			}
			if(n==4) {
				System.out.println("Nhập ID cần sửa: ");
				int id=Integer.valueOf(GetStr());
				CategoryModel find = categoryData.FindCategory(id);
				if(find==null) {
					System.out.println("Không tìm thấy danh mục cần sửa!");
				}
				else {
					System.out.print(find.getId()+"||");
					System.out.println(find.getName());
					System.out.println("----------------------");
					System.out.println("Nhập tên: ");
					String name=GetStr();
					CategoryModel category = new CategoryModel(id, name);
					ResultModel result = categoryData.EditCategory(category);
					System.out.println(result.getMessage());
				}
			}
			if(n==5) {
				System.out.println("Nhập ID cần xóa:");
				int id=Integer.valueOf(GetStr());
				CategoryModel find = categoryData.FindCategory(id);
				if(find==null) {
					System.out.println("Không tìm thấy danh mục cần xóa!");
				}
				else {
					System.out.print(find.getId()+"||");
					System.out.println(find.getName());
					System.out.println("----------------------");
					ResultModel result = categoryData.DeleteCategory(id);
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
