package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;

import BLL.datPhongBLL;
import BLL.phongBLL;
import BLL.traPhongBLL;
import DTO.datPhongDTO;
import DTO.hoaDonDTO;
import DTO.phongDTO;

import javax.swing.ImageIcon;

public class datPhong1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tf_tim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					datPhong1 frame = new datPhong1();
					frame.setLocationRelativeTo(null);
					frame.setSize(650, 550);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public datPhong1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		datPhongBLL dpbll = new datPhongBLL();
		ArrayList<datPhongDTO> al = new ArrayList<datPhongDTO>();
		al = dpbll.getAllDP();
		Object[][] obj = new Object[al.size()][];
		int i = 0;
		for(datPhongDTO dpdto : al) {
			obj[i] = new Object[6];
			obj[i][0] = dpdto.getIdDP();
			obj[i][1] = dpdto.getIdK();
			obj[i][2] = dpdto.getTenP();
			obj[i][3] = dpdto.getIdNV();
			obj[i][4] = dpdto.getNgayDen();
			obj[i][5] = dpdto.getSoNgayThue();
			i++;
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			obj,
			new String[] {
				"Ma DP", "Ma khach", "Ten phong", "Ma NV", "Ngay den", "So ngay thue"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Dat phong");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		tf_tim = new JTextField();
		tf_tim.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				remove(table);
				String tuKhoa = "%"+tf_tim.getText()+"%";
				
				datPhongBLL dpbll = new datPhongBLL();
				ArrayList<datPhongDTO> al = new ArrayList<datPhongDTO>();
				al = dpbll.timKiemDP(tuKhoa);
				Object[][] obj = new Object[al.size()][];
				int i = 0;
				for(datPhongDTO dpdto : al) {
					obj[i] = new Object[6];
					obj[i][0] = dpdto.getIdDP();
					obj[i][1] = dpdto.getIdK();
					obj[i][2] = dpdto.getTenP();
					obj[i][3] = dpdto.getIdNV();
					obj[i][4] = dpdto.getNgayDen();
					obj[i][5] = dpdto.getSoNgayThue();
					i++;
				}
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					obj,
					new String[] {
						"Ma DP", "Ma khach", "Ten phong", "Ma NV", "Ngay den", "So ngay thue"
					}
				));
				scrollPane.setViewportView(table);
				
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(tf_tim);
		tf_tim.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JButton btn_them = new JButton("Them");
		btn_them.setIcon(new ImageIcon(datPhong1.class.getResource("/hinh/thêm.jpg")));
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_them.setBackground(Color.WHITE);
		btn_them.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				themSuaDP.xuly="them";
				themSuaDP frame = new themSuaDP();
				frame.setLocationRelativeTo(null);
				dispose();
				frame.setVisible(true);
			}
			
		});
		panel_4.add(btn_them);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		JButton btn_sua = new JButton("Sua");
		btn_sua.setIcon(new ImageIcon(datPhong1.class.getResource("/hinh/sửa.png")));
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_sua.setBackground(Color.WHITE);
		btn_sua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedRowCount()!=1) {
					thongbao.thongbao("Chon 1 dat phong", "Thong bao");
				}else {
					int vitri = table.getSelectedRow();
					int maDP = Integer.parseInt(table.getValueAt(vitri, 0).toString());
					themSuaDP.xuly="sua";
					themSuaDP.maDP=maDP;
					themSuaDP frame = new themSuaDP();
					frame.setLocationRelativeTo(null);
					dispose();
					frame.setVisible(true);
				}
			}
			
		});
		panel_5.add(btn_sua);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JButton btn_xoa = new JButton("Xoa");
		btn_xoa.setIcon(new ImageIcon(datPhong1.class.getResource("/hinh/xóa.png")));
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_xoa.setBackground(Color.WHITE);
		btn_xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(table.getSelectedRowCount()!=1) {
					thongbao.thongbao("Chon 1 dat phong", "Thong bao");
				}else {
					int vitri = table.getSelectedRow();
					int maDP = Integer.parseInt(table.getValueAt(vitri, 0).toString());
					datPhongDTO dpdto = new datPhongDTO();
					dpdto.setIdDP(maDP);
					int kq = 0;
					datPhongBLL dpbll = new datPhongBLL();
					kq = dpbll.deleteDP(dpdto);
					if(kq==0) {
						thongbao.thongbao("Xoa dat phong that bai", "Thong bao");
					}else {
						thongbao.thongbao("Xoa dat phong thanh cong", "Thong bao");
						datPhong1 frame = new datPhong1();
						frame.setLocationRelativeTo(null);
						frame.setSize(650,  550);
						dispose();
						frame.setVisible(true);
					}
				}
			}
			
		});
		panel_6.add(btn_xoa);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JButton btn_tp = new JButton("Tra phong");
		btn_tp.setIcon(new ImageIcon(datPhong1.class.getResource("/hinh/pngtree-vector-payment-icon-png-image_4142914.jpg")));
		btn_tp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_tp.setBackground(Color.WHITE);
		btn_tp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(table.getSelectedRowCount()!=1) {
					thongbao.thongbao("Chon 1 dong dat phong", "Thong bao");
				}else {
					phongBLL pbll = new phongBLL();
					int vitri = table.getSelectedRow();
					int iddp =Integer.parseInt(table.getValueAt(vitri, 0).toString());
					String tenP = table.getValueAt(vitri, 2).toString();
					int soNgay = Integer.parseInt(table.getValueAt(vitri, 5).toString());
					phongDTO pdto = new phongDTO();
					pdto.setTenP(tenP);
					pdto.setTrangThai("Trong");
					ResultSet rs = pbll.getPhongByName(pdto);
					int gia = 0;
					int tong = 0;
					try {
						while(rs.next()) {
							gia = rs.getInt("gia");
							tong = gia*soNgay;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					hoaDonDTO hddto = new hoaDonDTO();
					hddto.setIdDP(String.valueOf(iddp));
					hddto.setTong(String.valueOf(tong));
					hddto.setTrangThai("Chua in");
					traPhongBLL tpbll = new traPhongBLL();
					boolean kq = tpbll.traPhong(pdto, hddto);
				}
			}
			
		});
		panel_7.add(btn_tp);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		JButton btn_tl = new JButton("Tro lai");
		btn_tl.setIcon(new ImageIcon(datPhong1.class.getResource("/hinh/93634.png")));
		btn_tl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_tl.setBackground(Color.WHITE);
		btn_tl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				main1 frame = new main1();
				frame.setLocationRelativeTo(null);
				frame.setSize(1000, 600);
				frame.setVisible(true);
			}
			
		});
		panel_8.add(btn_tl);
	}

}
