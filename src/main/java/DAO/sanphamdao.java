package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.DanhMuc;
import Entity.SanPham;

public class sanphamdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	public ArrayList<SanPham> getListSanPham(){
		DataConnect da = new DataConnect();
		ArrayList<SanPham> ds = new ArrayList<SanPham>();
		try {
			ResultSet dssp = da.getResult("SELECT * FROM tbl_sanpham ORDER BY id_sanpham DESC");
			while(dssp.next()) {
				SanPham sanpham = new SanPham();
				sanpham.setId(dssp.getInt("id_sanpham"));
				sanpham.setTensp(dssp.getString("tensanpham"));
				sanpham.setMa(dssp.getString("masp"));
				sanpham.setGia(dssp.getDouble("giasp"));
				sanpham.setSoluong(dssp.getInt("soluong"));
				sanpham.setHinhanh(dssp.getString("hinhanh"));
				sanpham.setNoidung(dssp.getString("noidung"));
				sanpham.setTomtat(dssp.getString("tomtat"));
				sanpham.setTinhtrang(dssp.getInt("tinhtrang"));
				sanpham.setIddanhmuc(dssp.getInt("id_danhmuc"));
				ds.add(sanpham);
			}
			dssp.close();
			return ds	;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	public SanPham getChitietsanpham1(String id){
		DataConnect da = new DataConnect();
		//ArrayList<SanPham> ds = new ArrayList<SanPham>();
		try {
			ResultSet dssp = da.getResult("SELECT * FROM tbl_sanpham where id_sanpham="+id);
			while(dssp.next()) {
				SanPham sanpham = new SanPham();
				
				sanpham.setId(dssp.getInt("id_sanpham"));
				sanpham.setTensp(dssp.getString("tensanpham"));
				sanpham.setMa(dssp.getString("masp"));
				sanpham.setGia(dssp.getDouble("giasp"));
				sanpham.setSoluong(dssp.getInt("soluong"));
				sanpham.setHinhanh(dssp.getString("hinhanh"));
				sanpham.setNoidung(dssp.getString("noidung"));
				sanpham.setTomtat(dssp.getString("tomtat"));
				sanpham.setTinhtrang(dssp.getInt("tinhtrang"));
				sanpham.setIddanhmuc(dssp.getInt("id_danhmuc"));
				return sanpham	;
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	public ArrayList<SanPham> Timkiem(int id){
		DataConnect da = new DataConnect();
		ArrayList<SanPham> ds = new ArrayList<SanPham>();
		try {
			ResultSet dssp = da.getResult("SELECT * FROM tbl_sanpham where id_danhmuc="+id);
			while(dssp.next()) {
				SanPham sanpham = new SanPham();
				sanpham.setId(dssp.getInt("id_sanpham"));
				sanpham.setTensp(dssp.getString("tensanpham"));
				sanpham.setMa(dssp.getString("masp"));
				sanpham.setGia(dssp.getDouble("giasp"));
				sanpham.setSoluong(dssp.getInt("soluong"));
				sanpham.setHinhanh(dssp.getString("hinhanh"));
				sanpham.setNoidung(dssp.getString("noidung"));
				sanpham.setTomtat(dssp.getString("tomtat"));
				sanpham.setTinhtrang(dssp.getInt("tinhtrang"));
				sanpham.setIddanhmuc(dssp.getInt("id_danhmuc"));
				ds.add(sanpham);
			}
			dssp.close();
			return ds	;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	public ArrayList<SanPham> SearchByid(int id,int i){
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		String query= "SELECT * FROM tbl_sanpham where id_danhmuc=? ORDER BY id_sanpham DESC LIMIT ?,6;";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			ps.setInt(2,i);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new SanPham(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10)));
				
				//return list;
			}
			rs.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	public ArrayList<SanPham> Search(String key,int i){
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		String query= "Select * from tbl_sanpham where tensanpham like ? OR tomtat like ? OR noidung like ? ORDER BY id_sanpham DESC LIMIT ?,6;";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%"+key+"%");
			ps.setString(2,"%"+key+"%");
			ps.setString(3,"%"+key+"%");
			ps.setInt(4,i);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new SanPham(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10)));
				
				//return list;
			}
			rs.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	public ArrayList<SanPham> Search(String key){
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		String query= "Select * from tbl_sanpham where tensanpham like ? OR tomtat like ? OR noidung like ? ";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%"+key+"%");
			ps.setString(2,"%"+key+"%");
			ps.setString(3,"%"+key+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new SanPham(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10)));
				
				//return list;
			}
			rs.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	public void XoaSanPhamByDanhMuc(int maloai){

		String query ="DELETE FROM tbl_sanpham WHERE id_danhmuc=?";
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
	public void XoaSanPham(int ma){

		String query ="DELETE FROM tbl_sanpham WHERE id_sanpham=?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,ma);
			ps.executeUpdate();
			
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public int ThemSanPham(String ten,String masp,double gia,int soluong,String hinhanh,String tomtat, String noidung,int iddanhmuc) throws Exception{

		String query ="INSERT INTO tbl_sanpham(tensanpham,masp,giasp,soluong,hinhanh,tomtat,noidung,tinhtrang,id_danhmuc) "
				+ "VALUES(?,?,?,?,?,?,?,?,?) ";
	
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, ten);
			ps.setString(2, masp);
			ps.setDouble(3, gia);
			ps.setInt(4, soluong);
			ps.setString(5, hinhanh);
			ps.setString(6, tomtat);
			ps.setString(7, noidung);
			ps.setInt(8,1);
			ps.setInt(9,iddanhmuc);
			int kq=ps.executeUpdate();
			
			conn.close();
			ps.close();
	
			return kq;

	}
	public SanPham LaySanPham(int id){
		String query = "Select * FROM tbl_sanpham where id_sanpham=?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next()) {
				SanPham sanpham = new SanPham();
				sanpham.setId(rs.getInt("id_sanpham"));
				sanpham.setTensp(rs.getString("tensanpham"));
				sanpham.setMa(rs.getString("masp"));
				sanpham.setGia(rs.getDouble("giasp"));
				sanpham.setSoluong(rs.getInt("soluong"));
				sanpham.setHinhanh(rs.getString("hinhanh"));
				sanpham.setNoidung(rs.getString("noidung"));
				sanpham.setTomtat(rs.getString("tomtat"));
				sanpham.setTinhtrang(rs.getInt("tinhtrang"));
				sanpham.setIddanhmuc(rs.getInt("id_danhmuc"));
				return sanpham;
				
			}
			rs.close();
	
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public int SuaSanPham(String ten,String masp,double gia,int soluong,String hinhanh,String tomtat, String noidung,int iddanhmuc,int id) throws Exception{

		String query =" UPDATE tbl_sanpham  SET tensanpham=? ,masp=?,giasp=?,soluong=?,hinhanh=?,tomtat=?,noidung=?,tinhtrang=?,id_danhmuc=? WHERE id_sanpham=?";
	
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, ten);
			ps.setString(2, masp);
			ps.setDouble(3, gia);
			ps.setInt(4, soluong);
			ps.setString(5, hinhanh);
			ps.setString(6, tomtat);
			ps.setString(7, noidung);
			ps.setInt(8,1);
			ps.setInt(9,iddanhmuc);
			ps.setInt(10,id);
			int kq=ps.executeUpdate();
			
			conn.close();
			ps.close();
	
			return kq;

	}
	public int DemSoLuongSP() {
		String query="SELECT COUNT(*) FROM tbl_sanpham";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public ArrayList<SanPham> getListSanPham(int i){
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		String query= "SELECT * FROM tbl_sanpham ORDER BY id_sanpham DESC LIMIT ?,6;";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,i);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new SanPham(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10)));
				
				//return list;
			}
			rs.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	public int DemSoLuongSPbyid(int id) {
		String query="SELECT COUNT(*) FROM tbl_sanpham WHERE id_danhmuc=?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public int DemSoLuongSPbykey(String key) {
		String query="SELECT COUNT(*) FROM tbl_sanpham where tensanpham like ? OR tomtat like ? OR noidung like ?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%"+key+"%");
			ps.setString(2,"%"+key+"%");
			ps.setString(3,"%"+key+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
}
