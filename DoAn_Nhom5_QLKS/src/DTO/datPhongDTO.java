package DTO;

public class datPhongDTO {
	private int idDP;
	private String idK;
	private String tenP;
	private String idNV;
	private String ngayDen;
	private int soNgayThue;
	public datPhongDTO() {
		this.idDP = 0;
		this.idK = null;
		this.tenP = null;
		this.idNV = null;
		this.ngayDen = null;
		this.soNgayThue = 0;
	}
	public datPhongDTO(int idDP, String idK, String tenP, String idNV, String ngayDen, int soNgayThue) {
		this.idDP = idDP;
		this.idK = idK;
		this.tenP = tenP;
		this.idNV = idNV;
		this.ngayDen = ngayDen;
		this.soNgayThue = soNgayThue;
	}
	public datPhongDTO(String idK, String tenP, String idNV,String ngayDen, int soNgayThue) {
		this.idK = idK;
		this.tenP = tenP;
		this.idNV = idNV;
		this.ngayDen = ngayDen;
		this.soNgayThue = soNgayThue;
	}
	public int getIdDP() {
		return idDP;
	}
	public void setIdDP(int idDP) {
		this.idDP = idDP;
	}
	public String getIdK() {
		return idK;
	}
	public void setIdK(String idK) {
		this.idK = idK;
	}
	public String getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(String ngayDen) {
		this.ngayDen = ngayDen;
	}
	public String getIdNV() {
		return idNV;
	}
	public void setIdNV(String idNV) {
		this.idNV = idNV;
	}
	public int getSoNgayThue() {
		return soNgayThue;
	}
	public void setSoNgayThue(int soNgayThue) {
		this.soNgayThue = soNgayThue;
	}
	public String getTenP() {
		return tenP;
	}
	public void setTenP(String tenP) {
		this.tenP = tenP;
	}
	
}
