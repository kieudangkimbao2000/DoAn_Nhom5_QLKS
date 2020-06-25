package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UTILS.DBUTILS;
import DTO.khachDTO;
import DTO.phongDTO;

public class khachDAL {
	private DBUTILS dbutils = null;
	private Connection conn = null;
	
	private PreparedStatement ps = null;
	
	private ResultSet rs = null;
	//xuat toan bo khach
	public ArrayList<khachDTO> getAllK(){
		ArrayList<khachDTO> result = new ArrayList<khachDTO>();
		String sql = "select * from khach";
		
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				khachDTO kdto = new khachDTO();
				kdto.setIdK(rs.getInt("IDK"));
				kdto.setHTK(rs.getString("HTK"));
				kdto.setGTK(rs.getString("GTK"));
				kdto.setSDT(rs.getString("SDT"));
				kdto.setCMNDK(rs.getString("CMNDK"));
				kdto.setCard(rs.getString("CARD"));
				kdto.setQuocTich(rs.getString("QT"));
				result.add(kdto);
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
	//lay khach theo id
	public ResultSet getKhachById(khachDTO kdto){
		String sql = "select * from khach where IDK=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, kdto.getIdK());
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//cap nhat khach
	public int updateKhach(khachDTO kdto) {
		int result = 0;
		String sql = "update khach set HTK=?, GTK=?, SDT=?, CMNDK=?, CARD=?, QT=? where IDK=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(7, kdto.getIdK());
			ps.setString(1, kdto.getHTK());
			ps.setString(2, kdto.getGTK());
			ps.setString(3, kdto.getSDT());
			ps.setString(4, kdto.getCMNDK());
			ps.setString(5, kdto.getCard());
			ps.setString(6, kdto.getQuocTich());
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
	//xoa khach
	public int deleteKhach(khachDTO kdto) {
		int result = 0;
		String sql = "delete from khach where IDK=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,kdto.getIdK());
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
	//them khach
	public int insertKhach(khachDTO kdto) {
		int result = 0;
		String sql = "insert into khach(HTK, GTK, SDT, CMNDK, CARD, QT) values(?, ?, ?, ?, ?, ?)";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, kdto.getHTK());
			ps.setString(2, kdto.getGTK());
			ps.setString(3, kdto.getSDT());
			ps.setString(4, kdto.getCMNDK());
			ps.setString(5, kdto.getCard());
			ps.setString(6, kdto.getQuocTich());
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
	public int getIdByCMND(khachDTO kdto) {
		String sql = "select IDK from khach where CMNDK=?";
		int id = 0;
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, kdto.getCMNDK());
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("IDK");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public void timKiem(String tuKhoa) {
		
	}
	public ArrayList<khachDTO> timKiemK(String tuKhoa){
		ArrayList<khachDTO> result = new ArrayList<khachDTO>();
		String sql = "select * from khach where HTK like ? or GTK like ? or SDT like ? or CMNDK like ? or CARD like ? or QT like ?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tuKhoa);
			ps.setString(2, tuKhoa);
			ps.setString(3, tuKhoa);
			ps.setString(4, tuKhoa);
			ps.setString(5, tuKhoa);
			ps.setString(6, tuKhoa);
			rs = ps.executeQuery();
			while(rs.next()) {
				khachDTO kdto = new khachDTO();
				kdto.setHTK(rs.getString("HTK"));
				kdto.setGTK(rs.getString("GTK"));
				kdto.setSDT(rs.getString("SDT"));
				kdto.setCMNDK(rs.getString("CMNDK"));
				kdto.setCard(rs.getString("CARD"));
				kdto.setQuocTich(rs.getString("QT"));
				result.add(kdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public ResultSet getKhachById(int maK){
		String sql = "select * from khach where IDK=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maK);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
