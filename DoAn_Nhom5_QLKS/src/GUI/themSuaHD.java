package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.hoaDonBLL;
import DTO.hoaDonDTO;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class themSuaHD extends JFrame {

	public static int maHD;
	public static String xuly;
	
	private JPanel contentPane;
	private JTextField tf_maDP;
	private JTextField tf_tong;
	private JTextField tf_tt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					themSuaHD frame = new themSuaHD();
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
	public themSuaHD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				if(xuly.equals("sua")) {
					hoaDonDTO hddto = new hoaDonDTO();
					hddto.setIdHD(maHD);
					hoaDonBLL hdbll = new hoaDonBLL();
					ResultSet rs = hdbll.getHDById_RS(hddto);
					try {
						while(rs.next()) {
							tf_maDP.setText(rs.getString("IDDP"));
							tf_tong.setText(rs.getString("TONG"));
							tf_tt.setText(rs.getString("trangThai"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
		
		JLabel lblNewLabel = new JLabel("Hoa don");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.PAGE_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_3.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Ma dat phong");
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_3.add(panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Tong tien");
		panel_6.add(lblNewLabel_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_3.add(panel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Trang thai");
		panel_7.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.PAGE_AXIS));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_4.add(panel_10);
		
		tf_maDP = new JTextField();
		panel_10.add(tf_maDP);
		tf_maDP.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_4.add(panel_9);
		
		tf_tong = new JTextField();
		panel_9.add(tf_tong);
		tf_tong.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_4.add(panel_8);
		
		tf_tt = new JTextField();
		panel_8.add(tf_tt);
		tf_tt.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btn_huy = new JButton("Huy");
		btn_huy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hoaDon1 hd = new hoaDon1();
				hd.setLocationRelativeTo(null);
				hd.setSize(650, 550);
				dispose();
				hd.setVisible(true);
			}
			
		});
		panel_2.add(btn_huy);
		
		JButton btn_nhan = new JButton("Nhan");
		btn_nhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hoaDonDTO hddto = new hoaDonDTO();
				hddto.setIdDP(tf_maDP.getText());
				hddto.setTong(tf_tong.getText());
				hddto.setTrangThai(tf_tt.getText());
				hoaDonBLL hdbll = new hoaDonBLL();
				if(xuly.equals("them")) {
					boolean kq = hdbll.themHD(hddto);
					if(kq) {
						thongbao.thongbao("Them hoa don thanh cong", "Thong bao");
						hoaDon1 hd = new hoaDon1();
						hd.setLocationRelativeTo(null);
						hd.setSize(650, 550);
						dispose();
						hd.setVisible(true);
					}
				}
				if(xuly.equals("sua")) {
					hddto.setIdHD(maHD);
					boolean kq = hdbll.themHD(hddto);
					if(kq) {
						thongbao.thongbao("Sua hoa don thanh cong", "Thong bao");
						hoaDon1 hd = new hoaDon1();
						hd.setLocationRelativeTo(null);
						hd.setSize(650, 550);
						dispose();
						hd.setVisible(true);
					}
				}
			}
			
		});
		panel_2.add(btn_nhan);
	}

}
