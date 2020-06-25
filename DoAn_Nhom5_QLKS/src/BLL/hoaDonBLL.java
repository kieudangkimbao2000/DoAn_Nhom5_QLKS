package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAL.hoaDonDAL;
import DTO.hoaDonDTO;
import GUI.thongbao;

public class hoaDonBLL {
	hoaDonDAL hddal = new hoaDonDAL();
	public ArrayList<hoaDonDTO> getAllHD(){
		return hddal.getAllHD();
	}
	public ArrayList<hoaDonDTO> getHDById(hoaDonDTO hddto){
		return hddal.getHDById(hddto);
	}
	public int updateHD(hoaDonDTO hddto) {
		return hddal.updateHD(hddto);
	}
	public int deleteHD(hoaDonDTO hddto) {
		return hddal.deleteHD(hddto);
	}
	public int insertHD(hoaDonDTO hddto) {
		return hddal.insertHD(hddto);
	}
	public ResultSet getHDById_RS(hoaDonDTO hddto) {
		return hddal.getHDById_RS(hddto);
	}
	public boolean themHD(hoaDonDTO hddto){
		String setTT = "[^a-zA-Z ]";
		Pattern pTT = Pattern.compile(setTT);
		Matcher tt = pTT.matcher(hddto.getTrangThai());
		String setSo = "[^0-9]";
		Pattern pSo = Pattern.compile(setSo);
		Matcher maDP = pSo.matcher(hddto.getIdDP());
		Matcher tong = pSo.matcher(hddto.getTong());
		if(hddto.getIdDP().equals("")||hddto.getTong().equals("")||hddto.getTrangThai().equals("")) {
			thongbao.thongbao("Khong de trong du lieu", "Thong bao");
			return false;
		}
		if(maDP.find()||tong.find()) {
			thongbao.thongbao("Ma dat phong va tong chi chu ky tu so", "Thong bao");
			return false;
		}
		if(tt.find()) {
			thongbao.thongbao("Trang thai chi chua chu cai", "thong bao");
			return false;
		}
		datPhongBLL dpbll = new datPhongBLL();
		ResultSet rs_dp = dpbll.getDPById(Integer.parseInt(hddto.getIdDP()));
		try {
			if(!rs_dp.next()){
				thongbao.thongbao("Dat phong khong ton tai", "Thong bao");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!hddto.getTrangThai().equals("Chua in")&&!hddto.getTrangThai().equals("Da in")) {
			thongbao.thongbao("Trang thai chi duoc nhap Chua in/Da in", "Thong bao");
			return false;
		}
		int kq= 0;
		kq = hddal.insertHD(hddto);
		if(kq==0) {
			thongbao.thongbao("Co loi da xay ra", "Thong bao");
			return false;
		}
		return true;
	}
	public boolean suaHD(hoaDonDTO hddto) {
		String setTT = "[^a-zA-Z ]";
		Pattern pTT = Pattern.compile(setTT);
		Matcher tt = pTT.matcher(hddto.getTrangThai());
		String setSo = "[^0-9]";
		Pattern pSo = Pattern.compile(setSo);
		Matcher maDP = pSo.matcher(hddto.getIdDP());
		Matcher tong = pSo.matcher(hddto.getTong());
		if(hddto.getIdDP().equals("")||hddto.getTong().equals("")||hddto.getTrangThai().equals("")) {
			thongbao.thongbao("Khong de trong du lieu", "Thong bao");
			return false;
		}
		if(maDP.find()||tong.find()) {
			thongbao.thongbao("Ma dat phong va tong chi chu ky tu so", "Thong bao");
			return false;
		}
		if(tt.find()) {
			thongbao.thongbao("Trang thai chi chua chu cai", "thong bao");
			return false;
		}
		datPhongBLL dpbll = new datPhongBLL();
		ResultSet rs_dp = dpbll.getDPById(Integer.parseInt(hddto.getIdDP()));
		try {
			if(!rs_dp.next()){
				thongbao.thongbao("Dat phong khong ton tai", "Thong bao");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!hddto.getTrangThai().equals("Chua in")&&!hddto.getTrangThai().equals("Da in")) {
			thongbao.thongbao("Trang thai chi duoc nhap Chua in/Da in", "Thong bao");
			return false;
		}
		int kq= 0;
		kq = hddal.updateHD(hddto);
		if(kq==0) {
			thongbao.thongbao("Co loi da xay ra", "Thong bao");
			return false;
		}
		return true;
	}
}
