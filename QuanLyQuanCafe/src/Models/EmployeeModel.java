package Models;

public class EmployeeModel {
	private int Id;
	private String Name;
	private String Regency;
	private int Phone;
	private String Mail;
	private String Address;
	public EmployeeModel(int id, String name, String regency, int phone, String mail, String address) {
		super();
		Id = id;
		Name = name;
		Regency = regency;
		Phone = phone;
		Mail = mail;
		Address = address;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRegency() {
		return Regency;
	}
	public void setRegency(String regency) {
		Regency = regency;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
