package Models;

public class EmployeeModel {
	private String Manv;
	private String Tennv;
	private String Sdt;
	private String Email;
	private String Address;
	public EmployeeModel(String manv, String tennv, String sdt, String email, String address) {
		super();
		Manv = manv;
		Tennv = tennv;
		Sdt = sdt;
		Email = email;
		Address = address;
	}
	public String getManv() {
		return Manv;
	}
	public void setManv(String manv) {
		Manv = manv;
	}
	public String getTennv() {
		return Tennv;
	}
	public void setTennv(String tennv) {
		Tennv = tennv;
	}
	public String getSdt() {
		return Sdt;
	}
	public void setSdt(String sdt) {
		Sdt = sdt;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
