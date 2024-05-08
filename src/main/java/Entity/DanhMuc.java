package Entity;

public class DanhMuc {
	private int id;
	private String tendanhmuc;
	private int thutu;
	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DanhMuc(int id, String tendanhmuc, int thutu) {
		super();
		this.id = id;
		this.tendanhmuc = tendanhmuc;
		this.thutu = thutu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTendanhmuc() {
		return tendanhmuc;
	}
	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}
	public int getThutu() {
		return thutu;
	}
	public void setThutu(int thutu) {
		this.thutu = thutu;
	}
	
	
}
