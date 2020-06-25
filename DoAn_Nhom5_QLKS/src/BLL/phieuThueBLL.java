package BLL;

import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAL.datPhongDAL;
import DAL.khachDAL;
import DAL.phongDAL;
import DTO.datPhongDTO;
import DTO.khachDTO;
import DTO.phongDTO;
import GUI.thongbao;

public class phieuThueBLL {
	static phongDAL pdal = new phongDAL();
	static datPhongDAL dpdal = new datPhongDAL();
	static khachDAL kdal = new khachDAL();
	static String setHT = "[^a-zA-Z ]";
	static Pattern pHT = Pattern.compile(setHT);
	static String setSDTCMNDCard = "[^0-9]";
	static Pattern pSDTCMNDCard = Pattern.compile(setSDTCMNDCard);
	static String setNgayDen = "(\\d){4}-(\\d){2}-(\\d){2}";
	static Pattern pNgayDen = Pattern.compile(setNgayDen);
	public static boolean kiemTraPT(phongDTO pdto, datPhongDTO dpdto, khachDTO kdto) {
		if(kdto.getHTK().trim().equals("")||kdto.getGTK().trim().equals("")||kdto.getSDT().trim().equals("")||kdto.getCMNDK().trim().equals("")||kdto.getCard().trim().equals("")||kdto.getQuocTich().trim().equals("")|| dpdto.getNgayDen().trim().equals("")) {
			thongbao.thongbao("Khong de trong du lieu", "Thong bao");
			return false;
		}
		Matcher ht = pHT.matcher(kdto.getHTK());
		if(ht.find()) {
			thongbao.thongbao("Khong chua ky tu dac biet", "Thong bao");
			return false;
		}
		Matcher sdt = pSDTCMNDCard.matcher(kdto.getSDT());
		Matcher cmnd = pSDTCMNDCard.matcher(kdto.getCMNDK());
		Matcher card = pSDTCMNDCard.matcher(kdto.getCard());
		if(sdt.find()||cmnd.find()||card.find()){
			thongbao.thongbao("SDT, CMND, Card Chi duoc so", "Thong bao");
			return false;
		}
		Matcher ngayDen = pNgayDen.matcher(dpdto.getNgayDen());
		if(!dpdto.getNgayDen().matches(setNgayDen)) {
			thongbao.thongbao("Ngay den co dang so-so-so", "Thong bao");
			return false;
		}
		if(kdto.getSDT().length()>10||kdto.getSDT().length()<10) {
			thongbao.thongbao("SDT có đúng 10 chữ số", "Thông báo");
			return false;
		}
		if(kdto.getCMNDK().length()<9||kdto.getCMNDK().length()>9) {
			thongbao.thongbao("CMND có đúng 9 chữ số", "Thông báo");
			return false;
		}
		if(kdto.getCard().length()<16||kdto.getCard().length()>16) {
			thongbao.thongbao("Mã thẻ có đúng 16 chữ số", "Thông báo");
			return false;
		}
		if(!kdto.getGTK().equals("Nu")&&!kdto.getGTK().equals("Nam")) {
			thongbao.thongbao("Du lieu gioi tinh co dang Nam/Nu", "Thong bao");
			return false;
		}
		if(dpdto.getSoNgayThue()<= 0) {
			thongbao.thongbao("So ngay thue phai lon hon 0", "Thong bao");
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
		pdal.updateTrangThaiP(pdto);
		kdal.insertKhach(kdto);
		//lay id khach vua nhap
		dpdto.setIdK(String.valueOf(kdal.getIdByCMND(kdto)));
		int kq = 0;
		kq = dpdal.insertDP(dpdto);
		if(kq==0) {
			thongbao.thongbao("Co loi xay ra", "Thong bao");
			return false;
		}
		return true;
	}
	
}
