package DTO;

public class nhanVienDTO {
	private int idNV;
	private String HTNV;
	private String GTNV;
	private String NS;
	private String DC;
	private String CMNDNV;
	private String SDTNV;
	private String chucVu;
	private String ngayDiLam;
	private double mucLuong;
	public nhanVienDTO(int idNV, String hTNV, String gTNV, String nS, String dC, String cMNDNV, String sDTNV, String chucVu,String ngayDiLam, double mucLuong ) {
		this.idNV = idNV;
		this.HTNV = hTNV;
		this.GTNV = gTNV;
		this.NS = nS;
		this.DC = dC;
		this.CMNDNV = cMNDNV;
		this.SDTNV = sDTNV;
		this.chucVu = chucVu;
		this.ngayDiLam = ngayDiLam;
		this.mucLuong = mucLuong;
	}
	public nhanVienDTO(String hTNV, String gTNV, String nS, String dC, String cMNDNV, String sDTNV, int idTK,
			String chucVu,String ngayDiLam, double mucLuong) {
		this.HTNV = hTNV;
		this.GTNV = gTNV;
		this.NS = nS;
		this.DC = dC;
		this.CMNDNV = cMNDNV;
		this.SDTNV = sDTNV;
		this.chucVu = chucVu;
		this.ngayDiLam = ngayDiLam;
		this.mucLuong = mucLuong;
	}
	public nhanVienDTO() {
		this.idNV = 0;
		this.HTNV = null;
		this.GTNV = null;
		this.NS = null;
		this.DC = null;
		this.CMNDNV = null;
		this.SDTNV = null;
		this.chucVu = null;
		this.ngayDiLam = null;
		this.mucLuong = 0;
	}
	public int getIdNV() {
		return idNV;
	}
	public void setIdNV(int idNV) {
		this.idNV = idNV;
	}
	public String getHTNV() {
		return HTNV;
	}
	public void setHTNV(String hTNV) {
		HTNV = hTNV;
	}
	public String getGTNV() {
		return GTNV;
	}
	public void setGTNV(String gTNV) {
		GTNV = gTNV;
	}
	public String getNS() {
		return NS;
	}
	public void setNS(String nS) {
		NS = nS;
	}
	public String getDC() {
		return DC;
	}
	public void setDC(String dC) {
		DC = dC;
	}
	public String getCMNDNV() {
		return CMNDNV;
	}
	public void setCMNDNV(String cMNDNV) {
		CMNDNV = cMNDNV;
	}
	public String getSDTNV() {
		return SDTNV;
	}
	public void setSDTNV(String sDTNV) {
		SDTNV = sDTNV;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public double getMucLuong() {
		return mucLuong;
	}
	public void setMucLuong(double mucLuong) {
		this.mucLuong = mucLuong;
	}
	public String getNgayDiLam() {
		return ngayDiLam;
	}
	public void setNgayDiLam(String ngayDiLam) {
		this.ngayDiLam = ngayDiLam;
	}
	
	
}
