package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BLL.hoaDonBLL;
import BLL.xuatHD;
import DTO.hoaDonDTO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class hoaDon1 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_tim;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hoaDon1 frame = new hoaDon1();
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
	public hoaDon1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Hoa don");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		hoaDonBLL hdbll = new hoaDonBLL();
		ArrayList<hoaDonDTO> al = new ArrayList<hoaDonDTO>();
		al = hdbll.getAllHD();
		Object[][] obj = new Object[al.size()][];
		int i = 0;
		for(hoaDonDTO dpdto : al) {
			obj[i] = new Object[4];
			obj[i][0] = dpdto.getIdHD();
			obj[i][1] = dpdto.getIdDP();
			obj[i][2] = dpdto.getTong();
			obj[i][3] = dpdto.getTrangThai();
			i++;
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			obj,
			new String[] {
				"Ma HD", "Ma DP", "Tong", "Trang thai"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		tf_tim = new JTextField();
		panel_3.add(tf_tim);
		tf_tim.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JButton btn_them = new JButton("Them");
		btn_them.setIcon(new ImageIcon(hoaDon1.class.getResource("/hinh/thêm.jpg")));
		btn_them.setBackground(Color.WHITE);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_them.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				themSuaHD.xuly="them";
				themSuaHD frame = new themSuaHD();
				frame.setLocationRelativeTo(null);
				dispose();
				frame.setVisible(true);
			}
			
		});
		panel_4.add(btn_them);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		JButton btn_sua = new JButton("Sua");
		btn_sua.setIcon(new ImageIcon(hoaDon1.class.getResource("/hinh/sửa.png")));
		btn_sua.setBackground(Color.WHITE);
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_sua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(table.getSelectedRowCount()!=1) {
					thongbao.thongbao("Chon 1 hoa don", "Thong bao");
				}else {
					int vitri = table.getSelectedRow();
					int maHD = Integer.parseInt(table.getValueAt(vitri, 0).toString());
					themSuaHD.maHD=maHD;
					themSuaHD.xuly="sua";
					themSuaHD frame = new themSuaHD();
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
		btn_xoa.setIcon(new ImageIcon(hoaDon1.class.getResource("/hinh/xóa.png")));
		btn_xoa.setBackground(Color.WHITE);
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.add(btn_xoa);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JButton btn_in = new JButton("In");
		btn_in.setIcon(new ImageIcon(hoaDon1.class.getResource("/hinh/print.png")));
		btn_in.setBackground(Color.WHITE);
		btn_in.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_in.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(table.getSelectedRowCount()!=1) {
					thongbao.thongbao("Chon 1 hoa don", "Thong bao");
				}else {
					int vitri = table.getSelectedRow();
					int idHD =Integer.parseInt(table.getValueAt(vitri, 0).toString());
					int idDP =Integer.parseInt(table.getValueAt(vitri, 1).toString());
					int tong =Integer.parseInt(table.getValueAt(vitri, 2).toString());
					hoaDonDTO hddto = new hoaDonDTO();
					hddto.setIdHD(idHD);
					hddto.setIdDP(String.valueOf(idDP));
					hddto.setTong(String.valueOf(tong));
					hddto.setTrangThai("Da in");
					xuatHD xhd = new xuatHD();
					xhd.noiDung(hddto);
				}
			}
			
		});
		panel_7.add(btn_in);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		JButton btn_tl = new JButton("Tro lai");
		btn_tl.setIcon(new ImageIcon(hoaDon1.class.getResource("/hinh/93634.png")));
		btn_tl.setBackground(Color.WHITE);
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
		panel_8.add(btn_tl);
	}

}
