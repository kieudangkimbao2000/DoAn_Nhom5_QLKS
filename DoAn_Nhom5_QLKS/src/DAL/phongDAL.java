package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import UTILS.DBUTILS;
import DTO.phongDTO;
import GUI.thongbao;

public class phongDAL {
	private DBUTILS dbutils = null;
	private Connection conn = null;
	
	private PreparedStatement ps = null;
	
	private ResultSet rs = null;
	
	//xuat toan bo phong
	public ArrayList<phongDTO> getAllP(){
		ArrayList<phongDTO> result = new ArrayList<phongDTO>();
		String sql = "select * from phong";
		
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				phongDTO pdto = new phongDTO();
				pdto.setTenP(rs.getString("tenP"));
				pdto.setLoaiP(rs.getString("loaiP"));
				pdto.setSoNguoi(rs.getInt("soNguoi"));
				pdto.setGia(String.valueOf(rs.getInt("gia")));
				pdto.setTrangThai(rs.getString("trangThai"));
				result.add(pdto);
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
	//Lay phong theo id
	public ArrayList<phongDTO> getPhongById(phongDTO pdto){
		ArrayList<phongDTO> result = new ArrayList<phongDTO>();
		String sql = "select * from phong where tenP=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pdto.getTenP());
			rs = ps.executeQuery();
			while(rs.next()) {
				phongDTO pdto1 = new phongDTO();
				pdto1.setTenP(rs.getString("tenP"));
				pdto1.setLoaiP(rs.getString("loaiP"));
				pdto1.setSoNguoi(rs.getInt("soNguoi"));
				pdto1.setGia(String.valueOf(rs.getInt("gia")));
				pdto1.setTrangThai(rs.getString("trangThai"));
				result.add(pdto1);
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
	//cap nhat phong
	public int updatePhong(phongDTO pdto) {
		int result = 0;
		String sql = "update phong set tenP=?, gia=?, loaiP=?, trangThai=?, soNguoi=? where tenP=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pdto.getTenP());
			ps.setInt(2, Integer.parseInt(pdto.getGia()));
			ps.setString(3, pdto.getLoaiP());
			ps.setString(4, pdto.getTrangThai());
			ps.setInt(5, pdto.getSoNguoi());
			ps.setString(6, GUI.themSuaP.tenP);
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
	//xoa phong
	public int deletePhong(phongDTO pdto) {
		int result = 0;
		String sql = "delete from phong where TENP=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pdto.getTenP());
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
	//them phong
	public int insertPhong(phongDTO pdto) {
		int result = 0;
		String sql = "insert into phong(tenP, loaiP, soNguoi, gia, trangThai) values(?, ?, ?, ?, ?)";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pdto.getTenP());
			ps.setInt(4, Integer.parseInt(pdto.getGia()));
			ps.setString(2, pdto.getLoaiP());
			ps.setString(5, pdto.getTrangThai());
			ps.setInt(3, pdto.getSoNguoi());
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
	//cap nhat trang thai
	public int updateTrangThaiP(phongDTO pdto) {
		int result = 0;
		String sql = "update phong set trangThai=? where tenP=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pdto.getTrangThai());
			ps.setString(2, pdto.getTenP());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// lay theo ten phong
	public ResultSet getPhongByName(phongDTO pdto) {
		String sql = "select * from phong where tenP=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pdto.getTenP());
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet getAllP_RS() {
		String sql = "select * from phong";
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
	//tim kiem phong
	public ArrayList<phongDTO> timKiemP(String tuKhoa){
		ArrayList<phongDTO> result = new ArrayList<phongDTO>();
		String sql = "select * from phong where tenP like ? or loaiP like ? or trangThai like ?";
			try {
				dbutils = new DBUTILS();
				conn = dbutils.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, tuKhoa);
				ps.setString(2, tuKhoa);
				ps.setString(3, tuKhoa);
				rs = ps.executeQuery();
				while(rs.next()) {	
					phongDTO pdto = new phongDTO();
					pdto.setTenP(rs.getString("tenP"));
					pdto.setLoaiP(rs.getString("loaiP"));
					pdto.setSoNguoi(rs.getInt("soNguoi"));
					pdto.setGia(rs.getString("gia"));
					pdto.setTrangThai(rs.getString("trangThai"));
					result.add(pdto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	//lay phong theo ten tham so String
	public ResultSet getPhongByName(String tenP) {
		String sql = "select * from phong where tenP=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tenP);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
