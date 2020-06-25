package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.userDTO;
import UTILS.DBUTILS;

public class userDAL {
	private DBUTILS dbutils = null;
	private Connection conn = null;
	
	private PreparedStatement ps = null;
	
	private ResultSet rs = null;
	
	//xuat toan bo user
	public ArrayList<userDTO> getAllU(){
		ArrayList<userDTO> result = new ArrayList<userDTO>();
		String sql = "select * from user";
		
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				userDTO udto = new userDTO();
				udto.setIdUser(rs.getInt("IDUSER"));
				udto.setTenDangNhap(rs.getString("HOVATEN"));
				udto.setMk(rs.getString("MK"));
				udto.setHoVaTen(rs.getString("HOVATEN"));
				udto.setEmail(rs.getString("EMAIL"));
				udto.setQuyen(rs.getInt("QUYEN"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	//Lay user theo id
	public ArrayList<userDTO> getUserById(userDTO udto){
		ArrayList<userDTO> result = new ArrayList<userDTO>();
		String sql = "select * from user where IDUSER=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, udto.getIdUser());
			rs = ps.executeQuery();
			while(rs.next()) {
				userDTO udto1 = new userDTO();
				udto1.setIdUser(rs.getInt("IDUSER"));
				udto1.setTenDangNhap(rs.getString("TENDANGNHAP"));
				udto1.setMk(rs.getString("MK"));
				udto1.setHoVaTen(rs.getString("HOVATEN"));
				udto1.setEmail(rs.getString("EMAIL"));
				udto1.setQuyen(rs.getInt("QUYEN"));
				result.add(udto1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	//cap nhat user
	public int updateUser(userDTO udto) {
		int result = 0;
		String sql = "update user set IDUSER=? TENDANGNHAP=? MK=? HOVATEN=? EMAIL=? QUYEN=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, udto.getIdUser());
			ps.setString(2, udto.getTenDangNhap());
			ps.setString(3, udto.getMk());
			ps.setString(4, udto.getHoVaTen());
			ps.setString(5, udto.getEmail());
			ps.setInt(6, udto.getQuyen());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}
	//xoa user
	public int deleteUser(userDTO udto) {
		int result = 0;
		String sql = "delete from user where IDUSER=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, udto.getIdUser());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	//them 
	public int insertUser(userDTO udto) {
		int result = 0;
		String sql = "insert into user(TENDANGNHAP, MK, HOVATEN, EMAIL, QUYEN) values(?, ?, ?, ?, ?)";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, udto.getTenDangNhap());
			ps.setString(2, udto.getMk());
			ps.setString(3, udto.getHoVaTen());
			ps.setString(4, udto.getEmail());
			ps.setInt(5, udto.getQuyen());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {	
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public ResultSet getUserById(int maTK){
		String sql = "select * from user where IDUSER=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maTK);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
