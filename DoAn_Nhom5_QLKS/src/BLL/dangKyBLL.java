package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAL.dangKyDAL;
import DAL.userDAL;
import DTO.userDTO;
import GUI.thongbao;

public class dangKyBLL {
	
	private userDAL udal = new userDAL();
	
	public static String pass2;
    public static String setEmail = "\\w+@\\w+(\\.\\w+){1,2}";
    public static boolean kiemTraDK(userDTO udto,String nhaplai) {
    	dangKyDAL dkdal = new dangKyDAL();
		ResultSet rs = dkdal.ktTKTonTai();
		 try {
	            while (rs.next()) {
	                if (udto.getTenDangNhap().equals(rs.getString("TENDANGNHAP"))) {
	                    thongbao.thongbao("tên đăng nhập đã sử dụng", "thông báo");
	                    return false;

	                }
	                if (udto.getEmail().equals(rs.getString("EMAIL"))) {
	                    thongbao.thongbao("email đã sử dụng", "thông báo");
	                    return false;
	                }
	            }
	        } catch (SQLException ex) {

	        }
		 if (udto.getHoVaTen().trim().equals("") || udto.getTenDangNhap().trim().equals("") || udto.getEmail().trim().equals("") || udto.getMk().trim().equals("") || nhaplai.trim().equals("")) {
	            thongbao.thongbao("không để trống dữ liệu", "thông báo");
	            return false;
	        }
	        if (!udto.getMk().matches(nhaplai)) {
	            thongbao.thongbao("nhập lại mk không chính xác", "thông báo");
	            return false;
	        }
	        if (!udto.getEmail().matches(setEmail)) {
	            thongbao.thongbao("email lỗi", "thông báo");
	            return false;
	        }
	        if (udto.getHoVaTen().length() < 3) {
	            thongbao.thongbao("họ và tên phải lớn hơn 3 ký tự", "thông báo");
	            return false;
	        }
	        if (udto.getTenDangNhap().length() < 6) {
	            thongbao.thongbao("tên đăng nhập lớn hơn 6 ký tự", "thông báo");
	            return false;
	        }
	        if (udto.getMk().length() < 6) {
	            thongbao.thongbao("mật khẩu lớn hơn 6 ký tự", "thông báo");
	            return false;
	        }
	        udto.setQuyen(2);
	        DAL.dangKyDAL.dangKy(udto);
	        return true;
	    }
}
