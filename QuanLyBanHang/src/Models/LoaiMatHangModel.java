package Models;

public class LoaiMatHangModel {
	private String ma;
	private String ten;
	private String loai;
	public LoaiMatHangModel(String ma, String ten, String loai) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.loai = loai;
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
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	
}
