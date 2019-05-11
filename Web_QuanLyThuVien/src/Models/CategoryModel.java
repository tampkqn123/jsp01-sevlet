package Models;

public class CategoryModel {
	private String Ma;
	private String Ten;
	private String Mota;
	public CategoryModel(String ma, String ten, String mota) {
		super();
		Ma = ma;
		Ten = ten;
		Mota = mota;
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
	public String getMota() {
		return Mota;
	}
	public void setMota(String mota) {
		Mota = mota;
	}
	
}
