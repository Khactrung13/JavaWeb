package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.lichsu;


public class lichsudao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	public ArrayList<lichsu> getLichSu(int makh){
		ArrayList<lichsu> ds = new ArrayList<lichsu>();
		String query = "Select * from lichsu where id_dangky=? ORDER by mahoadon DESC";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,makh);
			rs=ps.executeQuery();
			while(rs.next()) {
				lichsu s= new lichsu();
				s.setMahd(rs.getInt("mahoadon"));
				s.setIdkh(rs.getInt("id_dangky"));
				s.setTenkh(rs.getString("tenkhachhang"));
				s.setMasp(rs.getString("masp"));
				s.setTensp(rs.getString("tensanpham"));
				s.setHinhanh(rs.getString("hinhanh"));
				s.setNgaymua(rs.getDate("ngaymua"));
				s.setGiasp(rs.getDouble("giasp"));
				s.setSoluong(rs.getInt("soluongmua"));
				s.setThanhtien(rs.getDouble("thanhtien"));
				s.setMachitiethoadon(rs.getInt("MaChiTietHD"));
				s.setDamua(rs.getInt("damua"));
				ds.add(s);
			}
			rs.close();
			return ds	;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
