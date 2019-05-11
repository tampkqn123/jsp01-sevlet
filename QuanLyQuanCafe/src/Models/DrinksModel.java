package Models;

public class DrinksModel {
	private int Id;
	private String Name;
	private String Category;
	private int Price;
	public DrinksModel(int id, String name, String category, int price) {
		super();
		Id = id;
		Name = name;
		Category = category;
		Price = price;
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
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
}
