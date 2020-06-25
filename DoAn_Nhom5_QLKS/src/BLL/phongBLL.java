package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAL.phongDAL;
import DTO.phongDTO;
import GUI.themSuaP;
import GUI.thongbao;


public class phongBLL {
	
	phongDAL pdal = new phongDAL();
	static String setGia = "[^0-9]";
	static Pattern pGia = Pattern.compile(setGia);
	
	public ArrayList<phongDTO> getALLP(){
		return pdal.getAllP();
	}
	public ArrayList<phongDTO> getPhongById(phongDTO pdto){
		return pdal.getPhongById(pdto);
	}
	public int updatePhong(phongDTO pdto) {
		return pdal.updatePhong(pdto);
	}
	public int deletePhong(phongDTO pdto) {
		return pdal.deletePhong(pdto);
	}
	public int insertPHong(phongDTO pdto) {
		return pdal.insertPhong(pdto);
	}
	public ResultSet getPhongByName(phongDTO pdto) {
		return pdal.getPhongByName(pdto);
	}
	public boolean themP(phongDTO pdto) {
		ResultSet rs =pdal.getAllP_RS();
		try {
			while(rs.next()) {
				if(rs.getString("tenP").equals(pdto.getTenP())) {
					thongbao.thongbao("Ten phong da ton tai", "Thong bao");
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pdto.getTenP().equals("")||pdto.getLoaiP().equals("")||pdto.getSoNguoi()==0||pdto.getGia()==""||pdto.getTrangThai().equals("")) {
			thongbao.thongbao("Khong duoc de trong du lieu", "Thong bao");
			return false;
		}
		if(!pdto.getTrangThai().equals("Trong")&&!pdto.getTrangThai().equals("Da thue")) {
			thongbao.thongbao("Trang phai phai la Trong/Da thue", "Thong bao");
			return false;
		}
		if(pdto.getSoNguoi()<=0) {
			thongbao.thongbao("So nguoi phai lon hon khong", "Thong bao");
			return false;
		}
		if(!pdto.getLoaiP().equals("vip")&&!pdto.getTrangThai().equals("thuong")) {
			thongbao.thongbao("Loai phong phai la vip/thuong", "Thong bao");
			return false;
		}
		Matcher gia = pGia.matcher(pdto.getGia());
		if(gia.find()) {
			thongbao.thongbao("Gia chi duoc so", "Thong bao");
			return false;
		}
		int kq = 0;
		kq = pdal.insertPhong(pdto);
		if(kq==0) {
			thongbao.thongbao("Co loi xay ra", "That bai");
			return false;
		}
		return true;
	}
	public boolean suaP(phongDTO pdto) {
		if(pdto.getTenP().equals("")||pdto.getLoaiP().equals("")||pdto.getSoNguoi()==0||pdto.getGia()==""||pdto.getTrangThai().equals("")) {
			thongbao.thongbao("Khong duoc de trong du lieu", "Thong bao");
			return false;
		}
		if(!pdto.getTrangThai().equals("Trong")&&!pdto.getTrangThai().equals("Da thue")) {
			thongbao.thongbao("Trang phai phai la Trong/Da thue", "Thong bao");
			return false;
		}
		if(pdto.getSoNguoi()<=0) {
			thongbao.thongbao("So nguoi phai lon hon khong", "Thong bao");
			return false;
		}
		if(!pdto.getLoaiP().equals("vip")&&!pdto.getLoaiP().equals("thuong")) {
			thongbao.thongbao("Loai phong phai la vip/thuong", "Thong bao");
			return false;
		}
		Matcher gia = pGia.matcher(pdto.getGia());
		if(gia.find()) {
			thongbao.thongbao("Gia chi duoc so", "Thong bao");
			return false;
		}
		int kq = 0;
		kq = pdal.updatePhong(pdto);
		if(kq==0) {
			thongbao.thongbao("Co loi xay ra", "Thong bao");
			return false;
		}
		return true;
	}
	public ArrayList<phongDTO> timKiemP(String tuKhoa){
		return pdal.timKiemP(tuKhoa);
	}
}
