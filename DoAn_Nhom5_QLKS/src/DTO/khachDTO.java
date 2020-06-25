package DTO;

public class khachDTO {
	private int idK;
	private String HTK;
	private String GTK;
	private String SDT;
	private String CMNDK;
	private String card;
	private String quocTich;
	public khachDTO() {
		this.idK = 0 ;
		this.HTK = null;
		this.GTK = null;
		this.SDT = null;
		this.CMNDK = null;
		this.card = null;
		this.quocTich = null;
	}
	public khachDTO(int idK, String HTK, String GTK, String SDT, String CMNDK, String card, String quocTich) {
		this.idK = idK;
		this.HTK = HTK;
		this.GTK = GTK;
		this.SDT = SDT;
		this.CMNDK = CMNDK;
		this.card = card;
		this.quocTich = quocTich;
	}
	public khachDTO(String HTK, String GTK, String SDT, String CMNDK, String card, String quocTich) {
		this.HTK = HTK;
		this.GTK = GTK;
		this.SDT = SDT;
		this.CMNDK = CMNDK;
		this.card = card;
		this.quocTich = quocTich;
	}
	public int getIdK() {
		return idK;
	}
	public void setIdK(int idK) {
		this.idK = idK;
	}
	public String getHTK() {
		return HTK;
	}
	public void setHTK(String hTK) {
		HTK = hTK;
	}
	public String getGTK() {
		return GTK;
	}
	public void setGTK(String gTK) {
		GTK = gTK;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getCMNDK() {
		return CMNDK;
	}
	public void setCMNDK(String cMNDK) {
		CMNDK = cMNDK;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}
	
}
