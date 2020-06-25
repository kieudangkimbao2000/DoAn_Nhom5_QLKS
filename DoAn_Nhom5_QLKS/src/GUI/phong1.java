package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BLL.phongBLL;
import DTO.phongDTO;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;

public class phong1 extends JFrame {

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
					phong1 frame = new phong1();
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
	public phong1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Phong");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		phongBLL pbll = new phongBLL();
		ArrayList<phongDTO> al = new ArrayList<phongDTO>();
		al = pbll.getALLP();
		Object[][] obj = new Object[al.size()][];
		int i = 0;
		for(phongDTO pdto : al) {
			obj[i] = new Object[5];
			obj[i][0] = pdto.getTenP();
			obj[i][1] = pdto.getLoaiP();
			obj[i][2] = pdto.getSoNguoi();
			obj[i][3] = pdto.getGia();
			obj[i][4] = pdto.getTrangThai();
			i++;
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			obj,
			new String[] {
				"Ten phong", "Loai phong", "So nguoi", "Gia", "Trang thai"
			}
		));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
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
				
				phongBLL pbll = new phongBLL();
				ArrayList<phongDTO> al = new ArrayList<phongDTO>();
				al = pbll.timKiemP(tuKhoa);
				Object[][] obj = new Object[al.size()][];
				int i = 0;
				for(phongDTO pdto : al) {
					obj[i] = new Object[5];
					obj[i][0] = pdto.getTenP();
					obj[i][1] = pdto.getLoaiP();
					obj[i][2] = pdto.getSoNguoi();
					obj[i][3] = pdto.getGia();
					obj[i][4] = pdto.getTrangThai();
					i++;
				}
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					obj,
					new String[] {
						"Ten phong", "Loai phong", "So nguoi", "Gia", "Trang thai"
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
		btn_them.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				themSuaP.xuly="them";
				themSuaP tsp = new themSuaP();
				tsp.setLocationRelativeTo(null);
				tsp.setVisible(true);
			}
			
		});
		panel_4.add(btn_them);
		btn_them.setIcon(new ImageIcon(phong1.class.getResource("/hinh/thêm.jpg")));
		btn_them.setBackground(Color.WHITE);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		JButton btn_sua = new JButton("Sua");
		btn_sua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedRowCount()!=1) {
					thongbao.thongbao("Chon 1 phong", "Thong bao");
				}else {
					int vitri = table.getSelectedRow();
					dispose();
					String tenP = table.getValueAt(vitri, 0).toString();	
					themSuaP.tenP = tenP;
					themSuaP.xuly="sua";
					themSuaP tsp = new themSuaP();
					tsp.setLocationRelativeTo(null);
					tsp.setVisible(true);
				}
			}
			
		});
		panel_5.add(btn_sua);
		btn_sua.setIcon(new ImageIcon(phong1.class.getResource("/hinh/sửa.png")));
		btn_sua.setBackground(Color.WHITE);
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JButton btn_xoa = new JButton("Xoa");
		btn_xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(table.getSelectedRowCount()!=1) {
					thongbao.thongbao("Chon 1 phong", "Thong bao");
				}else {
					int vitri = table.getSelectedRow();
					String tenP = table.getValueAt(vitri, 0).toString();
					phongDTO pdto = new phongDTO();
					pdto.setTenP(tenP);
					phongBLL pbll = new phongBLL();
					int kq = 0;
					kq = pbll.deletePhong(pdto);
					if(kq != 0) {
						thongbao.thongbao("Xoa thanh cong", "Thong bao");
						dispose();
						phong1 frame = new phong1();
						frame.setLocationRelativeTo(null);
						frame.setSize(650, 550);
						frame.setVisible(true);
					}
				}
			}
			
		});
		panel_6.add(btn_xoa);
		btn_xoa.setIcon(new ImageIcon(phong1.class.getResource("/hinh/xóa.png")));
		btn_xoa.setBackground(Color.WHITE);
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JButton btn_dp = new JButton("Dat phong");
		btn_dp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(table.getSelectedRowCount()!=1) {
					thongbao.thongbao("Chon 1 phong", "Thong bao");
				}else {
					int vitri = table.getSelectedRow();
					String trangThai = table.getValueAt(vitri, 4).toString();
					if(trangThai=="Da thue") {
						thongbao.thongbao("Phong da thue", "Thong bao");
						return;
					}else {
						dispose();
						String tenP = table.getValueAt(vitri, 0).toString();
						phieuThue1.tenP = tenP;
						phieuThue1 frame = new phieuThue1();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					}
				}
			}
			
		});
		panel_7.add(btn_dp);
		btn_dp.setIcon(new ImageIcon(phong1.class.getResource("/hinh/tải xuống (1).jpg")));
		btn_dp.setBackground(Color.WHITE);
		btn_dp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		JButton btn_tl = new JButton("Tro lai");
		btn_tl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_tl.setBackground(Color.WHITE);
		btn_tl.setIcon(new ImageIcon(phong1.class.getResource("/hinh/93634.png")));
		btn_tl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
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
