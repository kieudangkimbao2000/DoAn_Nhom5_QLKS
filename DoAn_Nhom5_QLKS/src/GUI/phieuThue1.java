package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.phieuThueBLL;
import DTO.datPhongDTO;
import DTO.khachDTO;
import DTO.phongDTO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.FlowLayout;

public class phieuThue1 extends JFrame {

	public static String tenP;
	
	private JPanel contentPane;
	private JTextField tf_ht;
	private JTextField tf_gt;
	private JTextField tf_sdt;
	private JTextField tf_cmnd;
	private JTextField tf_card;
	private JTextField tf_qt;
	private JTextField tf_nd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					phieuThue1 frame = new phieuThue1();
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
	public phieuThue1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Phieu thue");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btn_huy = new JButton("Huy");
		btn_huy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				phong1 frame = new phong1();
				frame.setLocationRelativeTo(null);
				frame.setSize(650, 550);
				frame.setVisible(true);
			}
			
		});
		panel_2.add(btn_huy);
		
		JSpinner s_snt = new JSpinner();
		
		tf_card = new JTextField();
		
		JButton btn_dp = new JButton("Dat phong");
		btn_dp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				phongDTO pdto = new phongDTO();
				pdto.setTenP(tenP);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				LocalDate date = LocalDate.now();
				String strDate = String.valueOf(date);
				Date date1 = null;
				Date date2 = null;
				try {
					date1 = sdf.parse(tf_nd.getText());
					date2 = sdf.parse(strDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(date1.equals(date2)) {
					pdto.setTrangThai("Da thue");
				}else {
					pdto.setTrangThai("Trong");
				}
				khachDTO kdto = new khachDTO();
				kdto.setHTK(tf_ht.getText());
				kdto.setGTK(tf_gt.getText());
				kdto.setCMNDK(tf_cmnd.getText());
				kdto.setSDT(tf_sdt.getText());
				kdto.setCard(tf_card.getText());
				kdto.setQuocTich(tf_qt.getText());
				datPhongDTO dpdto = new datPhongDTO();
				dpdto.setTenP(tenP);
				dpdto.setIdNV(String.valueOf(dangNhap1.iduser));
				dpdto.setNgayDen(tf_nd.getText());
				dpdto.setSoNgayThue((int) s_snt.getValue());
				phieuThueBLL ptbll = new phieuThueBLL();
				boolean kq = ptbll.kiemTraPT(pdto, dpdto, kdto);
				if(kq) {
					dispose();
					phong1 frame = new phong1();
					frame.setLocationRelativeTo(null);
					frame.setSize(650, 550);
					frame.setVisible(true);
				}
			}
			
		});
		panel_2.add(btn_dp);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		panel_3.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Ten phong:");
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(tenP);
		panel_5.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.PAGE_AXIS));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.WHITE);
		FlowLayout flowLayout_6 = (FlowLayout) panel_17.getLayout();
		flowLayout_6.setHgap(11);
		panel_9.add(panel_17);
		
		JLabel lblNewLabel_3 = new JLabel("Ho ten");
		panel_17.add(lblNewLabel_3);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.WHITE);
		panel_9.add(panel_18);
		
		tf_ht = new JTextField();
		panel_18.add(tf_ht);
		tf_ht.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		FlowLayout flowLayout_5 = (FlowLayout) panel_19.getLayout();
		flowLayout_5.setHgap(7);
		panel_10.add(panel_19);
		
		JLabel lblNewLabel_4 = new JLabel("Gioi tinh");
		panel_19.add(lblNewLabel_4);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(Color.WHITE);
		panel_10.add(panel_22);
		
		tf_gt = new JTextField();
		panel_22.add(tf_gt);
		tf_gt.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_7.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.WHITE);
		FlowLayout flowLayout_4 = (FlowLayout) panel_20.getLayout();
		flowLayout_4.setHgap(16);
		panel_11.add(panel_20);
		
		JLabel lblNewLabel_5 = new JLabel("SDT");
		panel_20.add(lblNewLabel_5);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		panel_11.add(panel_21);
		
		tf_sdt = new JTextField();
		panel_21.add(tf_sdt);
		tf_sdt.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_7.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.WHITE);
		panel_12.add(panel_23);
		
		JLabel lblNewLabel_6 = new JLabel("Ngay den");
		panel_23.add(lblNewLabel_6);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(Color.WHITE);
		panel_12.add(panel_24);
		
		tf_nd = new JTextField();
		panel_24.add(tf_nd);
		tf_nd.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.PAGE_AXIS));
		
		JPanel panel_13 = new JPanel();
		panel_8.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_25.getLayout();
		flowLayout_3.setHgap(12);
		panel_13.add(panel_25);
		
		JLabel lblNewLabel_7 = new JLabel("CMND");
		panel_25.add(lblNewLabel_7);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBackground(Color.WHITE);
		panel_13.add(panel_29);
		
		tf_cmnd = new JTextField();
		panel_29.add(tf_cmnd);
		tf_cmnd.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_8.add(panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));
		
		JPanel panel_26 = new JPanel();
		panel_26.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_26.getLayout();
		flowLayout_2.setHgap(15);
		panel_14.add(panel_26);
		
		JLabel lblNewLabel_8 = new JLabel("Card");
		panel_26.add(lblNewLabel_8);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBackground(Color.WHITE);
		panel_14.add(panel_30);
		
		tf_card = new JTextField();
		panel_30.add(tf_card);
		tf_card.setColumns(10);
		
		JPanel panel_15 = new JPanel();
		panel_8.add(panel_15);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(Color.WHITE);
		panel_15.add(panel_27);
		
		JLabel lblNewLabel_9 = new JLabel("Quoc tich");
		panel_27.add(lblNewLabel_9);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBackground(Color.WHITE);
		panel_15.add(panel_31);
		
		tf_qt = new JTextField();
		panel_31.add(tf_qt);
		tf_qt.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16);
		panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.X_AXIS));
		
		JPanel panel_28 = new JPanel();
		panel_28.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_28.getLayout();
		flowLayout_1.setHgap(-37);
		panel_16.add(panel_28);
		
		JLabel lblNewLabel_10 = new JLabel("So ngay thue");
		panel_28.add(lblNewLabel_10);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBackground(Color.WHITE);
		panel_16.add(panel_33);
		
		panel_33.add(s_snt);
	}

}
