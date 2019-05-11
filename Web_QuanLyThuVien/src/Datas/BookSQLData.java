package Datas;

import java.awt.print.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.BookModel;
import Models.ResultModel;

public class BookSQLData {

	public ArrayList<BookModel> GetAllBook() throws Exception
	{
		ArrayList<BookModel> books = new ArrayList<BookModel>();
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="select * from book";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			String ma=result.getString("ma");
			String ten=result.getString("ten");
			String tacgia=result.getString("tacgia");
			String loai=result.getString("loai");
		BookModel book = new BookModel(ma, ten, tacgia, loai);
		books.add(book);
		}
		result.close();
		connectData.connect.close();
		return books;
	}
	public BookModel FindBook(String ma) throws Exception
	{
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="select * from book where ma=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setString(1, ma);
		ResultSet result = statement.executeQuery();
		BookModel book = null;
		if(result.next()) {
			String ma1=result.getString("ma");
			String ten=result.getString("ten");
			String tacgia=result.getString("tacgia");
			String loai=result.getString("loai");
			book = new BookModel(ma1, ten, tacgia, loai);
		}
		result.close();
		connectData.connect.close();
		return book;
	}
	public ResultModel AddBook(BookModel addBook) throws Exception
	{
		BookModel check = FindBook(addBook.getMa());
		if(check!=null) {
			return new ResultModel(false, "Sach can them da ton tai!");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="insert into book(ma, ten, tacgia, loai) values(?,?,?,?)";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, addBook.getMa());
			statement.setString(2, addBook.getTen());
			statement.setString(3, addBook.getTacGia());
			statement.setString(4, addBook.getLoai());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModel(false, "Them that bai!");
			}
			else {
				return new ResultModel(true, "Them thanh cong!");
			}
		}
	}
	public ResultModel UpdateBook(BookModel book) throws Exception
	{
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="update book set ten=?, tacgia=?, loai=? where ma=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setString(1, book.getTen());
		statement.setString(2, book.getTacGia());
		statement.setString(3, book.getLoai());
		statement.setString(4, book.getMa());
		int i = statement.executeUpdate();
		connectData.connect.close();
		if(i==0) {
			return new ResultModel(false, "Cap nhap that bai!");
		}
		else {
			return new ResultModel(true, "Cap nhap thanh cong!");
		}
	}
	public ResultModel DeleBook(BookModel book) throws Exception
	{
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="delete from book where ma=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setString(1, book.getMa());
		int i = statement.executeUpdate();
		connectData.connect.close();
		if(i==0) {
			return new ResultModel(false, "Xoa that bai!");
		}
		else {
			return new ResultModel(true, "Xoa thanh cong!");
		}
	}
}
