package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import DTO.userDTO;

import javax.swing.border.BevelBorder;

public class dangKy1 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_ht;
	private JTextField tf_tdn;
	private JPasswordField pf_pass;
	private JPasswordField pf_rpass;
	private JTextField tf_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangKy1 frame = new dangKy1();
					frame.setLocationRelativeTo(null);
					frame.setSize(500, 400);
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
	public dangKy1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Dang ky");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_5 = (FlowLayout) panel_8.getLayout();
		flowLayout_5.setHgap(25);
		panel_3.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("Ho va ten");
		panel_8.add(lblNewLabel_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_9);
		
		tf_ht = new JTextField();
		panel_9.add(tf_ht);
		tf_ht.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_4 = (FlowLayout) panel_10.getLayout();
		flowLayout_4.setHgap(12);
		panel_4.add(panel_10);
		
		JLabel lblNewLabel_2 = new JLabel("Ten dang nhap");
		panel_10.add(lblNewLabel_2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_4.add(panel_11);
		
		tf_tdn = new JTextField();
		panel_11.add(tf_tdn);
		tf_tdn.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_3 = (FlowLayout) panel_12.getLayout();
		flowLayout_3.setHgap(25);
		panel_5.add(panel_12);
		
		JLabel lblNewLabel_3 = new JLabel("Mat khau");
		panel_12.add(lblNewLabel_3);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		panel_5.add(panel_13);
		
		pf_pass = new JPasswordField();
		pf_pass.setColumns(10);
		panel_13.add(pf_pass);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_14);
		
		JLabel lblNewLabel_4 = new JLabel("Nhap lai mat khau");
		panel_14.add(lblNewLabel_4);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_15);
		
		pf_rpass = new JPasswordField();
		pf_rpass.setColumns(10);
		panel_15.add(pf_rpass);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.LINE_AXIS));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_2 = (FlowLayout) panel_16.getLayout();
		flowLayout_2.setHgap(34);
		panel_7.add(panel_16);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		panel_16.add(lblNewLabel_5);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_1 = (FlowLayout) panel_17.getLayout();
		panel_7.add(panel_17);
		
		tf_email = new JTextField();
		panel_17.add(tf_email);
		tf_email.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JCheckBox cb = new JCheckBox("Toi dong y voi dieu khoan");
		cb.setBackground(Color.WHITE);
		panel_2.add(cb);
		
		JButton btn_huy = new JButton("Huy");
		btn_huy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				dangNhap1 frame = new dangNhap1();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
			
		});
		panel_2.add(btn_huy);
		
		JButton btn_dk = new JButton("Dang ky");
		btn_dk.setEnabled(false);
		btn_dk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userDTO udto = new userDTO();
            	udto.setHoVaTen(tf_ht.getText());
                udto.setTenDangNhap(tf_tdn.getText());
                udto.setMk(String.valueOf(pf_pass.getText()));
                udto.setEmail(tf_email.getText());
                String nhaplai = String.valueOf(pf_rpass.getText());
                boolean kt = BLL.dangKyBLL.kiemTraDK(udto, nhaplai);
                if (kt) {
                    dispose();
                    dangNhap1 dn = new dangNhap1();
                    dn.setLocationRelativeTo(null);
                    dn.setVisible(true);
                }
			}
			
		});
		panel_2.add(btn_dk);
		
		cb.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
            	if (cb.isSelected()) {
                    btn_dk.setEnabled(true);
                }else {
                	btn_dk.setEnabled(false);
                }
            }
        });
		
	}

}
