package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.datPhongBLL;
import DTO.datPhongDTO;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class themSuaDP extends JFrame {

	public static int maDP;
	public static String xuly;
	
	private JPanel contentPane;
	private JTextField tf_maK;
	private JTextField tf_tenP;
	private JTextField tf_maTK;
	private JTextField tf_nd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					themSuaDP frame = new themSuaDP();
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
	public themSuaDP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JSpinner s_snt = new JSpinner();
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				datPhongBLL dpbll = new datPhongBLL();
				datPhongDTO dpdto = new datPhongDTO();
				dpdto.setIdDP(maDP);
				ResultSet rs = dpbll.getDPById(dpdto);
				try {
					while(rs.next()) {
						tf_maK.setText(rs.getString("idK"));
						tf_tenP.setText(rs.getString("tenP"));
						tf_maTK.setText(rs.getString("idNV"));
						tf_nd.setText(rs.getString("ngayDen"));
						s_snt.setValue(rs.getInt("soNgayThue"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		
		JLabel lblNewLabel = new JLabel("Dat phong");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		
		JLabel lblNewLabel_1 = new JLabel("Ma khach");
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_3.add(panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Ten phong");
		panel_6.add(lblNewLabel_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_3.add(panel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Ma tai khoan");
		panel_7.add(lblNewLabel_3);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_3.add(panel_8);
		
		JLabel lblNewLabel_4 = new JLabel("Ngay den");
		panel_8.add(lblNewLabel_4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_3.add(panel_9);
		
		JLabel lblNewLabel_5 = new JLabel("So ngay thue");
		panel_9.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.PAGE_AXIS));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_4.add(panel_12);
		
		tf_maK = new JTextField();
		panel_12.add(tf_maK);
		tf_maK.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_4.add(panel_13);
		
		tf_tenP = new JTextField();
		panel_13.add(tf_tenP);
		tf_tenP.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_4.add(panel_10);
		
		tf_maTK = new JTextField();
		panel_10.add(tf_maTK);
		tf_maTK.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_4.add(panel_14);
		
		tf_nd = new JTextField();
		panel_14.add(tf_nd);
		tf_nd.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_4.add(panel_11);
		
		
		panel_11.add(s_snt);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btn_huy = new JButton("Huy");
		btn_huy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				datPhong1 dp = new datPhong1();
				dp.setLocationRelativeTo(null);
				dp.setSize(650, 550);
				dp.setVisible(true);
			}
			
		});
		panel_2.add(btn_huy);
		
		JButton btn_nhan = new JButton("Nhan");
		btn_nhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				datPhongDTO dpdto = new datPhongDTO();
				dpdto.setIdK(tf_maK.getText());
				dpdto.setTenP(tf_tenP.getText());
				dpdto.setIdNV(tf_maTK.getText());
				dpdto.setNgayDen(tf_nd.getText());
				dpdto.setSoNgayThue((int) s_snt.getValue());
				datPhongBLL dpbll = new datPhongBLL();
				if(xuly.equals("them")) {
					boolean kq = dpbll.themDP(dpdto);
					if(kq) {
						thongbao.thongbao("Them thanh cong", "Thong bao");
						datPhong1 dp = new datPhong1();
						dp.setLocationRelativeTo(null);
						dp.setSize(650, 550);
						dispose();
						dp.setVisible(true);
					}
				}
				if(xuly.equals("sua")) {
					dpdto.setIdDP(maDP);
					boolean kq = dpbll.suaDP(dpdto);
					if(kq) {
						thongbao.thongbao("Sua thanh cong", "Thong bao");
						datPhong1 dp = new datPhong1();
						dp.setLocationRelativeTo(null);
						dp.setSize(650, 550);
						dispose();
						dp.setVisible(true);
					}
				}
			}
			
		});
		panel_2.add(btn_nhan);
	}

}
