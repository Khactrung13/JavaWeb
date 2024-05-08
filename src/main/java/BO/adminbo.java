package BO;

import DAO.admindao;
import Entity.Admin;

public class adminbo {
	admindao dao = new admindao();
	public Admin DangNhap1(String username,String pass){
		return dao.DangNhap1(username, pass);
	}
}
