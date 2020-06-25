package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAL.datPhongDAL;
import DAL.khachDAL;
import DAL.phongDAL;
import DAL.userDAL;
import DTO.datPhongDTO;
import GUI.thongbao;

public class datPhongBLL {
	datPhongDAL dpdal =new datPhongDAL();
	public ArrayList<datPhongDTO> getAllDP(){
		return dpdal.getAllDP();
	}
	public ResultSet getDPById(datPhongDTO dpdto){
		return dpdal.getDPById(dpdto);
	}
	public int updateDP(datPhongDTO dpdto) {
		return dpdal.updateDP(dpdto);
	}
	public int deleteDP(datPhongDTO dpdto) {
		return dpdal.deleteDP(dpdto);
	}
	public int insertDP(datPhongDTO dpdto) {
		return dpdal.insertDP(dpdto);
	}
	public boolean themDP(datPhongDTO dpdto) {
		String setMa = "[^0-9]";
		Pattern pMa = Pattern.compile(setMa);
		Matcher maK = pMa.matcher(dpdto.getIdK());
		Matcher maTK = pMa.matcher(dpdto.getIdNV());
		
		if(maK.find()||maTK.find()) {
			thongbao.thongbao("Ma khach hoac ma tai khoan chi duoc co so", "Thong bao");
			return false;
		}
		khachDAL kdal = new khachDAL();
		ResultSet rs_k = kdal.getKhachById(Integer.parseInt(dpdto.getIdK()));
		phongDAL pdal = new phongDAL();
		ResultSet rs_p = pdal.getPhongByName(dpdto.getTenP());
		userDAL udal = new userDAL();
		ResultSet rs_tk = udal.getUserById(Integer.parseInt(dpdto.getIdNV()));
		try {
			if(!rs_k.next()) {
				thongbao.thongbao("Ma khach khong ton tai", "Thong bao");
				return false;
			}
			if(!rs_p.next()) {
				thongbao.thongbao("Ten phong khong ton tai", "Thong bao1");
				return false;
			}
			if(!rs_tk.next()) {
				thongbao.thongbao("Tai khoan khong ton tai", "Thong bao");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String setND = "(\\d){4}-(\\d){2}-(\\d){2}";
		Pattern pND = Pattern.compile(setND);
		Matcher nd = pND.matcher(dpdto.getNgayDen());
		if(!dpdto.getNgayDen().matches(setND)) {
			thongbao.thongbao("Ngay den co dang 4 so - 2 so - 2 so", "Thong bao");
			return false;
		}
		if(dpdto.getSoNgayThue()<=0) {
			thongbao.thongbao("So ngay thue phai lon hoon 0", "Thong bao");
			return false;
		}
		LocalDate date = LocalDate.now();
		String strDate = String.valueOf(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = sdf.parse(strDate);
			date2 = (Date) sdf.parse(dpdto.getNgayDen());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(date2.before(date1)) {
			thongbao.thongbao("Ngay den phai lon hon hoac bang ngay hien tai", "Thong bao");
			return false;
		}
		int kq = 0;
		kq = dpdal.insertDP(dpdto);
		if(kq==0) {
			thongbao.thongbao("Co loi xay ra", "Thong bao");
			return false;
		}
		return true;
	}
	public boolean suaDP(datPhongDTO dpdto) {
		String setMa = "[^0-9]";
		Pattern pMa = Pattern.compile(setMa);
		Matcher maK = pMa.matcher(dpdto.getIdK());
		Matcher maTK = pMa.matcher(dpdto.getIdNV());
		
		if(maK.find()||maTK.find()) {
			thongbao.thongbao("Ma khach hoac ma tai khoan chi duoc co so", "Thong bao");
			return false;
		}
		khachDAL kdal = new khachDAL();
		ResultSet rs_k = kdal.getKhachById(Integer.parseInt(dpdto.getIdK()));
		phongDAL pdal = new phongDAL();
		ResultSet rs_p = pdal.getPhongByName(dpdto.getTenP());
		userDAL udal = new userDAL();
		ResultSet rs_tk = udal.getUserById(Integer.parseInt(dpdto.getIdNV()));
		try {
			if(!rs_k.next()) {
				thongbao.thongbao("Ma khach khong ton tai", "Thong bao");
				return false;
			}
			if(!rs_p.next()) {
				thongbao.thongbao("Ten phong khong ton tai", "Thong bao1");
				return false;
			}
			if(!rs_tk.next()) {
				thongbao.thongbao("Tai khoan khong ton tai", "Thong bao");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String setND = "(\\d){4}-(\\d){2}-(\\d){2}";
		Pattern pND = Pattern.compile(setND);
		Matcher nd = pND.matcher(dpdto.getNgayDen());
		if(!dpdto.getNgayDen().matches(setND)) {
			thongbao.thongbao("Ngay den co dang 4 so - 2 so - 2 so", "Thong bao");
			return false;
		}
		if(dpdto.getSoNgayThue()<=0) {
			thongbao.thongbao("So ngay thue phai lon hoon 0", "Thong bao");
			return false;
		}
		LocalDate date = LocalDate.now();
		String strDate = String.valueOf(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = sdf.parse(strDate);
			date2 = (Date) sdf.parse(dpdto.getNgayDen());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(date2.before(date1)) {
			thongbao.thongbao("Ngay den phai lon hon hoac bang ngay hien tai", "Thong bao");
			return false;
		}
		int kq = 0;
		kq = dpdal.updateDP(dpdto);
		if(kq==0) {
			thongbao.thongbao("Co loi xay ra", "Thong bao");
			return false;
		}
		return true;
	}
	public ArrayList<datPhongDTO> timKiemDP(String tuKhoa){
		return dpdal.timKiemDP(tuKhoa);
	}
	public ResultSet getDPById(int maDP) {
		return dpdal.getDPById(maDP);
	}
}
