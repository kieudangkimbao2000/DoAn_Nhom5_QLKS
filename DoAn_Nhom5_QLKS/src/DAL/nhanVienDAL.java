package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.nhanVienDTO;
import UTILS.DBUTILS;

public class nhanVienDAL {
	private DBUTILS dbutils = null;
	private Connection conn = null;
	
	private PreparedStatement ps = null;
	
	private ResultSet rs = null;
	//xuat toan bo nhan vien
	public ArrayList<nhanVienDTO> getAllNV(){
		ArrayList<nhanVienDTO> result = new ArrayList<nhanVienDTO>();
		String sql = "select * from nhanvien";
		
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				nhanVienDTO nvdto = new nhanVienDTO();
				nvdto.setIdNV(rs.getInt("IDNV"));
				nvdto.setHTNV(rs.getString("HTNV"));
				nvdto.setGTNV(rs.getString("GTNV"));
				nvdto.setNS(rs.getString("NS"));
				nvdto.setDC(rs.getString("DC"));
				nvdto.setCMNDNV(rs.getString("CMNDNv"));
				nvdto.setSDTNV(rs.getString("SDTNV"));
				nvdto.setChucVu(rs.getString("CV"));
				nvdto.setNgayDiLam(rs.getString("NGAYDILAM"));
				nvdto.setMucLuong(rs.getDouble("ML"));
				result.add(nvdto);
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
	//lay nahn vien theo id
	public ArrayList<nhanVienDTO> getNVById(nhanVienDTO nvdto){
		ArrayList<nhanVienDTO> result = new ArrayList<nhanVienDTO>();
		String sql = "select * from nhanvien where IDNV=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nvdto.getIdNV());
			rs = ps.executeQuery();
			while(rs.next()) {
				nhanVienDTO nvdto1 = new nhanVienDTO();
				nvdto1.setIdNV(rs.getInt("IDNV"));
				nvdto1.setHTNV(rs.getString("HTNV"));
				nvdto1.setGTNV(rs.getString("GTNV"));
				nvdto1.setNS(rs.getString("NS"));
				nvdto1.setDC(rs.getString("DC"));
				nvdto1.setCMNDNV(rs.getString("CMNDNV"));
				nvdto1.setSDTNV(rs.getString("SDTNV"));
				nvdto1.setChucVu(rs.getString("CV"));
				nvdto1.setNgayDiLam(rs.getString("NGAYDILAM"));
				nvdto1.setMucLuong(rs.getDouble("ML"));
				result.add(nvdto1);
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
	//cap nhat nhan vien
	public int updateNV(nhanVienDTO nvdto) {
		int result = 0;
		String sql = "update nhanvien set IDNV=? HTNV=? GTNV=? NS=? DC=? CMNDNV=? SDTNV=? CV=? NGAYDILAM=? ML=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nvdto.getIdNV());
			ps.setString(2, nvdto.getHTNV());
			ps.setString(3, nvdto.getGTNV());
			ps.setString(4, nvdto.getNS());
			ps.setString(5, nvdto.getDC());
			ps.setString(6, nvdto.getCMNDNV());
			ps.setString(7, nvdto.getSDTNV());
			ps.setString(8, nvdto.getChucVu());
			ps.setString(9, nvdto.getNgayDiLam());
			ps.setDouble(10, nvdto.getMucLuong());
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
	//xoa nhan vien
	public int deleteNV(nhanVienDTO nvdto) {
		int result = 0;
		String sql = "delete from nhanvien where IDNV=?";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,nvdto.getIdNV());
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
	//them nhan vien
	public int insertNV(nhanVienDTO nvdto) {
		int result = 0;
		String sql = "insert into nhanvien(HTNV, GTNV, NS, DC, CMNDNV, SDTNV, CV, NGAYDILAM, ML) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			dbutils = new DBUTILS();
			conn = dbutils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, nvdto.getHTNV());
			ps.setString(2, nvdto.getGTNV());
			ps.setString(3 , nvdto.getNS());
			ps.setString(4, nvdto.getDC());
			ps.setString(5, nvdto.getCMNDNV());
			ps.setString(6, nvdto.getSDTNV());
			ps.setString(7, nvdto.getChucVu());
			ps.setString(8, nvdto.getNgayDiLam());
			ps.setDouble(9, nvdto.getMucLuong());
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
}
