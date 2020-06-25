package DTO;

public class phongDTO {
	private String tenP;
	private int soNguoi;
	private String gia;
	private String loaiP;
	private String trangThai;
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public phongDTO() {
		this.tenP = null;
		this.soNguoi = 0;
		this.gia = null;
		this.loaiP = null;
		this.trangThai = null;
	}
	public phongDTO(int soNguoi, String tenP, String gia, String loaiP, String tinhTrangP){
		this.soNguoi = soNguoi;
		this.tenP = tenP;
		this.gia = gia;
		this.loaiP = loaiP;
		this.trangThai = tinhTrangP;
	}
	public String getTenP() {
		return tenP;
	}
	public void setTenP(String tenP) {
		this.tenP = tenP;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public String getLoaiP() {
		return loaiP;
	}
	public void setLoaiP(String loaiP) {
		this.loaiP = loaiP;
	}

}
