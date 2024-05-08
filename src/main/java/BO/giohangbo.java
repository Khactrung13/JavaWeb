package BO;

import java.util.ArrayList;

import Entity.GioHang;


public class giohangbo {
	public ArrayList<GioHang> ds = new ArrayList<GioHang>();

	public void Them(String masp, String tensp, String hinhanh,double gia, int soluongmua) {
		for (GioHang h: ds) 
			if(h.getMasanpham().equals(masp)) {
				h.setSoluongmua(h.getSoluongmua()+soluongmua);
				return;
			}
		GioHang h= new GioHang(masp,tensp,hinhanh,gia,soluongmua);
			ds.add(h);//them hang vao gio
		}

		
	
	//xoa hang ra khoi danh sach
	public void XoaHang(String masp) {
		for (GioHang h : ds) {
			if(h.getMasanpham().equals(masp)) {
				ds.remove(h);
				return;
			}
		}
	}
	 public boolean delete(String masp) {
		 GioHang hang = this.ds.stream()
	                .filter(document -> document.getMasanpham().equals(masp))
	                .findFirst().orElse(null);
	        if (hang == null) {
	            return false;
	        }
	        this.ds.remove(hang);
	        return true;
	    }

	//tinh tong tien
	public double Tongtien() {
		int n = ds.size();
		double s = 0;
		for (int i = 0; i < n; i++) {
			s = s + ds.get(i).getThanhtien();
		}
		return s;
	}
}
