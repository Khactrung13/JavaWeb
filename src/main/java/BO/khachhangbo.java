package BO;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

import DAO.khachhangdao;
import Entity.KhachHang;

public class khachhangbo {
	khachhangdao dao  = new khachhangdao();
	
	public KhachHang KiemTraTaiKhoan(String user){
		return dao.KiemTraTaiKhoan(user);
	}
	
	public KhachHang DangNhap1(String id,String pass){
		return dao.DangNhap1(id, pass);
	}
	public void Dangky(String ten , String email ,String diachi ,String sdt, String mk){
		dao.Dangky(ten, email, diachi, mk, sdt);
	}
	public void Doimatkhau(int makh,String matkhaucu , String matkhaumoi){
		dao.Doimatkhau(makh, matkhaucu, matkhaumoi);
	}
	public KhachHang KiemTraTaiKhoan1(String user,String pass){
		return dao.KiemTraTaiKhoan1(user, pass);
	}
	
	public static String toSha1(String str) {
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
