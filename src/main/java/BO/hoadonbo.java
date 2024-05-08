package BO;

import java.util.ArrayList;

import DAO.hoadondao;
import Entity.hoadon;
import Entity.lichsu;

public class hoadonbo {
	hoadondao dao = new hoadondao();
	public int Hoadon(int makh) throws Exception{
		return dao.Hoadon(makh);
	}
	public int MaxHd() throws Exception{
		return dao.MaxHd();
	}
	public int ChiTietHoadon(String masp,long soluongmua, int mahd)  throws Exception{
		return dao.ChiTietHoadon(masp, soluongmua, mahd);
	}
	public ArrayList<hoadon> getHoadon(){
		return dao.getHoadon();
	}
	public ArrayList<lichsu> getChitiet(int mahd){
		return dao.getChitiet(mahd);
	}
	public void CapNhatChiTietHoaDon(int machitiethoadon)  throws Exception{
		dao.CapNhatChiTietHoaDon(machitiethoadon);
	}
	public lichsu KiemTra(int mahd ){
		return dao.KiemTra(mahd);
	}
	public void CapNhaHoaDon(int mahoadon)  throws Exception{
		dao.CapNhaHoaDon(mahoadon);
	}
	public ArrayList<hoadon> Timkiem(String tenkh){
		return dao.Timkiem(tenkh);
	}
	public void XoaHoaDonTren15NgayChuaThanhToan(){
		dao.XoaHoaDonTren15NgayChuaThanhToan();
	}
}
