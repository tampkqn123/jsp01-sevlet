package Models;

public class BookModel {
	private String Ma;
	private String Ten;
	private String TacGia;
	private String Loai;
	
	public BookModel(String ma, String ten, String tacGia, String loai) {
		super();
		Ma = ma;
		Ten = ten;
		TacGia = tacGia;
		Loai = loai;
	}
	public String getMa() {
		return Ma;
	}
	public void setMa(String ma) {
		Ma = ma;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getTacGia() {
		return TacGia;
	}
	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}
	public String getLoai() {
		return Loai;
	}
	public void setLoai(String loai) {
		Loai = loai;
	}
	
}
