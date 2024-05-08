package DAO;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.tomcat.util.codec.binary.Base64;

import Entity.KhachHang;


public class khachhangdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	public KhachHang KiemTraTaiKhoan(String user){
		//ArrayList<SanPham> list = new ArrayList<>();
		String query= "Select * from tbl_dangky where email=?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1,user);
			rs=ps.executeQuery();
			while(rs.next()) {
				return new KhachHang(rs.getString(3),
						rs.getString(5)) ;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public KhachHang DangNhap1(String id,String pass){
		String query= "Select * from tbl_dangky where email like BINARY ? AND matkhau like BINARY ? ";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1,id);
			ps.setString(2,pass);
			rs=ps.executeQuery();
			while(rs.next()) {
				return new KhachHang(rs.getInt(1),rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5),
				rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	public void Dangky(String ten , String email ,String diachi ,String sdt, String mk){

		String query ="INSERT INTO tbl_dangky (tenkhachhang,email,diachi,matkhau,dienthoai) VALUES(?,?,?,?,?) ";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, ten);
			ps.setString(2, email);
			ps.setString(3, diachi);
			ps.setString(4, mk);
			ps.setString(5, sdt);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void Doimatkhau(int makh,String matkhaucu , String matkhaumoi){

		String query ="UPDATE tbl_dangky SET matkhau=? WHERE id_dangky=? AND matkhau=? ";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, matkhaumoi);
			ps.setInt(2, makh);
			ps.setString(3,matkhaucu);
			ps.executeUpdate();
			
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public KhachHang KiemTraTaiKhoan1(String user,String pass){
		String query= "Select * from tbl_dangky where email like BINARY ? AND matkhau like BINARY ?";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1,user);
			ps.setString(2,pass);
			rs=ps.executeQuery();
			while(rs.next()) {
				return new KhachHang(rs.getString(3),
						rs.getString(5)) ;

			}
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public String toSha1(String str) {
		String salt = "wqeasdasdofs@@@fasfdasf,qweqweppasds";
		String result= null;
		
		str = str + salt;
		try {
			byte[] dataBytes= str.getBytes("UTF-8");
			MessageDigest md  = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
