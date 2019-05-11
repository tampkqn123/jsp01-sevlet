package Datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.LoaiMatHangModel;
import Models.ResultModes;

public class LoaiMatHangSqlData {
	public ArrayList<LoaiMatHangModel> GetAllLoaiMH() throws Exception
	{
		ArrayList<LoaiMatHangModel> loaiMHs = new ArrayList<LoaiMatHangModel>();
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="select * from loaimathang";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			String ma = result.getString("ma");
			String ten = result.getString("ten");
			String loai = result.getString("loaimh");
			LoaiMatHangModel loaiMH = new LoaiMatHangModel(ma, ten, loai);
			loaiMHs.add(loaiMH);
		}
		result.close();
		connectData.connect.close();
		return loaiMHs;
	}
	public LoaiMatHangModel FindLoaiMH(String ma) throws Exception
	{
		SqlConnectionData connectData = new SqlConnectionData();
		String sql="select * from loaimathang where ma=?";
		PreparedStatement statement = connectData.connect.prepareStatement(sql);
		statement.setString(1, ma);
		ResultSet result = statement.executeQuery();
		LoaiMatHangModel loaimh = null;
		if(result.next()) {
			String ma1 = result.getString("ma");
			String ten = result.getString("ten");
			String loai = result.getString("loaimh");
			loaimh = new LoaiMatHangModel(ma1, ten, loai);
		}
		result.close();
		connectData.connect.close();
		return loaimh;
	}
	public ResultModes AddLoaiMH(LoaiMatHangModel addLoaimh) throws Exception
	{
		LoaiMatHangModel find = FindLoaiMH(addLoaimh.getMa());
		LoaiMatHangModel find1 = FindLoaiMH(addLoaimh.getTen());
		LoaiMatHangModel find2 = FindLoaiMH(addLoaimh.getLoai());
		if(find!=null) {
			return new ResultModes(false, "Loai mat hang can them da ton tai!");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="insert into loaimathang(ma, ten, loaimh) values(?, ?, ?)";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, addLoaimh.getMa());
			statement.setString(2, addLoaimh.getTen());
			statement.setString(3, addLoaimh.getLoai());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModes(false, "Them that bai!");
			}
			else {
				return new ResultModes(true, "Them thanh cong!");
			}
		}
	}
	public ResultModes UpdateLoaiMH(LoaiMatHangModel update) throws Exception
	{
		LoaiMatHangModel find = FindLoaiMH(update.getMa());
		if(find==null) {
			return new ResultModes(false, "Loai mat hang can edit khong ton tai!");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="update loaimathang set ten=?, loaimh=? where ma=?";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, update.getTen());
			statement.setString(2, update.getLoai());
			statement.setString(3, update.getMa());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModes(false, "Edit that bai!");
				}
			else {
				return new ResultModes(true, "Edit thanh cong!");
			}
		}
	}
	public ResultModes DeleLoaiMH(LoaiMatHangModel dele) throws Exception
	{
		LoaiMatHangModel find = FindLoaiMH(dele.getMa());
		if(find==null) {
			return new ResultModes(false, "Khong co loai mat hang can delete!");
		}
		else {
			SqlConnectionData connectData = new SqlConnectionData();
			String sql="delete from loaimathang where ma=?";
			PreparedStatement statement = connectData.connect.prepareStatement(sql);
			statement.setString(1, dele.getMa());
			int i = statement.executeUpdate();
			connectData.connect.close();
			if(i==0) {
				return new ResultModes(false, "Dele that bai!");
			}
			else {
				return new ResultModes(true, "Dele thanh cong!");
			}
		}
	}
}
