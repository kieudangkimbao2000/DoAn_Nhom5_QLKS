package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAL.dangNhapDAL;
import DTO.userDTO;
import GUI.thongbao;

public class dangNhapBLL {

	static dangNhapDAL dndal = new dangNhapDAL();
	public static boolean kiemTraDN(userDTO udto) {
		if(udto.getTenDangNhap().equals("") || udto.getMk().equals("")) {
			thongbao.thongbao("Dien day du thong tin", "Thong bao");
			return false;
		}
		ResultSet rs = dndal.kiemTraDN(udto);
		try {
			if(!rs.next()) {
				thongbao.thongbao("Tai khoan khong ton tai", "Thong bao");
				return false;
			}else if(rs.getString("MK").equals(udto.getMk())) {
				udto.setIdUser(rs.getInt("IDUSER"));
				udto.setTenDangNhap(rs.getString("TENDANGNHAP"));
				udto.setMk(rs.getString("MK"));
				udto.setHoVaTen(rs.getString("HOVATEN"));
				udto.setEmail(rs.getString("EMAIL"));
				GUI.dangNhap1.iduser=rs.getInt("IDUSER");
				GUI.dangNhap1.quyen=rs.getInt("QUYEN");
				GUI.main1.tenTK = rs.getString("TENDANGNHAP");
			}else {
				thongbao.thongbao("Mat khau khong chinh xac", "Thong bao");
				return false;
			}
		}catch(SQLException e) {
			
		}
		return true;
	}
}
