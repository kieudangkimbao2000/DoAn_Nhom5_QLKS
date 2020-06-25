package BLL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAL.khachDAL;
import DTO.khachDTO;
import GUI.thongbao;

public class khachBLL {
	khachDAL kdal = new khachDAL();
	public ArrayList<khachDTO> getAllK(){
		return kdal.getAllK();
	}
	public ResultSet getKhachById(khachDTO kdto){
		return kdal.getKhachById(kdto);
	}
	public int updateKhach(khachDTO kdto) {
		return kdal.updateKhach(kdto);
	}
	public int deleteKhach(khachDTO kdto) {
		return kdal.deleteKhach(kdto);
	}
	public int insertKhach(khachDTO kdto) {
		return kdal.insertKhach(kdto);
	}
	public int getIdByCMND(khachDTO kdto) {
		return kdal.getIdByCMND(kdto);
	}
	public boolean themK(khachDTO kdto) {
		String setTen = "[^a-zA-Z ]";
		String setSo = "[^0-9]";
		Pattern pSo = Pattern.compile(setSo);
		Pattern pTen = Pattern.compile(setTen);
		Matcher ten = pTen.matcher(kdto.getHTK());
		Matcher qt = pTen.matcher(kdto.getQuocTich());
		Matcher SDT = pSo.matcher(kdto.getSDT());
		Matcher CMND = pSo.matcher(kdto.getCMNDK());
		Matcher Card = pSo.matcher(kdto.getCard());
		if(kdto.getHTK().equals("")||kdto.getGTK().equals("")||kdto.getQuocTich().equals("")||kdto.getCMNDK().equals("")||kdto.getSDT().equals("")||kdto.getCard().equals("")) {
			thongbao.thongbao("Khong de trong du lieu", "Thong bao");
			return false;
		}
		if(ten.find()) {
			thongbao.thongbao("Ho va ten khong duoc chuaw ky tu dac biet va so.", "Thong bao");
			return false;
		}
		if(qt.find()) {
			thongbao.thongbao("Quoc tich khong chua ky tu dac biet va so", "Thong bao");
			return false;
		}
		if(!kdto.getGTK().equals("Nam")&&!kdto.getGTK().equals("Nu")) {
			thongbao.thongbao("Gioi tinh co dang du lieu Nam/Nu", "Thong bao");
			return false;
		}
		if(SDT.find()||CMND.find()||Card.find()) {
			thongbao.thongbao("SDT, CMND, Card chi duoc chua so", "Thong bao");
			return false;
		}
		if(kdto.getSDT().length()!=10) {
			thongbao.thongbao("SDT co dung 10 chu so", "Thong bao");
			return false;
		}
		if(kdto.getCMNDK().length()!=9) {
			thongbao.thongbao("CMND co dung 9 chu so", "Thong bao");
			return false;
		}
		if(kdto.getCard().length()!=16) {
			thongbao.thongbao("Card co dung 16 chu so", "Thong bao");
			return false;
		}
		int kq = 0;
		kq = kdal.insertKhach(kdto);
		if(kq==0) {
			thongbao.thongbao("Co loi xay ra", "Thong bao");
			return false;
		}
		return true;
	}
	public boolean suaK(khachDTO kdto) {
		String setTen = "[^a-zA-Z ]";
		String setSo = "[^0-9]";
		Pattern pSo = Pattern.compile(setSo);
		Pattern pTen = Pattern.compile(setTen);
		Matcher ten = pTen.matcher(kdto.getHTK());
		Matcher qt = pTen.matcher(kdto.getQuocTich());
		Matcher SDT = pSo.matcher(kdto.getSDT());
		Matcher CMND = pSo.matcher(kdto.getCMNDK());
		Matcher Card = pSo.matcher(kdto.getCard());
		if(kdto.getHTK().equals("")||kdto.getGTK().equals("")||kdto.getQuocTich().equals("")||kdto.getCMNDK().equals("")||kdto.getSDT().equals("")||kdto.getCard().equals("")) {
			thongbao.thongbao("Khong de trong du lieu", "Thong bao");
			return false;
		}
		if(ten.find()) {
			thongbao.thongbao("Ho va ten khong duoc chuaw ky tu dac biet va so.", "Thong bao");
			return false;
		}
		if(qt.find()) {
			thongbao.thongbao("Quoc tich khong chua ky tu dac biet va so", "Thong bao");
			return false;
		}
		if(!kdto.getGTK().equals("Nam")&&!kdto.getGTK().equals("Nu")) {
			thongbao.thongbao("Gioi tinh co dang du lieu Nam/Nu", "Thong bao");
			return false;
		}
		if(SDT.find()||CMND.find()||Card.find()) {
			thongbao.thongbao("SDT, CMND, Card chi duoc chua so", "Thong bao");
			return false;
		}
		if(kdto.getSDT().length()!=10) {
			thongbao.thongbao("SDT co dung 10 chu so", "Thong bao");
			return false;
		}
		if(kdto.getCMNDK().length()!=9) {
			thongbao.thongbao("CMND co dung 9 chu so", "Thong bao");
			return false;
		}
		if(kdto.getCard().length()!=16) {
			thongbao.thongbao("Card co dung 16 chu so", "Thong bao");
			return false;
		}
		int kq = 0;
		kq = kdal.updateKhach(kdto);
		if(kq==0) {
			thongbao.thongbao("Co loi xay ra", "Thong bao");
			return false;
		}
		return true;
	}
	public ArrayList<khachDTO> timKiemK(String tuKhoa){
		return kdal.timKiemK(tuKhoa);
	}
}
