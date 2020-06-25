package BLL;
import java.io.FileOutputStream;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import java.util.logging.Logger;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import org.apache.poi.xwpf.usermodel.XWPFRun;

import DAL.datPhongDAL;
import DAL.hoaDonDAL;
import DAL.khachDAL;
import DTO.datPhongDTO;
import DTO.hoaDonDTO;
import DTO.khachDTO;
import GUI.thongbao;
public class xuatHD {
	datPhongDAL dpdal = new datPhongDAL();
	khachDAL kdal = new khachDAL();
	hoaDonDAL hddal = new hoaDonDAL();
	public void noiDung(hoaDonDTO hddto) {
		hddal.updateTrangThaiHD(hddto);
		try {
			//Khởi tạo đối tượng
			XWPFDocument document = new XWPFDocument();
			//Tạo tiêu đề
			 XWPFParagraph titleGraph = document.createParagraph();

	            titleGraph.setAlignment(ParagraphAlignment.CENTER);

	            String title = "Hóa đơn";

	            XWPFRun titleRun = titleGraph.createRun();

	            titleRun.setBold(true);

	            titleRun.setText(title);
	            //Tạo văn bảng
	            XWPFParagraph para1 = document.createParagraph();

	            para1.setAlignment(ParagraphAlignment.BOTH);
	            
	            String noiDung = null;
	    		datPhongDTO dpdto = new datPhongDTO();
	    		dpdto.setIdDP(Integer.parseInt(hddto.getIdDP()));
	    		ResultSet rsdp = dpdal.getDPById(dpdto);
	    		try {
	    			while(rsdp.next()) {
	    				khachDTO kdto = new khachDTO();
	    				kdto.setIdK(rsdp.getInt("idK"));
	    				ResultSet rsk = kdal.getKhachById(kdto);
	    				while(rsk.next()) {
	    					noiDung = "Tên khách:"+rsk.getString("HTK")+"\n";
	    					noiDung +="Giới tính:"+rsk.getString("GTK")+"\n";
	    					noiDung +="SDT:"+rsk.getString("SDT")+"\n";
	    					noiDung +="CMND:"+rsk.getString("CMNDK")+"\n";
	    					noiDung +="Card:"+rsk.getString("CARD")+"\n";
	    					noiDung +="Quốc tịch:"+rsk.getString("QT")+"\n";
	    					noiDung +="Tên phòng:"+rsdp.getString("tenP")+"\n";
	    					noiDung +="Ngày đến:"+rsdp.getString("ngayDen")+"\n";
	    					noiDung +="Số ngày thuê:"+rsdp.getString("soNgayThue")+"\n";
	    					noiDung +="Tổng:"+hddto.getTong();
	    					
	    				}
	    			}
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		  XWPFRun para1Run = para1.createRun();             
	              para1Run.setText(noiDung);
	              //Ghi dữ liệu ra file
	              FileOutputStream out = new FileOutputStream("filedocx/thongTinHD.docx");

	              document.write(out);

	              out.close();

	              document.close();
	              thongbao.thongbao("Xuat hoa don thanh cong", "Thong bao");
		}catch (IOException ex){
			Logger.getLogger(xuatHD.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
