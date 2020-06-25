package BLL;

import DAL.datPhongDAL;
import DAL.hoaDonDAL;
import DAL.phongDAL;
import DTO.datPhongDTO;
import DTO.hoaDonDTO;
import DTO.phongDTO;
import GUI.thongbao;

public class traPhongBLL {
	datPhongDAL dpdal = new datPhongDAL();
	phongDAL pdal = new phongDAL();
	hoaDonDAL hddal = new hoaDonDAL();
	public boolean traPhong(phongDTO pdto, hoaDonDTO hddto) {
		int kq1 = pdal.updateTrangThaiP(pdto);
		int kq2 = hddal.insertHD(hddto);
		if(kq1 > 0 && kq2 > 0) {
			thongbao.thongbao("Trả phòng thành công", "Thông báo");
			return true;
		}
		thongbao.thongbao("Trả phòng thất bại", "Thông báo");
		return false;
	}
}
