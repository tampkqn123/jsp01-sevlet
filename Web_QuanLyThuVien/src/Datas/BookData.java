package Datas;

import java.util.ArrayList;

import Models.BookModel;
import Models.ResultModel;

public class BookData {

	public ArrayList<BookModel> GetAllBook(){
		ArrayList<BookModel> books = new ArrayList<BookModel>();
		BookModel book = new BookModel("01", "SGK", "GD", "1");
		books.add(book);
		book = new BookModel("02", "A", "abc", "2");
		books.add(book);
		return books;
	}
	public ResultModel AddBook(ArrayList<BookModel> books, BookModel book)
	{
		for(BookModel item: books) {
			if(item.getMa().equals(book.getMa())) {
				ResultModel result = new ResultModel(false, "cuon sach nay da ton tai");
				return result;
			}
		}
		books.add(book);
		return new ResultModel(true, "them thanh cong");
	}
	public ResultModel DeleBook(ArrayList<BookModel> books, String maSach)
	{
		for(BookModel tim: books) {
			if(tim.getMa().equals(maSach)) {
				int viTri = books.indexOf(tim);
				books.remove(viTri);
				return new ResultModel(true, "xoa thanh cong");
			}
		}
		return new ResultModel(false, "khong tim thay sach can xoa"); 
	}
	public BookModel FindBook (ArrayList<BookModel> books, String maSach)
	{
		for(BookModel find: books) {
			if(find.getMa().equals(maSach)) {
				return find;
			}
		}
		return null;
	}
	public ResultModel Update(ArrayList<BookModel> books, BookModel book)
	{
		for(BookModel update: books) {
			if(update.getMa().equals(book.getMa())) {
				update.setTen(book.getTen());
				update.setTacGia(book.getTacGia());
				update.setLoai(book.getLoai());
				return new ResultModel(true, "cap nhap thanh cong");
			}
		}
		return new ResultModel(false, "cap nhap that bai");
	}
}
