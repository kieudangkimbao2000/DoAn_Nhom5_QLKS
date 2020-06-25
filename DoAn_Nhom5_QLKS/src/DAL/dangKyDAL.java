package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.userDTO;
import GUI.thongbao;
import UTILS.DBUTILS;

public class dangKyDAL {
	private DBUTILS dbutils = null;
	private Connection conn = null;
	
	private PreparedStatement ps = null;
	
	private ResultSet rs = null;
	public static int dangKy(userDTO udto) {
        userDAL udal = new userDAL();
        int kq = udal.insertUser(udto);
        if (kq > 0) {
            thongbao.thongbao("đăng ký thành công", "thông báo");
        } else {
            thongbao.thongbao("đăng ký không thành công", "thông báo");
        }
        return kq;
	}
	public ResultSet ktTKTonTai() {
		String sql = "select * from user";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
}
