package DTO;

public class hoaDonDTO {
	private int idHD;
	private String idDP;
	private String tong;
	private String trangThai;
	public hoaDonDTO() {
		this.idHD = 0;
		this.idDP = null;
		this.tong = null;
	}
	public hoaDonDTO(int idHD, String idDP, String tong) {
		this.idHD = idHD;
		this.idDP=idDP;
		this.tong = tong;
	}
	public hoaDonDTO( String idDP, String tong) {
		this.idDP=idDP;
		this.tong = tong;
	}
	public int getIdHD() {
		return idHD;
	}
	public void setIdHD(int idHD) {
		this.idHD = idHD;
	}
	public void setTong(String tong2) {
		this.tong = tong2;
	}
	public String getTong() {
		return tong;
	}
	public String getIdDP() {
		return idDP;
	}
	public void setIdDP(String string) {
		this.idDP = string;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
		
	}
	public String getTrangThai() {
		// TODO Auto-generated method stub
		return this.trangThai;
	}
	
}
