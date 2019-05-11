package Datas;

import java.util.ArrayList;

import Models.CategoryModel;
import Models.ResultModel;

public class CategoryData {

	public ResultModel AddCategory(ArrayList<CategoryModel> categories, CategoryModel categori)
	{
		for(CategoryModel item: categories) {
			if(item.getMa().equals(categori.getMa())) {
				return new ResultModel(false, "Danh muc nay da ton tai!");
			}
		}
		categories.add(categori);
		return new ResultModel(true, "Them thanh cong!");
	}
	public CategoryModel FindCategory (ArrayList<CategoryModel> categories, String ma)
	{
		for(CategoryModel item: categories)
		{
			if(item.getMa().equals(ma)) return item;
		}
		return null;
	}
	public ResultModel DeleCategory (ArrayList<CategoryModel> categories, String ma)
	{
		for(CategoryModel item: categories)
		{
			if(item.getMa().equals(ma)) {
				categories.remove(categories.indexOf(item));
				return new ResultModel(true, "Xoa thanh cong!");
			}
		}
		return new ResultModel(false, "Xoa that bai!");
	}
	public ResultModel Update(ArrayList<CategoryModel> categories, CategoryModel categori)
	{
		for(CategoryModel item: categories)
		{
			if(item.getMa().equals(categori.getMa())) {
				item.setTen(categori.getTen());
				item.setMota(categori.getMota());
				return new ResultModel(true, "Cap nhap thanh cong!");
			}
		}
		return new ResultModel(false, "Cap nhap that bai!");
	}
}
