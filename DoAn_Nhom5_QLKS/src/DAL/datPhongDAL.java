package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DTO.datPhongDTO;
import UTILS.DBUTILS;

public class datPhongDAL {
	private DBUTILS dbutils = null;
	private Connection conn = null;
	
	private PreparedStatement ps = null;
	
	private ResultSet rs = null;
	//xuat toan bo dat phong
	public ArrayList<datPhongDTO> getAllDP(){
		ArrayList<datPhongDTO> result = new ArrayList<datPhongDTO>();
		String sql = "select * from datphong";
		
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				datPhongDTO dpdto = new datPhongDTO();
				dpdto.setIdDP(rs.getInt("idDP"));
				dpdto.setIdK(rs.getString("idK"));
				dpdto.setTenP(rs.getString("tenP"));
				dpdto.setIdNV(rs.getString("idNV"));
				dpdto.setNgayDen(rs.getString("ngayDen"));
				dpdto.setSoNgayThue(rs.getInt("soNgayThue"));
				result.add(dpdto);
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
	public ResultSet getDPById(datPhongDTO dpdto){
		String sql = "select * from datphong where idDP=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dpdto.getIdDP());
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//cap nhat khach
	public int updateDP(datPhongDTO dpdto) {
		int result = 0;
		String sql = "update datphong set idK=?, tenP=?, idNV=?, ngayDen=?, soNgayThue=? where idDP=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(6, dpdto.getIdDP());
			ps.setString(1, dpdto.getIdK());
			ps.setString(2 , dpdto.getTenP());
			ps.setString(3, dpdto.getIdNV());
			ps.setString(4, dpdto.getNgayDen());
			ps.setInt(5, dpdto.getSoNgayThue());
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
	public int deleteDP(datPhongDTO dpdto) {
		int result = 0;
		String sql = "delete from datphong where IDDP=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dpdto.getIdDP());
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
	public int insertDP(datPhongDTO dpdto) {
		int result = 0;
		String sql = "insert into datphong(IDK, TENP, IDNV, ngayDen, soNgayThue) values(?, ?, ?, ?, ?)";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,dpdto.getIdK());
			ps.setString(2, dpdto.getTenP());
			ps.setString(3, dpdto.getIdNV());
			ps.setString(4, dpdto.getNgayDen());
			ps.setInt(5, dpdto.getSoNgayThue());
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
	public ArrayList<datPhongDTO> timKiemDP(String tuKhoa){
		ArrayList<datPhongDTO> result = new ArrayList<datPhongDTO>();
		String sql = "select * from datphong where idK like ? or tenP like ? or idNV like ? or ngayDen like ?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tuKhoa);
			ps.setString(2, tuKhoa);
			ps.setString(3, tuKhoa);
			ps.setString(4, tuKhoa);
			rs = ps.executeQuery();
			while(rs.next()) {
				datPhongDTO dpdto = new datPhongDTO();
				dpdto.setIdDP(rs.getInt("idDP"));
				dpdto.setIdK(rs.getString("idK"));
				dpdto.setTenP(rs.getString("tenP"));
				dpdto.setIdNV(rs.getString("idNV"));
				dpdto.setNgayDen(rs.getString("ngayDen"));
				dpdto.setSoNgayThue(rs.getInt("soNgayThue"));
				result.add(dpdto);
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
	public ResultSet getDPById(int maDP){
		String sql = "select * from datphong where idDP=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maDP);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
