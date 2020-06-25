package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.doiMKBLL;
import DTO.userDTO;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;

public class doiMK1 extends JFrame {

	private JPanel contentPane;
	private JPasswordField pf_mkc;
	private JPasswordField pf_mkm;
	private JPasswordField pf_nl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doiMK1 frame = new doiMK1();
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
	public doiMK1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Doi mat khau");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setHgap(28);
		panel_2.add(panel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Mat khau cu");
		panel_6.add(lblNewLabel_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_2.add(panel_7);
		
		pf_mkc = new JPasswordField();
		pf_mkc.setColumns(10);
		panel_7.add(pf_mkc);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
		flowLayout.setHgap(25);
		panel_3.add(panel_8);
		
		JLabel lblNewLabel_2 = new JLabel("Mat khau moi");
		panel_8.add(lblNewLabel_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_3.add(panel_9);
		
		pf_mkm = new JPasswordField();
		pf_mkm.setColumns(10);
		panel_9.add(pf_mkm);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_4.add(panel_10);
		
		JLabel lblNewLabel_3 = new JLabel("Nhap lai mat khau moi");
		panel_10.add(lblNewLabel_3);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_4.add(panel_11);
		
		pf_nl = new JPasswordField();
		pf_nl.setColumns(10);
		panel_11.add(pf_nl);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_1.add(panel_5);
		
		JButton btn_huy = new JButton("Huy");
		panel_5.add(btn_huy);
		
		JButton btn_doi = new JButton("Doi");
		btn_doi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				userDTO udto = new userDTO();
				udto.setIdUser(dangNhap1.iduser);
				doiMKBLL dmkbll = new doiMKBLL();
				String mkc = String.valueOf(pf_mkc.getText());
				String mkm = String.valueOf(pf_mkm.getText());
				String nlmk = String.valueOf(pf_nl.getText());
				boolean kq = doiMKBLL.kiemTraDoiMK(udto, mkc, mkm, nlmk);
				if(kq) {
					dispose();
					main1 m = new main1();
					m.setLocationRelativeTo(null);
					m.setSize(1000, 600);
					m.setVisible(true);
				}
			}
			
		});
		panel_5.add(btn_doi);
	}

}
