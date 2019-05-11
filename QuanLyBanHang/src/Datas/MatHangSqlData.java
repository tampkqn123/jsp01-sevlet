package Datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.MatHang;
import Models.ResultModes;

public class MatHangSqlData {
	public ArrayList<MatHang> GetAll() throws Exception
	{
	ArrayList<MatHang> matHangs = new ArrayList<MatHang>();
	SqlConnectionData connectData = new SqlConnectionData();
	String sql="select * from mathang";
	PreparedStatement statement = connectData.connect.prepareStatement(sql);
	ResultSet result = statement.executeQuery();
	while(result.next()) {
		String ma = result.getString("ma");
		String ten = result.getString("ten");
		String gia = result.getString("gia");
		MatHang maHang = new MatHang(ma, ten, gia);
		matHangs.add(maHang);
	}
	result.close();
	connectData.connect.close();
	return matHangs;
	}
	public MatHang FindMatHang(String ma) throws Exception
	{
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="select * from mathang where ma=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setString(1, ma);
		ResultSet result = statement.executeQuery();
		MatHang matHang = null;
		if(result.next())
		{
			String ma1 = result.getString("ma");
			String ten = result.getString("ten");
			String gia = result.getString("gia");
			matHang = new MatHang(ma1, ten, gia);
		}
		result.close();
		connectData.connect.close();
		return matHang;
	}
	public ResultModes AddMatHang(MatHang addmathang) throws Exception
	{
		MatHang check = FindMatHang(addmathang.getMa());
		if(check!=null) {
			return new ResultModes(false, "Mat hang nay da ton tai!");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="insert into mathang(ma, ten, gia) values(?, ?, ?)";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, addmathang.getMa());
			statement.setString(2, addmathang.getTen());
			statement.setString(3, addmathang.getGia());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModes(false, "Them that bai");
			}
			else {
				return new ResultModes(true, "Them thanh cong");
			}
		}
	}
	public ResultModes UpdateMatHang(MatHang update) throws Exception
	{
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="update mathang set ten=?, gia=? where ma=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setString(1, update.getTen());
		statement.setString(2, update.getGia());
		statement.setString(3, update.getMa());
		int i = statement.executeUpdate();
		connectData.connect.close();
		if(i==0) {
			return new ResultModes(false, "Update that bai");
		}
		else {
			return new ResultModes(true, "Update thanh cong");
		}
	}
	public ResultModes DeleMatHang(MatHang dele) throws Exception
	{
		MatHang check = FindMatHang(dele.getMa());
		if(check==null) {
			return new ResultModes(false, "Khong tim thay mat hang can xoa");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="delete from mathang where ma=?";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, dele.getMa());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModes(false, "Delete that bai");
			}
			else {
				return new ResultModes(true, "Delete thanh cong");
			}
		}
	}
}
