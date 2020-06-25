package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.hoaDonDTO;
import UTILS.DBUTILS;

public class hoaDonDAL {
	private DBUTILS dbutils = null;
	private Connection conn = null;
	
	private PreparedStatement ps = null;
	
	private ResultSet rs = null;
	
	//xuat toan bo hoa don
	public ArrayList<hoaDonDTO> getAllHD(){
		ArrayList<hoaDonDTO> result = new ArrayList<hoaDonDTO>();
		String sql = "select * from hoadon";
		
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				hoaDonDTO hddto = new hoaDonDTO();
				hddto.setIdHD(rs.getInt("IDHD"));
				hddto.setIdDP(rs.getString("IDDP"));
				hddto.setTong(rs.getString("TONG"));
				hddto.setTrangThai(rs.getString("trangThai"));
				result.add(hddto);
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
	//Lay hoa don theo id
	public ArrayList<hoaDonDTO> getHDById(hoaDonDTO hddto){
		ArrayList<hoaDonDTO> result = new ArrayList<hoaDonDTO>();
		String sql = "select * from hoadon where IDHD=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hddto.getIdHD());
			rs = ps.executeQuery();
			while(rs.next()) {
				hoaDonDTO hddto1 = new hoaDonDTO();
				hddto1.setIdHD(rs.getInt("IDHD"));
				hddto1.setIdDP(rs.getString("IDDP"));
				hddto1.setTong(rs.getString("TONG"));
				result.add(hddto1);
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
	//cap nhat hoa don
	public int updateTrangThaiHD(hoaDonDTO hddto) {
		int result = 0;
		String sql = "update hoadon set trangThai=? where IDHD=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, hddto.getTrangThai());
			ps.setInt(2, hddto.getIdHD());
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
	//xoa hoa don
	public int deleteHD(hoaDonDTO hddto) {
		int result = 0;
		String sql = "delete from hoadon where IDHD=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hddto.getIdHD());
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
	//them hoa don
	public int insertHD(hoaDonDTO hddto) {
		int result = 0;
		String sql = "insert into hoadon(IDDP, TONG, trangThai) values(?, ?, ?)";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, hddto.getIdDP());
			ps.setString(2, hddto.getTong());
			ps.setString(3, hddto.getTrangThai());
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
	public int updateHD(hoaDonDTO hddto) {
		int result = 0;
		String sql = "update hoadon set IDDP=?, TONG=?, trangThai=? where IDHD=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, hddto.getIdDP());
			ps.setString(2, hddto.getTong());
			ps.setString(3, hddto.getTrangThai());
			ps.setInt(4, hddto.getIdHD());
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
	//lay hoa don theo id tra ve ResultSet
	public ResultSet getHDById_RS(hoaDonDTO hddto){
		String sql = "select * from hoadon where IDHD=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hddto.getIdHD());
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
