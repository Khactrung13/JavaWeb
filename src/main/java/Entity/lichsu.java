package Entity;

import java.util.Date;

public class lichsu {
	private int mahd;
	private int idkh;
	private String tenkh;
	private String masp;
	private String tensp;
	private String hinhanh;
	private Date ngaymua;
	private double giasp;
	private int soluong;
	private double thanhtien;
	private int machitiethoadon;
	private int damua;
	
	public lichsu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public lichsu(int mahd, int damua) {
		super();
		this.mahd = mahd;
		this.damua = damua;
	}

	public lichsu(int mahd, int idkh, String tenkh, String masp, String tensp, String hinhanh, Date ngaymua,
			double giasp, int soluong, double thanhtien, int machitiethoadon, int damua) {
		super();
		this.mahd = mahd;
		this.idkh = idkh;
		this.tenkh = tenkh;
		this.masp = masp;
		this.tensp = tensp;
		this.hinhanh = hinhanh;
		this.ngaymua = ngaymua;
		this.giasp = giasp;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
		this.machitiethoadon = machitiethoadon;
		this.damua = damua;
	}

	public lichsu(String masp, String tensp, String hinhanh, Date ngaymua, double giasp, int soluong,
			double thanhtien) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.hinhanh = hinhanh;
		this.ngaymua = ngaymua;
		this.giasp = giasp;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
	}

	public int getMahd() {
		return mahd;
	}

	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	public int getIdkh() {
		return idkh;
	}

	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public Date getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}

	public double getGiasp() {
		return giasp;
	}

	public void setGiasp(double giasp) {
		this.giasp = giasp;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}

	public int getMachitiethoadon() {
		return machitiethoadon;
	}

	public void setMachitiethoadon(int machitiethoadon) {
		this.machitiethoadon = machitiethoadon;
	}

	public int getDamua() {
		return damua;
	}

	public void setDamua(int damua) {
		this.damua = damua;
	}
	
	
	
}
