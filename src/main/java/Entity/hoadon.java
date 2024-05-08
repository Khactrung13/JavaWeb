package Entity;

import java.util.Date;

public class hoadon {
	private int mahd;
	private int idkh;
	private String tenkh;
	private String dienthoai;
	private String diachi;
	private Date ngaymua;
	private int damua;
	
	public hoadon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public hoadon(int mahd, int idkh, String tenkh, String dienthoai, String diachi, Date ngaymua, int damua) {
		super();
		this.mahd = mahd;
		this.idkh = idkh;
		this.tenkh = tenkh;
		this.dienthoai = dienthoai;
		this.diachi = diachi;
		this.ngaymua = ngaymua;
		this.damua = damua;
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

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public Date getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}

	public int getDamua() {
		return damua;
	}

	public void setDamua(int damua) {
		this.damua = damua;
	}
	
	
}
