package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Entity.DanhMuc;
import Entity.hoadon;


public class danhmucdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	public ArrayList<DanhMuc> getDanhmuc(){
		DataConnect da = new DataConnect();
		ArrayList<DanhMuc> ds = new ArrayList<DanhMuc>();
		try {
			ResultSet dssp = da.getResult("SELECT * FROM tbl_danhmuc");
			while(dssp.next()) {
				DanhMuc sanpham = new DanhMuc();
				sanpham.setId(dssp.getInt("id_danhmuc"));
				sanpham.setTendanhmuc(dssp.getString("tendanhmuc"));
				sanpham.setThutu(dssp.getInt("thutu"));
				ds.add(sanpham);
			}
			dssp.close();
			return ds	;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	public ArrayList<DanhMuc> Timkiem(String ten){
		ArrayList<DanhMuc> ds = new ArrayList<DanhMuc>();
		String query = "Select * FROM tbl_danhmuc where tendanhmuc like ?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%"+ten+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				DanhMuc sanpham = new DanhMuc();
				sanpham.setId(rs.getInt("id_danhmuc"));
				sanpham.setTendanhmuc(rs.getString("tendanhmuc"));
				sanpham.setThutu(rs.getInt("thutu"));
				ds.add(sanpham);
			}
			rs.close();
			return ds	;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public void XoaLoai(int maloai){

		String query ="DELETE FROM tbl_danhmuc WHERE id_danhmuc=?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,maloai);
			ps.executeUpdate();
			
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public int ThemDanhMuc(int id , String ten) throws Exception{

		String query ="INSERT INTO tbl_danhmuc (id_danhmuc,tendanhmuc,thutu) VALUES(?,?,?) ";
	
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, ten);
			ps.setInt(3, 1);
			ps.setBoolean(3,false);
			int kq=ps.executeUpdate();
			
			conn.close();
			ps.close();
	
			return kq;

	}
	public DanhMuc LaydanhMuc(int id){
		String query = "Select * FROM tbl_danhmuc where id_danhmuc=?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next()) {
				
				DanhMuc sanpham = new DanhMuc();
				sanpham.setId(rs.getInt("id_danhmuc"));
				sanpham.setTendanhmuc(rs.getString("tendanhmuc"));
				sanpham.setThutu(rs.getInt("thutu"));
				return sanpham;
				
			}
			rs.close();
	
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public void SuaDanhMuc(int id,String tendanhmuc){

		String query ="UPDATE tbl_danhmuc SET tendanhmuc =? WHERE id_danhmuc=?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, tendanhmuc);
			ps.setInt(2, id);
			ps.executeUpdate();
			
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
