package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.khachBLL;
import DTO.khachDTO;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class themSuaK extends JFrame {

	public static int maKhach;
	public static String xuly;
	
	private JPanel contentPane;
	private JTextField tf_ht;
	private JTextField tf_gt;
	private JTextField tf_sdt;
	private JTextField tf_cmnd;
	private JTextField tf_c;
	private JTextField tf_qt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					themSuaK frame = new themSuaK();
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
	public themSuaK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent evt) {
				if(xuly.equals("sua")) {
					khachDTO kdto = new khachDTO();
					kdto.setIdK(maKhach);
					khachBLL kbll = new khachBLL();
					ResultSet rs = kbll.getKhachById(kdto);
					try {
						while(rs.next()) {
							tf_ht.setText(rs.getString("HTK"));
							tf_gt.setText(rs.getString("GTK"));
							tf_sdt.setText(rs.getString("SDT"));
							tf_cmnd.setText(rs.getString("CMNDK"));
							tf_c.setText(rs.getString("CARD"));
							tf_qt.setText(rs.getString("QT"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_6 = new JLabel("Khach");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.PAGE_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		panel_5.add(panel_7);
		
		JLabel lblNewLabel = new JLabel("Ho va ten");
		panel_7.add(lblNewLabel);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_5.add(panel_10);
		
		JLabel lblNewLabel_1 = new JLabel("GT");
		panel_10.add(lblNewLabel_1);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_5.add(panel_11);
		
		JLabel lblNewLabel_2 = new JLabel("SDT");
		panel_11.add(lblNewLabel_2);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.PAGE_AXIS));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_6.add(panel_13);
		
		tf_ht = new JTextField();
		panel_13.add(tf_ht);
		tf_ht.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_14.getLayout();
		panel_6.add(panel_14);
		
		tf_gt = new JTextField();
		panel_14.add(tf_gt);
		tf_gt.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_6.add(panel_12);
		
		tf_sdt = new JTextField();
		panel_12.add(tf_sdt);
		tf_sdt.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.PAGE_AXIS));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		panel_9.add(panel_15);
		
		JLabel lblNewLabel_3 = new JLabel("CMND");
		panel_15.add(lblNewLabel_3);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		panel_9.add(panel_16);
		
		JLabel lblNewLabel_4 = new JLabel("Card");
		panel_16.add(lblNewLabel_4);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.WHITE);
		panel_9.add(panel_17);
		
		JLabel lblNewLabel_5 = new JLabel("Quoc tich");
		panel_17.add(lblNewLabel_5);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.PAGE_AXIS));
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.WHITE);
		panel_8.add(panel_18);
		
		tf_cmnd = new JTextField();
		panel_18.add(tf_cmnd);
		tf_cmnd.setColumns(10);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		panel_8.add(panel_19);
		
		tf_c = new JTextField();
		panel_19.add(tf_c);
		tf_c.setColumns(10);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.WHITE);
		panel_8.add(panel_20);
		
		tf_qt = new JTextField();
		panel_20.add(tf_qt);
		tf_qt.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btn_huy = new JButton("Huy");
		panel_2.add(btn_huy);
		
		JButton btn_nhan = new JButton("Nhan");
		btn_nhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				khachDTO kdto = new khachDTO();
				kdto.setHTK(tf_ht.getText());
				kdto.setGTK(tf_gt.getText());
				kdto.setSDT(tf_sdt.getText());
				kdto.setCMNDK(tf_cmnd.getText());
				kdto.setCard(tf_c.getText());
				kdto.setQuocTich(tf_qt.getText());
				khachBLL kbll = new khachBLL();
				if(xuly.equals("them")) {
					boolean kq = kbll.themK(kdto);
					if(kq) {
						thongbao.thongbao("Them khach thanh cong", "Thong bao");
						khach1 k = new khach1();
						k.setLocationRelativeTo(null);
						k.setSize(650, 550);
						dispose();
						k.setVisible(true);
					}
				}
				if(xuly.equals("sua")) {
					kdto.setIdK(maKhach);
					boolean kq = kbll.suaK(kdto);
					if(kq) {
						thongbao.thongbao("Sua khach thanh cong", "Thong bao");
						khach1 k = new khach1();
						k.setLocationRelativeTo(null);
						k.setSize(650, 550);
						dispose();
						k.setVisible(true);
					}
				}
			}
			
		});
		panel_2.add(btn_nhan);
	}

}
