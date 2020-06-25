package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.userDTO;
import GUI.thongbao;
import UTILS.DBUTILS;

public class doiMKDAL {
	private DBUTILS dbutils = null;
	private Connection conn = null;
	
	private PreparedStatement ps = null;
	
	private ResultSet rs = null;
	public ResultSet getUserById(userDTO udto) {
		String sql = "select * from user where IDUSER=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, udto.getIdUser());
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int updateMKUser(userDTO udto, String mk) {
		int result = 0;
		String sql = "update user set MK=? where IDUSER=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mk);
			ps.setInt(2, udto.getIdUser());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result > 0) {
			thongbao.thongbao("Đổi mật khẩu thành công!", "Thông báo");
		}else {
			thongbao.thongbao("Có lỗi xảy ra!", "Thông báo");
		}
		return result;
	}
}
