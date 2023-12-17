package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entities.User;
import model.lists.ListUsers;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private List<User> list = new ArrayList<>();

	/**
	 * Create the frame.
	 */
	public LoginGUI() throws IOException{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InstantiationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(TrangChuGUI.LOCAL_PATH+"logo.jpg"));
		this.setTitle("LOG IN");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		ListUsers.init();
		try {
			ListUsers.usersOutputFile();
			list = ListUsers.usersInputFile();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(233, 252, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 128, 255));
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblEmail.setBounds(68, 140, 111, 22);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setBounds(233, 138, 223, 33);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 128, 255));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPassword.setBounds(68, 195, 111, 22);
		contentPane.add(lblPassword);
		

		textFieldPassword = new JPasswordField();
		textFieldPassword.setToolTipText("\r\n");
		textFieldPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPassword.setBounds(233, 193, 223, 33);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ListUsers.checkUser(textFieldEmail.getText(), textFieldPassword.getText(), list) == null) {
					JOptionPane.showMessageDialog(contentPane, "Log in unsuccessful", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				TrangChuGUI trangChuGUI;
				try {
					trangChuGUI = new TrangChuGUI();
					String textEmail = textFieldEmail.getText();
					
					User user = ListUsers.checkEmail(textEmail, list);
					new TrangChuGUI().currentUser = user;

					Window trangchuWindow = new TrangChuGUI();
					trangchuWindow.setLocationRelativeTo(null);
					((Frame) trangchuWindow).setResizable(false);
					trangchuWindow.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSubmit.setBounds(176, 258, 110, 33);
		contentPane.add(btnSubmit);
		BufferedImage loginBufferedImage = ImageIO.read(new File(TrangChuGUI.LOCAL_PATH+"login.png"));	
		JLabel logoImageJLabel = new JLabel(new ImageIcon( 
				loginBufferedImage.getScaledInstance(75, 75,Image.SCALE_SMOOTH)));
		logoImageJLabel.setBounds(176, 10, 110, 110);
		contentPane.add(logoImageJLabel);
		logoImageJLabel.setBackground(new Color(255, 255, 255));
		
	}
}
