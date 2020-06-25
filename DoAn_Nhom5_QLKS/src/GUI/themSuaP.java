package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.phongBLL;
import DAL.phongDAL;
import DTO.phongDTO;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JSpinner;

public class themSuaP extends JFrame {
	public static String tenP;
	public static String xuly;
	
	private JPanel contentPane;
	private JTextField tf_tenp;
	private JTextField tf_lp;
	private JTextField tf_gia;
	private JTextField tf_tt;
	private JSpinner s_sn ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					themSuaP frame = new themSuaP();
					frame.setLocationRelativeTo(null);
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
	public themSuaP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent evt) {
				if(dangNhap1.quyen>0) {
					tf_tenp.setEnabled(false);
					tf_lp.setEnabled(false);
					tf_gia.setEnabled(false);
					s_sn.setEnabled(false);
				}
				if(xuly.equals("sua")) {
					tf_tenp.setText(tenP);
					phongDAL pdal = new phongDAL();
					phongDTO pdto = new phongDTO();
					pdto.setTenP(tenP);
					ResultSet rs = pdal.getPhongByName(pdto);
					try {
						while(rs.next()) {
							tf_lp.setText(rs.getString("loaiP"));
							s_sn.setValue(rs.getInt("soNguoi"));
							tf_gia.setText(String.valueOf(rs.getInt("gia")));
							tf_tt.setText(rs.getString("trangThai"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("Phong");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_2.add(panel_5);
		
		JLabel lblNewLabel = new JLabel("Ten phong");
		panel_5.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_2.add(panel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Loai phong");
		panel_6.add(lblNewLabel_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_2.add(panel_7);
		
		JLabel lblNewLabel_2 = new JLabel("So nguoi");
		panel_7.add(lblNewLabel_2);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_2.add(panel_10);
		
		JLabel lblNewLabel_3 = new JLabel("Gia");
		panel_10.add(lblNewLabel_3);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_2.add(panel_13);
		
		JLabel lblNewLabel_4 = new JLabel("Trang thai");
		panel_13.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.PAGE_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_3.add(panel_8);
		
		tf_tenp = new JTextField();
		panel_8.add(tf_tenp);
		tf_tenp.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_3.add(panel_9);
		
		tf_lp = new JTextField();
		panel_9.add(tf_lp);
		tf_lp.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_3.add(panel_11);
		
		s_sn = new JSpinner();
		panel_11.add(s_sn);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_3.add(panel_12);
		
		tf_gia = new JTextField();
		panel_12.add(tf_gia);
		tf_gia.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_3.add(panel_14);
		
		tf_tt = new JTextField();
		panel_14.add(tf_tt);
		tf_tt.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		JButton btn_huy = new JButton("Huy");
		btn_huy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				phong1 p =new phong1();
				p.setLocationRelativeTo(null);
				p.setSize(650, 550);
				p.setVisible(true);
			}
			
		});
		panel_4.add(btn_huy);
		
		JButton btn_nhan = new JButton("Nhan");
		btn_nhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				phongDTO pdto = new phongDTO();
				pdto.setTenP(tf_tenp.getText());
				pdto.setLoaiP(tf_lp.getText());
				pdto.setSoNguoi((int) s_sn.getValue());
				pdto.setGia(tf_gia.getText());
				pdto.setTrangThai(tf_tt.getText());
				phongBLL pbll = new phongBLL();
				if(xuly.equals("them")) {
					boolean kq = pbll.themP(pdto);
					if(kq) {
						thongbao.thongbao("Them phong thanh cong", "Thong bao");
						dispose();
						phong1 p =new phong1();
						p.setLocationRelativeTo(null);
						p.setSize(650, 550);
						p.setVisible(true);
					}
				}else if(xuly.equals("sua")) {
					boolean kq = pbll.suaP(pdto);
					if(kq) {
						thongbao.thongbao("Sua phong thanh cong", "Thong bao");
						dispose();
						phong1 p =new phong1();
						p.setLocationRelativeTo(null);
						p.setSize(650, 550);
						p.setVisible(true);
					}
				}
			}
			
		});
		panel_4.add(btn_nhan);
	}

}
