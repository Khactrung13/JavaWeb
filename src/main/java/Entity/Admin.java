package Entity;

public class Admin {
	private String username;
	private String pass;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
