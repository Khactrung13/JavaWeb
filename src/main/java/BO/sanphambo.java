package BO;

import java.util.ArrayList;

import DAO.sanphamdao;
import Entity.SanPham;

public class sanphambo {

	sanphamdao dao = new sanphamdao();
	public ArrayList<SanPham> getListSanPham(){
		return dao.getListSanPham();
	}
	public SanPham getChitietsanpham1(String id){
	     return dao.getChitietsanpham1(id);
	}
	public ArrayList<SanPham> Timkiem(int id){
		return dao.Timkiem(id);
	}
	public ArrayList<SanPham> SearchByid(int id,int i){
		return dao.SearchByid(id, i);
	}
	public ArrayList<SanPham> SearchByKey(String key,int i){
		return dao.Search(key,i);
	}
	public ArrayList<SanPham> SearchByKey(String key){
		return dao.Search(key);
	}
	public void XoaSanPhamByDanhMuc(int maloai){
		dao.XoaSanPhamByDanhMuc(maloai);
	}
	public void XoaSanPham(int ma){
		dao.XoaSanPham(ma);
	}
	public int ThemSanPham(String ten,String masp,double gia,int soluong,String hinhanh,String tomtat, String noidung,int iddanhmuc) throws Exception{
		return dao.ThemSanPham(ten, masp, gia, soluong, hinhanh, tomtat, noidung, iddanhmuc);
	}
	public SanPham LaySanPham(int id){
		return dao.LaySanPham(id);
	}
	public int SuaSanPham(String ten,String masp,double gia,int soluong,String hinhanh,String tomtat, String noidung,int iddanhmuc,int id) throws Exception{
		return dao.SuaSanPham(ten, masp, gia, soluong, hinhanh, tomtat, noidung, iddanhmuc, id);
	}
	public int DemSoLuongSP() {
		return dao.DemSoLuongSP();
	}
	public ArrayList<SanPham> getListSanPham1(int i){
		return dao.getListSanPham(i);
	}
	public int DemSoLuongSPbykey(String key) {
		return dao.DemSoLuongSPbykey(key);
	}
	public int DemSoLuongSPbyid(int id) {
		return dao.DemSoLuongSPbyid(id);
	}
}
