package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class main1 extends JFrame {
	public static String tenTK;

	private JPanel contentPane;
	
	JButton btn_tk = new JButton("Tai khoan");
	JButton btn_nv = new JButton("Nhan vien");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main1 frame = new main1();
					frame.setLocationRelativeTo(null);
					frame.setSize(1000, 600);
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
	public main1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 539);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent evt) {
				if(dangNhap1.quyen==0||dangNhap1.quyen==1) {
					btn_nv.setEnabled(true);
				}
				if(dangNhap1.quyen==0) {
					btn_tk.setEnabled(true);
				}
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mi_dmk = new JMenuItem("Doi mat khau");
		mi_dmk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				doiMK1 dmk = new doiMK1();
				dmk.setLocationRelativeTo(null);
				dmk.setVisible(true);
			}
			
		});
		mnNewMenu.add(mi_dmk);
		
		JMenuItem mi_dx = new JMenuItem("Dang xuat");
		mi_dx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				dangNhap1 dn = new dangNhap1();
				dn.setLocationRelativeTo(null);
				dn.setVisible(true);
			}
			
		});
		mnNewMenu.add(mi_dx);
		
		JLabel lblNewLabel_7 = new JLabel("Xin chao:");
		menuBar.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(tenTK);
		menuBar.add(lblNewLabel_8);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Quan ly khach san");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.PAGE_AXIS));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_4.add(panel_10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(main1.class.getResource("/hinh/tải xuống.png")));
		panel_10.add(lblNewLabel_1);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_4.add(panel_11);
		
		JButton btn_phong = new JButton("Phong");
		btn_phong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				phong1 p = new phong1();
				p.setLocationRelativeTo(null);
				p.setSize(650, 550);
				p.setVisible(true);
			}
			
		});
		panel_11.add(btn_phong);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.PAGE_AXIS));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		panel_5.add(panel_16);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(main1.class.getResource("/hinh/folder-customer-icon.png")));
		panel_16.add(lblNewLabel_2);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.WHITE);
		panel_5.add(panel_17);
		
		JButton btn_khach = new JButton("Khach");
		btn_khach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				khach1 k = new khach1();
				k.setLocationRelativeTo(null);
				k.setSize(650, 550);
				k.setVisible(true);
			}
			
		});
		panel_17.add(btn_khach);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.PAGE_AXIS));
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.WHITE);
		panel_6.add(panel_18);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(main1.class.getResource("/hinh/tải xuống (2).png")));
		panel_18.add(lblNewLabel_3);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		panel_6.add(panel_19);
		
		JButton btn_dp = new JButton("Dat phong");
		btn_dp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				datPhong1 dp = new datPhong1();
				dp.setLocationRelativeTo(null);
				dp.setSize(650, 550);
				dp.setVisible(true);
			}
			
		});
		panel_19.add(btn_dp);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.PAGE_AXIS));
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.WHITE);
		panel_9.add(panel_20);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(main1.class.getResource("/hinh/bill-paid-icon-vector-21020754.jpg")));
		panel_20.add(lblNewLabel_4);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		panel_9.add(panel_21);
		
		JButton btn_hd = new JButton("Hoa don");
		btn_hd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				hoaDon1 hd = new hoaDon1();
				hd.setLocationRelativeTo(null);
				hd.setSize(650, 550);
				hd.setVisible(true);
			}
			
		});
		panel_21.add(btn_hd);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.PAGE_AXIS));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_12.getLayout();
		panel_7.add(panel_12);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(main1.class.getResource("/hinh/tải xuống (1).png")));
		panel_12.add(lblNewLabel_5);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_7.add(panel_13);
		
		btn_tk.setEnabled(false);
		panel_13.add(btn_tk);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.PAGE_AXIS));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_8.add(panel_14);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(main1.class.getResource("/hinh/tải xuống.jpg")));
		panel_14.add(lblNewLabel_6);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		panel_8.add(panel_15);

		btn_nv.setEnabled(false);
		panel_15.add(btn_nv);
	}

}
