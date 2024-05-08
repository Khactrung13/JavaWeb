package Entity;

public class KhachHang {
	private int id;
	private String tenKhachHang;
	private String email;
	private String diaChi;
	private String matKhau;
	private String dienThoai;
	
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public KhachHang(String email, String matKhau) {
		super();
		this.email = email;
		this.matKhau = matKhau;
	}


	public KhachHang(int id, String tenKhachHang, String email, String diaChi, String matKhau, String dienThoai) {
		super();
		this.id = id;
		this.tenKhachHang = tenKhachHang;
		this.email = email;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.dienThoai = dienThoai;
	}

	public KhachHang(String tenKhachHang, String email, String diaChi, String matKhau, String dienThoai) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.email = email;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.dienThoai = dienThoai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	
	
}
