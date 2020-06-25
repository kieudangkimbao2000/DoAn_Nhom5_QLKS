package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAL.doiMKDAL;
import DAL.userDAL;
import DTO.userDTO;
import GUI.thongbao;

public class doiMKBLL {
	public static boolean kiemTraDoiMK(userDTO udto,String mkc, String mkm,String nlmk) {
		doiMKDAL dmkdal = new doiMKDAL();
		ResultSet rs = dmkdal.getUserById(udto);
		try {
			while(rs.next()) {
				if(rs.getString("MK").equals(mkc)) {
				}else {
					thongbao.thongbao("Mật khẩu không chính xác!", "Thông báo");
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(mkc.trim().equals("")||mkm.trim().equals("")||nlmk.trim().equals("")) {
			thongbao.thongbao("Điền đầy đủ nội dung!", "Thông báo");
			return false;
		}
		if(!mkm.matches(nlmk)) {
			thongbao.thongbao("Nhập lại mật khẩu không trùng khớp!", "Thông báo");
			return false;
		}
		dmkdal.updateMKUser(udto, mkm);
		return true;
	}
}
