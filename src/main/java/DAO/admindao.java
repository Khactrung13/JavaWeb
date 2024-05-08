package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Entity.Admin;


public class admindao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	public Admin DangNhap1(String username,String pass){
		String query= "Select * from tbl_admin where username like BINARY ? AND password like BINARY ? ";
		try {
			new DataConnect();
			conn = DataConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,pass);
			rs=ps.executeQuery();
			while(rs.next()) {
				return new Admin(rs.getString(2),
				rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
}
