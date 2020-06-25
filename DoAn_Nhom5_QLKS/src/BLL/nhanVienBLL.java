package BLL;

import java.util.ArrayList;

import DAL.nhanVienDAL;
import DTO.nhanVienDTO;

public class nhanVienBLL {
	nhanVienDAL nvdal = new nhanVienDAL();
	public ArrayList<nhanVienDTO> getAllNV() {
		return nvdal.getAllNV();
	}
	public ArrayList<nhanVienDTO> getNVById(nhanVienDTO nvdto){
		return nvdal.getNVById(nvdto);
	}
	public int updateNV(nhanVienDTO nvdto) {
		return nvdal.updateNV(nvdto);
	}
	public int deleteNV(nhanVienDTO nvdto) {
		return nvdal.deleteNV(nvdto);
	}
	public int insertNV(nhanVienDTO nvdto) {
		return nvdal.insertNV(nvdto);
	}
}
