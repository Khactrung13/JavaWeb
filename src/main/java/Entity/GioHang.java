package Entity;

public class GioHang {
	
	private String masanpham;
	private String tensanpham;
	private String hinhanh;
	private double gia;
	private int soluongmua;
	private double thanhtien;
	
	public GioHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GioHang(String masanpham, String tensanpham, double gia, int soluongmua) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.gia = gia;
		this.soluongmua = soluongmua;
	}
	
	public GioHang(String masanpham, String tensanpham, String hinhanh, double gia, int soluongmua) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.hinhanh = hinhanh;
		this.gia = gia;
		this.soluongmua = soluongmua;
	}

	public String getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(String masanpham) {
		this.masanpham = masanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoluongmua() {
		return soluongmua;
	}

	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
	}

	public double getThanhtien() {
		return soluongmua*gia;
	}

	public void setThanhtien(double thanhtien) {
		this.thanhtien = soluongmua*gia;
	}
	
	
	
	
}
