package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.userDTO;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPasswordField;

public class dangNhap1 extends JFrame {

	public static int iduser;
	public static int quyen;
	
	private JPanel contentPane;
	private JTextField tf_tdn;
	private JPasswordField pf_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangNhap1 frame = new dangNhap1();
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
	public dangNhap1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Dang nhap");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Ten dang nhap");
		panel_2.add(lblNewLabel_1);
		
		tf_tdn = new JTextField();
		panel_2.add(tf_tdn);
		tf_tdn.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(35);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Mat khau");
		panel_3.add(lblNewLabel_2);
		
		pf_pass = new JPasswordField();
		pf_pass.setColumns(10);
		panel_3.add(pf_pass);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_1.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		JButton btn_dk = new JButton("Dang ky");
		btn_dk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				dangKy1 frame = new dangKy1();
				frame.setLocationRelativeTo(null);
				frame.setSize(500, 400);
				frame.setVisible(true);
			}
			
		});
		panel_4.add(btn_dk);
		
		JButton btn_dn = new JButton("Dang nhap");
		btn_dn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userDTO udto = new userDTO();
				udto.setTenDangNhap(tf_tdn.getText());
				udto.setMk(String.valueOf(pf_pass.getText()));
				boolean kt = BLL.dangNhapBLL.kiemTraDN(udto);
				if(kt) {
					dispose();
		            main1 m = new main1();
		            m.setLocationRelativeTo(null);
					m.setSize(1000, 600);
		            m.setVisible(true);
				}else {}
			}
			
		});
		panel_4.add(btn_dn);
	}

}
