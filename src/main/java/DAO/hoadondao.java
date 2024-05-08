package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Entity.KhachHang;
import Entity.SanPham;
import Entity.hoadon;
import Entity.lichsu;
import DAO.DataConnect;


public class hoadondao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	public int Hoadon(int makh) throws Exception{

		String query ="INSERT INTO tbl_hoadon (id_dangky,ngaymua,damua) VALUES(?,?,?) ";
	
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, makh);
			Date n1 = new Date();
			SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
			String tam = dd.format(n1);
			Date n2 =dd.parse(tam);//doi chuoi ra ngay util
			ps.setDate(2,new java.sql.Date(n2.getTime()));
			//doi ngay util sang ngay sql va dua vao sql
			ps.setBoolean(3,false);
			int kq=ps.executeUpdate();
			
			conn.close();
			ps.close();
	
			return kq;

	}
	public int MaxHd() throws Exception{
		String query ="SELECT MAX(mahoadon) from tbl_hoadon";
		new DataConnect();
		conn = DataConnect.getConnect();
		ps = conn.prepareStatement(query);
		rs=ps.executeQuery();
		int max = 0;
		while(rs.next()) {
			max = rs.getInt(1);
		}
		conn.close();
		ps.close();

		return max;
	
	}
	public int ChiTietHoadon(String masp,long soluongmua, int mahd)  throws Exception{

		String query ="INSERT INTO tbl_chitiethoadon (masp,soluongmua,mahoadon,damua) VALUES(?,?,?,?) ";
	
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, masp);
			ps.setLong(2, soluongmua);
			ps.setInt(3,mahd);
			ps.setBoolean(4,false);
			
			int ketqua=ps.executeUpdate();

			conn.close();
			ps.close();
			return ketqua;
	

	}

	public ArrayList<hoadon> getHoadon(){
		ArrayList<hoadon> ds = new ArrayList<hoadon>();
		String query = "Select * FROM qlhoadon";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				hoadon hd = new hoadon();
				hd.setMahd(rs.getInt("mahoadon"));;
				hd.setIdkh(rs.getInt("id_dangky"));
				hd.setTenkh(rs.getString("tenkhachhang"));
				hd.setDienthoai(rs.getString("dienthoai"));
				hd.setDiachi(rs.getString("diachi"));
				hd.setNgaymua(rs.getDate("ngaymua"));
				hd.setDamua(rs.getInt("damua"));
				ds.add(hd);
			}
			rs.close();
			return ds	;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public ArrayList<lichsu> getChitiet(int mahd){
		ArrayList<lichsu> ds = new ArrayList<lichsu>();
		String query = "Select * from lichsu where mahoadon=?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,mahd);
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
	public void CapNhatChiTietHoaDon(int machitiethoadon)  throws Exception{

		String query ="UPDATE lichsu SET damua=1 where MaChiTietHD=?";
	
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,machitiethoadon);
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	

	}
	public lichsu KiemTra(int mahd){
		String query= "Select * from lichsu where damua=? AND mahoadon=?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,0);
			ps.setInt(2,mahd);
			rs=ps.executeQuery();
			while(rs.next()) {
				return new lichsu(rs.getInt(1),
						rs.getInt(12)) ;

			}
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public void CapNhaHoaDon(int mahoadon)  throws Exception{

		String query ="UPDATE qlhoadon SET damua=1 where mahoadon=?";
	
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1,mahoadon);
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	

	}
	public ArrayList<hoadon> Timkiem(String tenkh){
		ArrayList<hoadon> ds = new ArrayList<hoadon>();
		String query = "Select * FROM qlhoadon where tenkhachhang like ?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%"+tenkh+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				hoadon hd = new hoadon();
				hd.setMahd(rs.getInt("mahoadon"));;
				hd.setIdkh(rs.getInt("id_dangky"));
				hd.setTenkh(rs.getString("tenkhachhang"));
				hd.setDienthoai(rs.getString("dienthoai"));
				hd.setDiachi(rs.getString("diachi"));
				hd.setNgaymua(rs.getDate("ngaymua"));
				hd.setDamua(rs.getInt("damua"));
				ds.add(hd);
			}
			rs.close();
			return ds	;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public void XoaHoaDonTren15NgayChuaThanhToan(){

		String query ="DELETE FROM tbl_hoadon WHERE TIMESTAMPDIFF(DAY,ngaymua,CURDATE())>=15 AND damua=0;";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
