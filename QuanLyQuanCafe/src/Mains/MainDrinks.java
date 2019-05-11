package Mains;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import Datas.DrinksDatas;
import Models.DrinksModel;
import Models.ResultModel;

public class MainDrinks {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int n=-10;
		DrinksDatas drinksData = new DrinksDatas();
		do {
			System.out.println("1. Hiển thị thông tin đồ uống!");
			System.out.println("2. Tìm kiếm thông tin đồ uống!");
			System.out.println("3. Thêm đồ uống!");
			System.out.println("4. Sửa thông tin đồ uống!");
			System.out.println("5. Xóa thông tin đồ uống!");
			System.out.println("6. Trở về Menu chính!");
			n=Integer.valueOf(GetStr());
			if(n==1) {
				ArrayList<DrinksModel> getDrink = drinksData.GetAllDrinks();
				for(DrinksModel item:getDrink) {
					System.out.print(item.getId()+"||");
					System.out.print(item.getName()+"||");
					System.out.print(item.getCategory()+"||");
					System.out.println(item.getPrice());
					System.out.println("--------------------");
				}
			}
			if(n==2) {
				System.out.println("Nhập ID đồ uống cần tìm: ");
				int id=Integer.valueOf(GetStr());
				DrinksModel find = drinksData.FindDrinks(id);
				if(find==null) {
					System.out.println("Không tìm thấy đồ uống cần tìm!");
				}
				else {
					System.out.print(find.getId()+"||");
					System.out.print(find.getName()+"||");
					System.out.print(find.getCategory()+"||");
					System.out.println(find.getPrice());
					System.out.println("--------------------");
				}
			}
			if(n==3) {
				System.out.println("Nhập ID:");
				int id=Integer.valueOf(GetStr());
				System.out.println("Nhập Tên:");
				String name=GetStr();
				System.out.println("Nhập Loại:");
				String category=GetStr();
				System.out.println("Nhập Giá: ");
				int price = Integer.valueOf(GetStr());
				DrinksModel drinks = new DrinksModel(id, name, category, price);
				ResultModel result = drinksData.AddDrinks(drinks);
				System.out.println(result.getMessage());
			}
			if(n==4) {
				System.out.println("Nhập ID đồ uống cần sửa:");
				int id=Integer.valueOf(GetStr());
				DrinksModel find = drinksData.FindDrinks(id);
				if(find==null) {
					System.out.println("Không tìm thấy đồ uống cần sửa!");
				}
				else {
					System.out.print(find.getId()+"||");
					System.out.print(find.getName()+"||");
					System.out.print(find.getCategory()+"||");
					System.out.println(find.getPrice());
					System.out.println("--------------------");
					System.out.println("Nhập Tên muốn sửa: ");
					String name=GetStr();
					System.out.println("Nhập Loại muốn sửa: ");
					String category=GetStr();
					System.out.println("Nhập giá muốn sửa: ");
					int price=Integer.valueOf(GetStr());
					DrinksModel drinks = new DrinksModel(id, name, category, price);
					ResultModel result = drinksData.EditDrinks(drinks);
					System.out.println(result.getMessage());
				}
			}
			if(n==5) {
				System.out.println("Nhập ID đồ uống muốn xóa:");
				int id=Integer.valueOf(GetStr());
				DrinksModel find = drinksData.FindDrinks(id);
				if(find==null) {
					System.out.println("Không tìm thấy đồ uống cần xóa!");
				}
				else {
					System.out.println("Thông tin đồ uống muốn xóa:");
					System.out.print(find.getId()+"||");
					System.out.print(find.getName()+"||");
					System.out.print(find.getCategory()+"||");
					System.out.println(find.getPrice());
					System.out.println("--------------------");
					ResultModel result = drinksData.DeleteDrinks(id);
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
