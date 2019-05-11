import java.awt.print.Book;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import Datas.BookSQLData;
import Models.BookModel;
import Models.ResultModel;

public class TestBookSQL {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BookSQLData bookSql = new BookSQLData();
		int n = -1;
		do {
		System.out.println("\n1.Hien thi sach");
		System.out.println("2.Them sach");
		System.out.println("3.Tim Sach");
		System.out.println("4.Cap nhap sach");
		System.out.println("5.Xoa sach");
		System.out.println("6.Tro lai menu chinh");
		n=Integer.valueOf(GetStr());
		if(n==1) {
			ArrayList<BookModel> booksGet = bookSql.GetAllBook(); 
			for(BookModel item: booksGet) {
				System.out.print(item.getMa()+"||");
				System.out.print(item.getTen()+"||");
				System.out.print(item.getTacGia()+"||");
				System.out.println(item.getLoai());
			}
			
		}
		if(n==2) {
			System.out.println("Them ma sach: ");
			String ma=GetStr();
			System.out.println("Them ten sach: ");
			String ten=GetStr();
			System.out.println("Them tac gia: ");
			String tacgia=GetStr();
			System.out.println("Them loai sach: ");
			String loai=GetStr();
			BookModel books = new BookModel(ma, ten, tacgia, loai);
			ResultModel result = bookSql.AddBook(books);
			System.out.println(result.getMessage());
		}
		if(n==3) {
			System.out.println("Nhap ma sach can tim: ");
			String ma=GetStr();
			BookModel find = bookSql.FindBook(ma);
			if(find==null) {
				System.out.println("Khong tim thay muc can tim!");
			}
			else {
				System.out.print(find.getMa()+"||");
				System.out.print(find.getTen()+"||");
				System.out.print(find.getTacGia()+"||");
				System.out.println(find.getLoai());
			}
		}
		if(n==4) {
			System.out.println("Nhap ma sach can update: ");
			String ma=GetStr();
			BookModel find = bookSql.FindBook(ma);
			if(find==null) {
				System.out.println("Khong tim thay sach can update!");
			}
			else {
				System.out.println("Nhap ten sach can sua: ");
				String ten=GetStr();
				System.out.println("Nhap tac gia: ");
				String tacgia=GetStr();
				System.out.println("Nhap loai sach: ");
				String loai=GetStr();
				BookModel book = new BookModel(ma, ten, tacgia, loai);
				ResultModel result = bookSql.UpdateBook(book);
				System.out.println(result.getMessage());
			}
		}
		if(n==5) {
			System.out.println("Nhap ma sach can xoa: ");
			String ma=GetStr();
			BookModel find = bookSql.FindBook(ma);
			if(find==null) {
				System.out.println("Khong co sach can xoa!");
			}
			else {
				ResultModel result = bookSql.DeleBook(find);
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
