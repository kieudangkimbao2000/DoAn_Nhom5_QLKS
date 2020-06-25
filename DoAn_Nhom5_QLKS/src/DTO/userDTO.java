package DTO;

public class userDTO {
	private int idUser;
	private	String tenDangNhap;
	 private   String mk;
	 private   String hoVaTen;
	 private   String email;
	 private int quyen;
	 public userDTO() {
		 this.idUser = 0;
		 this.tenDangNhap = null;
		 this.mk = null;
		 this.hoVaTen = null;
		 this.email = null;
		 this.quyen = 0;
	 }
	 public userDTO(int iduser, String tendangnhap, String mk, String hovaten, String email, int quyen) {
		 this.idUser = iduser;
		 this.tenDangNhap = tendangnhap;
		 this.mk = mk;
		 this.hoVaTen = hovaten;
		 this.email = email;
		 this.quyen = quyen;
	 }
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tendangnhap) {
		this.tenDangNhap = tendangnhap;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hovaten) {
		this.hoVaTen = hovaten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int iduser) {
		this.idUser = iduser;
	}
	public int getQuyen() {
		return quyen;
	}
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	
}
