package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BLL.khachBLL;
import BLL.phongBLL;
import DTO.khachDTO;
import DTO.phongDTO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class khach1 extends JFrame {

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
					khach1 frame = new khach1();
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
	public khach1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Khach");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBackground(Color.BLACK);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		khachBLL kbll = new khachBLL();
		ArrayList<khachDTO> al = new ArrayList<khachDTO>();
		al = kbll.getAllK();
		Object[][] obj = new Object[al.size()][];
		int i = 0;
		for(khachDTO kdto : al) {
			obj[i] = new Object[7];
			obj[i][0] = kdto.getIdK();
			obj[i][1] = kdto.getHTK();
			obj[i][2] = kdto.getGTK();
			obj[i][3] = kdto.getSDT();
			obj[i][4] = kdto.getCMNDK();
			obj[i][5] = kdto.getCard();
			obj[i][6] = kdto.getQuocTich();
			i++;
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			obj,
			new String[] {
				"Ma khach", "Ho va ten", "Gioi tinh", "SDT", "CMND", "Card", "QT"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));
		
		JPanel panel_3 = new JPanel();;
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
				
				khachBLL kbll = new khachBLL();
				ArrayList<khachDTO> al = new ArrayList<khachDTO>();
				al = kbll.timKiemK(tuKhoa);
				Object[][] obj = new Object[al.size()][];
				int i = 0;
				for(khachDTO kdto : al) {
					obj[i] = new Object[7];
					obj[i][0] = kdto.getIdK();
					obj[i][1] = kdto.getHTK();
					obj[i][2] = kdto.getGTK();
					obj[i][3] = kdto.getSDT();
					obj[i][4] = kdto.getCMNDK();
					obj[i][5] = kdto.getCard();
					obj[i][6] = kdto.getQuocTich();
					i++;
				}
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					obj,
					new String[] {
						"Ma khach", "Ho va ten", "Gioi tinh", "SDT", "CMND", "Card", "QT"
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
		btn_them.setBackground(Color.WHITE);
		btn_them.setIcon(new ImageIcon(khach1.class.getResource("/hinh/thêm.jpg")));
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_them.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				themSuaK.xuly="them";
				themSuaK tsk = new themSuaK();
				tsk.setLocationRelativeTo(null);
				dispose();
				tsk.setVisible(true);
			}
			
		});
		panel_4.add(btn_them);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		JButton btn_sua = new JButton("Sua");
		btn_sua.setBackground(Color.WHITE);
		btn_sua.setIcon(new ImageIcon(khach1.class.getResource("/hinh/sửa.png")));
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_sua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedRowCount()!=1) {
					thongbao.thongbao("Chon khach muon sua", "Thong bao");
				}else {
				int vitri = table.getSelectedRow();
				int maKhach = Integer.parseInt(table.getValueAt(vitri, 0).toString());
				themSuaK.xuly="sua";
				themSuaK.maKhach = maKhach; 
				themSuaK tsk = new themSuaK();
				tsk.setLocationRelativeTo(null);
				dispose();
				tsk.setVisible(true);
				}
			}
			
		});
		panel_5.add(btn_sua);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JButton btn_xoa = new JButton("Xoa");
		btn_xoa.setBackground(Color.WHITE);
		btn_xoa.setIcon(new ImageIcon(khach1.class.getResource("/hinh/xóa.png")));
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(table.getSelectedRowCount()!=1) {
					thongbao.thongbao("Chon 1 khach", "Thong bao");
				}else {
					int vitri = table.getSelectedRow();
					int maKhach = Integer.parseInt(table.getValueAt(vitri, 0).toString());
					khachDTO kdto = new khachDTO();
					kdto.setIdK(maKhach);
					khachBLL kbll =new khachBLL();
					int kq = 0;
					kq = kbll.deleteKhach(kdto);
					if(kq!=0) {
						thongbao.thongbao("Xoa thanh cong", "Thong bao");
						khach1 k = new khach1();
						k.setSize(650, 550);
						k.setLocationRelativeTo(null);
						dispose();
						k.setVisible(true);
					}else {
						thongbao.thongbao("Xoa that bai", "Thong bao");
					}
				}
			}
			
		});
		panel_6.add(btn_xoa);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JButton btn_tl = new JButton("Tro lai");
		btn_tl.setBackground(Color.WHITE);
		btn_tl.setIcon(new ImageIcon(khach1.class.getResource("/hinh/93634.png")));
		btn_tl.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		panel_7.add(btn_tl);
	}

}
