package view;
import java.awt.EventQueue;
//import mobile.*;
//import report.StatisticalFrame;
//import tour.Swing;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import files.FileCar;
import files.FileCarX;
import files.FileMobile;
import files.FileTour;
import model.entities.User;
import model.lists.ListCarXs;
import model.lists.ListCars;
import model.lists.ListMobiles;
import model.lists.ListTours;

//import car.HomeCar;


public class TrangChuGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane; 
	public static User currentUser = new User();
	
	private ListCarXs carxManagerImpl = new ListCarXs();
	private ListCars carManagerImpl = new ListCars();
	private ListMobiles mobileManagerImpl = new ListMobiles();
	private ListTours tourManagerImpl = new ListTours();
	private static boolean initStatus = false;
	
	// local file path ( sửa theo thư mục chứa ảnh của từng máy )
	//public static final String LOCAL_PATH = "D:\\Group3\\image\\";
	public static final String LOCAL_PATH = "D:\\Java\\Group3\\image\\"; 
	
	public TrangChuGUI() throws IOException {
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(TrangChuGUI.LOCAL_PATH+"logo.jpg"));
		this.setTitle("HOME");
		
		
		if(!initStatus) {
			carManagerImpl.init(20);
			carxManagerImpl.init(20);
			mobileManagerImpl.init(20);
			tourManagerImpl.init(20);
			initStatus = true;
			try {
				FileCar.outputList(carManagerImpl.getList());
				FileCarX.outputList(carxManagerImpl.getList());
				FileMobile.writeMobile(mobileManagerImpl.getList());
				FileTour.outputList(tourManagerImpl.getTour());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		setBackground(new Color(233, 252, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 589);
		contentPane = new JLayeredPane();
		contentPane.setBackground(new Color(233, 252, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BufferedImage homeBufferedImage = ImageIO.read(new File(LOCAL_PATH+"\\home.jpg"));		
		JLabel homeImageJLabel = new JLabel(new ImageIcon( 
				homeBufferedImage.getScaledInstance(1000, 170,Image.SCALE_SMOOTH)));
		 
		homeImageJLabel.setLocation(-11, 63);
		homeImageJLabel.setSize(1009, 139);
		contentPane.add(homeImageJLabel);
		
		BufferedImage logoBufferedImage = ImageIO.read(new File(LOCAL_PATH+"logo.png"));		
		JLabel logoImageJLabel = new JLabel(new ImageIcon( 
				logoBufferedImage.getScaledInstance(35, 35,Image.SCALE_SMOOTH)));
		
		logoImageJLabel.setLocation(25, 10);
		logoImageJLabel.setSize(35, 35);
		contentPane.add(logoImageJLabel);
		
		JLabel groupName = new JLabel("Nhóm 3");
		groupName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		groupName.setBounds(75, 10, 144, 43);
		contentPane.add(groupName);
		
		JButton btnLogOut = new JButton("Đăng xuất");
		btnLogOut.setBackground(new Color(255, 255, 255));
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogOut.setBounds(790, 10, 128, 43);
		btnLogOut.setFocusable(false);
		btnLogOut.setFocusPainted(false);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentUser = new User();
				Window loginWindow = null;
				try {
					loginWindow = new LoginGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loginWindow.setLocationRelativeTo(null);
				((Frame) loginWindow).setResizable(false);
				loginWindow.setVisible(true);
				dispose();
			}
		});
		
		// car manage
		JPanel carPanel = new JPanel();
		carPanel.setBorder(new LineBorder(new Color(87, 87, 87), 2));
		carPanel.setBackground(new Color(255, 255, 255));
		carPanel.setBounds(75, 327, 144, 98);
		contentPane.add(carPanel);
		
		BufferedImage carBufferedImage = ImageIO.read(new File(LOCAL_PATH+"car_icon.png"));		
		carPanel.setLayout(null);
		JLabel carName = new JLabel("Ô tô");
		carName.setForeground(new Color(87, 87, 87));
		carName.setHorizontalAlignment(SwingConstants.CENTER);
		carName.setFont(new Font("Arial", Font.BOLD, 25));
		carName.setBounds(0, 53, 144, 45);
		carPanel.add(carName);
		JLabel carImageJLabel = new JLabel(new ImageIcon( 
				carBufferedImage.getScaledInstance(45,45,Image.SCALE_SMOOTH)));
		carImageJLabel.setBounds(0, 0, 144, 55);
		carPanel.add(carImageJLabel);
		
		// mobile manage
		JPanel mobilePanel = new JPanel();
		mobilePanel.setLayout(null);
		mobilePanel.setBorder(new LineBorder(new Color(87, 87, 87), 2));
		mobilePanel.setBackground(Color.WHITE);
		mobilePanel.setBounds(732, 327, 144, 98);
		contentPane.add(mobilePanel);
		mobilePanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Window homeMobile = null;
				try {
					homeMobile = new HomeMobileGUI();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				homeMobile.setLocationRelativeTo(null);
				((Frame) homeMobile).setResizable(false);
				homeMobile.setVisible(true);
				dispose();
				
			}
		});
		
		
		
		
		
		
		JLabel mobileName = new JLabel("Điện thoại");
		mobileName.setHorizontalAlignment(SwingConstants.CENTER);
		mobileName.setForeground(new Color(87, 87, 87));
		mobileName.setFont(new Font("Arial", Font.BOLD, 25));
		mobileName.setBounds(0, 53, 144, 45);
		mobilePanel.add(mobileName);
		
		BufferedImage mobileBufferedImage = ImageIO.read(new File(LOCAL_PATH+"mobile_icon.png"));		
		mobilePanel.setLayout(null);		
		JLabel mobileImageJLabel = new JLabel(new ImageIcon( 
				mobileBufferedImage.getScaledInstance(45,45,Image.SCALE_SMOOTH)));
		mobileImageJLabel.setBounds(0, 0, 144, 55);
		mobilePanel.add(mobileImageJLabel);
		
		
		
		
		// carx manage
		JPanel carXPanel = new JPanel();
		carXPanel.setLayout(null);
		carXPanel.setBorder(new LineBorder(new Color(87, 87, 87), 2));
		carXPanel.setBackground(Color.WHITE);
		carXPanel.setBounds(294, 327, 144, 98);
		contentPane.add(carXPanel);
		carXPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Window homeCarX = null;
				try {
					homeCarX = new HomeCarXGUI();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				homeCarX.setLocationRelativeTo(null);
				((Frame) homeCarX).setResizable(false);
				homeCarX.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel carXName = new JLabel("Ô tô V2");
		carXName.setHorizontalAlignment(SwingConstants.CENTER);
		carXName.setForeground(new Color(87, 87, 87));
		carXName.setFont(new Font("Arial", Font.BOLD, 25));
		carXName.setBounds(0, 53, 144, 45);
		carXPanel.add(carXName);
		
		BufferedImage carXBufferedImage = ImageIO.read(new File(LOCAL_PATH+"carV2_icon.png"));		
		carXPanel.setLayout(null);		
		JLabel carXImageJLabel = new JLabel(new ImageIcon( 
				carXBufferedImage.getScaledInstance(45,45,Image.SCALE_SMOOTH)));
		carXImageJLabel.setBounds(0, 0, 144, 55);
		carXPanel.add(carXImageJLabel);
		
		// tour manage
		JPanel tourPanel = new JPanel();
		tourPanel.setLayout(null);
		tourPanel.setBorder(new LineBorder(new Color(87, 87, 87), 2));
		tourPanel.setBackground(Color.WHITE);
		tourPanel.setBounds(513, 327, 144, 98);
		contentPane.add(tourPanel);
		tourPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Window homeTour = null;
				try {
					homeTour = new HomeTourGUI();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				homeTour.setLocationRelativeTo(null);
				((Frame) homeTour).setResizable(false);
				homeTour.setVisible(true);
				dispose();
				
				
				
			}
		});
		
		carPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Window homeCar = null;
				try {
					homeCar = new HomeCarGUI();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				homeCar.setLocationRelativeTo(null);
				((Frame) homeCar).setResizable(false);
				homeCar.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel tourName = new JLabel("Tour");
		tourName.setHorizontalAlignment(SwingConstants.CENTER);
		tourName.setForeground(new Color(87, 87, 87));
		tourName.setFont(new Font("Arial", Font.BOLD, 25));
		tourName.setBounds(0, 53, 144, 45);
		tourPanel.add(tourName);
		
		BufferedImage tourBufferedImage = ImageIO.read(new File(LOCAL_PATH+"tour_icon.png"));		
		tourPanel.setLayout(null);		
		JLabel tourImageJLabel = new JLabel(new ImageIcon( 
				tourBufferedImage.getScaledInstance(45,45,Image.SCALE_SMOOTH)));
		tourImageJLabel.setBounds(0, 0, 144, 55);
		tourPanel.add(tourImageJLabel);
		
		JPanel connectPanel = new JPanel();
		connectPanel.setBackground(new Color(255, 255, 255));
		connectPanel.setForeground(new Color(255, 255, 255));
		connectPanel.setBounds(-11, 483, 991, 92);
		contentPane.add(connectPanel);
		connectPanel.setLayout(null);
		
		JLabel sdt = new JLabel("SĐT: 0352601794");
		sdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sdt.setForeground(new Color(87, 87, 87));
		sdt.setBounds(44, 0, 166, 36);
		connectPanel.add(sdt);
		
		JLabel email = new JLabel("Email: trieuvino.1@gmail.com");
		email.setForeground(new Color(87, 87, 87));
		email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		email.setBounds(42, 32, 245, 36);
		connectPanel.add(email);
		
		JLabel lblQunLSn = new JLabel("Quản lý sản phẩm");
		lblQunLSn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLSn.setFont(new Font("Arial", Font.BOLD, 42));
		lblQunLSn.setBounds(300, 241, 384, 54);
		contentPane.add(lblQunLSn);
		
		JLabel lblChoMngNg = new JLabel("Chào mừng "+currentUser.getFirstName() + " " + currentUser.getLastName()+" đến với phần mềm");
		lblChoMngNg.setFont(new Font("Arial", Font.ITALIC, 17));
		lblChoMngNg.setBounds(10, 201, 567, 43);
		contentPane.add(lblChoMngNg);
		
		JButton btnReport = new JButton("Thống kê");
		btnReport.setBackground(new Color(255, 250, 240));
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReport.setBounds(803, 212, 114, 32);
		contentPane.add(btnReport);
		btnReport.setFocusable(false);
		btnReport.setFocusPainted(false);
		btnReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Window statistic = null;
				try {
					statistic = new StatisticalGUI();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				statistic.setLocationRelativeTo(null);
				((Frame) statistic).setResizable(false);
				statistic.setVisible(true);
				dispose();

			}
		});
		
		
		
	}
}
