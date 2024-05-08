package BO;

import java.util.ArrayList;

import DAO.danhmucdao;
import Entity.DanhMuc;

public class danhmucbo {
	danhmucdao dao = new danhmucdao();
	public ArrayList<DanhMuc> getDanhmuc(){
	    return dao.getDanhmuc();
	}
	public ArrayList<DanhMuc> Timkiem(String ten){
		return dao.Timkiem(ten);
	}
	public void XoaLoai(int maloai){
		dao.XoaLoai(maloai);
	}
	public int ThemDanhMuc(int id , String ten) throws Exception{
		return dao.ThemDanhMuc(id, ten);
	}
	public DanhMuc LaydanhMuc(int id){
		return dao.LaydanhMuc(id);
	}
	public void SuaDanhMuc(int id,String tendanhmuc){
		dao.SuaDanhMuc(id, tendanhmuc);
	}
}
