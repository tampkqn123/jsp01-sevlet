package Models;

public class MatHang {
	private String ma;
	private String ten;
	private String gia;
	public MatHang(String ma, String ten, String gia) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.gia = gia;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	

}
