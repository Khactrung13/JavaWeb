package Entity;

public class SanPham {
	private int id;
	private String tensp;
	private String ma;
	private double gia;
	private int soluong;
	private String hinhanh;
	private String tomtat;
	private String noidung;
	private int tinhtrang;
	private int iddanhmuc;
	
	public SanPham() {
		super();
	}

	public SanPham(int id, String tensp, String ma, double gia, int soluong, String hinhanh, String tomtat,
			String noidung, int tinhtrang, int iddanhmuc) {
		super();
		this.id = id;
		this.tensp = tensp;
		this.ma = ma;
		this.gia = gia;
		this.soluong = soluong;
		this.hinhanh = hinhanh;
		this.tomtat = tomtat;
		this.noidung = noidung;
		this.tinhtrang = tinhtrang;
		this.iddanhmuc = iddanhmuc;
	}
	
	public SanPham(String tensp, String ma, double gia, int soluong, String hinhanh, String tomtat, String noidung,
			int iddanhmuc) {
		super();
		this.tensp = tensp;
		this.ma = ma;
		this.gia = gia;
		this.soluong = soluong;
		this.hinhanh = hinhanh;
		this.tomtat = tomtat;
		this.noidung = noidung;
		this.iddanhmuc = iddanhmuc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public String getTomtat() {
		return tomtat;
	}

	public void setTomtat(String tomtat) {
		this.tomtat = tomtat;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public int getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public int getIddanhmuc() {
		return iddanhmuc;
	}

	public void setIddanhmuc(int iddanhmuc) {
		this.iddanhmuc = iddanhmuc;
	}

	
}
