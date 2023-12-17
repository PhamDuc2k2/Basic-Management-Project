package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.MobileManager;
import files.FileMobile;
import model.entities.Mobile;
import model.lists.ListMobiles;

import javax.swing.JScrollPane;
public class HomeMobileGUI extends JFrame implements ActionListener, MobileManager {
	public Mobile mobile = new Mobile();
	static FileMobile fileWork = new FileMobile();
	public ArrayList<Mobile> list = new ArrayList<>();
	public static final String LOCAL_PATH = TrangChuGUI.LOCAL_PATH;
	private static HomeMobileGUI frame;
	private JPanel contentPane;
	private JTable table;
	private JTextField tf_search;
	private JComboBox comboboxSearch, comboboxSort;
	private JButton btnSearch, btnEdit, btnDelete, btnAdd;
	DefaultTableModel model;
	private JButton btnReset;
	private JPanel backPanel;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1_1;
	private JTextField newName;
	private JLabel lblNewLabel_1_2;
	private JTextField newPrice;
	private JLabel lblNewLabel_1_3;
	private JTextField newTotal;
	private JLabel lblNewLabel_1_4;
	private JTextField newBrand;
	private JLabel lblNewLabel_1_5;
	private JTextField newBattery;
	private JLabel lblNewLabel_1_6;
	private JTextField newMemory;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public HomeMobileGUI() throws IOException {
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(TrangChuGUI.LOCAL_PATH+"phone.png"));
		this.setTitle("HOME MOBILE");

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mnHelp.add(mntmLogOut);
		mntmLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Window login = null;
				try {
					login = new LoginGUI();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				login.setLocationRelativeTo(null);
				((Frame) login).setResizable(false);
				login.setVisible(true);
				dispose();
				
			}
		});
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mniHome = new JMenuItem("Home");
		mniHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Window home = null;
				try {
					home = new TrangChuGUI();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				home.setLocationRelativeTo(null);
				((Frame) home).setResizable(false);
				home.setVisible(true);
				dispose();
				
			}
		});
		mnNewMenu.add(mniHome);
		
		list = FileMobile.readMobiles();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1167, 636);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(233, 252, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 961, 322);
		contentPane.add(scrollPane);
		
		// Title
		JLabel lblNewLabel = new JLabel("Mobile List");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(529, 10, 100, 40);
		contentPane.add(lblNewLabel);
		
		// create Table
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		// display list Mobile
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "NAME", "PRICE", "TOTAL", "BRAND", "BATTERY", "MEMORY" }));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		table.setRowHeight(30);
		// set color for table
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        c.setBackground(row == 0 ? Color.LIGHT_GRAY : Color.WHITE);
		        return c;
		    }
		});
		
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		
		// duyet list
		for (int i = 0; i < list.size(); i++) {
			Mobile tmpMobile = list.get(i);
			model.addRow(new Object[] { tmpMobile.getProduct_id(), tmpMobile.getProduct_name(),
					tmpMobile.getProduct_price(), tmpMobile.getProduct_total(), tmpMobile.getMobile_brand(),
					tmpMobile.getMobile_battery(), tmpMobile.getMobile_memory() });
		}
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				newName.setText((String) table.getValueAt(row, 1));
				newPrice.setText(String.valueOf(table.getValueAt(row, 2)));
				newTotal.setText(String.valueOf(table.getValueAt(row, 3)));
				newBrand.setText(String.valueOf(table.getValueAt(row, 4)));
				newBattery.setText(String.valueOf(table.getValueAt(row, 5)));
				newMemory.setText(String.valueOf(table.getValueAt(row, 6)));
				
			}
		});
		
		// add button
		btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(new Color(128, 255, 128));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkValue()) return; 
				Mobile tmp = new Mobile(String.valueOf(Integer.parseInt(list.get(list.size()-1).getProduct_id()) + 1), newName.getText(), Double.parseDouble(newPrice.getText()),
					Integer.parseInt(newTotal.getText()), newBrand.getText(),
					Double.parseDouble(newBattery.getText()), Integer.parseInt(newMemory.getText()));
				addMobile(tmp);
				showTable(list);
				
			}
		});
		btnAdd.setBounds(10, 539, 129, 34);
		contentPane.add(btnAdd);
		

		// edit button
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getProduct_id().equals(table.getValueAt(table.getSelectedRow(), 0))) {
						editMobile(list.get(i));
					}
				}
				showTable(list);
				
			}
		});
		
		
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBackground(new Color(128, 255, 128));
		btnEdit.setBounds(300, 539, 129, 34);
		contentPane.add(btnEdit);
		

		btnDelete = new JButton("Delete");
		btnEdit.setEnabled(true);
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getProduct_id().equals(table.getValueAt(table.getSelectedRow(), 0))) {
						delMobile(list.get(i));
						
					}
				}
				showTable(list);

			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBackground(new Color(128, 255, 128));
		btnDelete.setBounds(561, 539, 129, 34);
		contentPane.add(btnDelete);
 
		// nhap thong tin tim kiem
		tf_search = new JTextField();
		tf_search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_search.setBounds(1001, 418, 142, 27);
		contentPane.add(tf_search);
		tf_search.setColumns(10);

		// search button
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(comboboxSearch.getSelectedItem());
				if (x == "Name") {
					searchMobile("Name");
				} else if (x == "Price") {
					searchMobile("Price");
				} else if (x == "Brand") {
					searchMobile("Brand");
				} else if (x == "Battery") {
					searchMobile("Battery");
				} else if (x == "Memory") {
					searchMobile("Memory");
				}

			}
		});
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBackground(new Color(128, 255, 128));
		btnSearch.setBounds(1001, 471, 94, 27);
		contentPane.add(btnSearch);
		

		JLabel lblNewLabelSearch = new JLabel("Search by");
		lblNewLabelSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabelSearch.setBounds(1001, 324, 94, 21);
		contentPane.add(lblNewLabelSearch);

		// chon thuoc tinh tim kiem
		comboboxSearch = new JComboBox();
		comboboxSearch.setBackground(new Color(204, 255, 204));
		comboboxSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboboxSearch
				.setModel(new DefaultComboBoxModel(new String[] { "Name", "Price", "Brand", "Battery", "Memory" }));
		comboboxSearch.setBounds(1001, 367, 94, 27);
		contentPane.add(comboboxSearch);

		JLabel lblNewLabelSort = new JLabel("Sort by price");
		lblNewLabelSort.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabelSort.setBounds(1001, 202, 100, 21);
		contentPane.add(lblNewLabelSort);
 
		// chon kieu sap xep
		comboboxSort = new JComboBox();
		comboboxSort.setModel(new DefaultComboBoxModel(new String[] { "Ascending", "Descending" }));
		comboboxSort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboboxSort.setBackground(new Color(204, 255, 204));
		comboboxSort.setBounds(1001, 233, 94, 27);
		contentPane.add(comboboxSort);
		// select item in combo box sort
		comboboxSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(comboboxSort.getSelectedItem());
				if (x == "Ascending") {
					sortedMobile(1);
				} else {
					sortedMobile(0);
				}

			}
		});

		// reset table button
		btnReset = new JButton("Reset Page");
		btnReset.setBackground(new Color(255, 168, 211));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(842, 539, 129, 34);
		contentPane.add(btnReset);
				
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showTable(list);
			}
		});
		 
		// remove focus boder for all button
		// reset
		btnReset.setFocusable(false);
		btnReset.setFocusPainted(false);
		// add
		btnAdd.setFocusable(false);
		btnAdd.setFocusPainted(false);
		// edit
		btnEdit.setFocusable(false);
		btnEdit.setFocusPainted(false);
		// delete
		btnDelete.setFocusable(false);
		btnDelete.setFocusPainted(false);
		// search  
		btnSearch.setFocusable(false);
		btnSearch.setFocusPainted(false);
		
		backPanel = new JPanel();
		backPanel.setBounds(23, 15, 165, 35);
		backPanel.setBackground(new Color(233, 252, 250));
		contentPane.add(backPanel);
		BufferedImage backBufferedImage = ImageIO.read(new File(LOCAL_PATH+"back_icon.png"));		
		backPanel.setLayout(null);		
		JLabel backImageJLabel = new JLabel(new ImageIcon( 
				backBufferedImage.getScaledInstance(35,35,Image.SCALE_SMOOTH)));
		backImageJLabel.setSize(35,35);
		backPanel.add(backImageJLabel);
		 
		JLabel lblNewLabel_2 = new JLabel("Back to Home");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(45, 0, 124, 35);
		backPanel.add(lblNewLabel_2);
		
		lblNewLabel_1_1 = new JLabel("NAME");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 78, 70, 19);
		contentPane.add(lblNewLabel_1_1);
		
		newName = new JTextField();
		newName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newName.setColumns(10);
		newName.setBounds(90, 75, 165, 25);
		contentPane.add(newName);
		
		lblNewLabel_1_2 = new JLabel("PRICE");
		lblNewLabel_1_2.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 120, 70, 19);
		contentPane.add(lblNewLabel_1_2);
		
		newPrice = new JTextField();
		newPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newPrice.setColumns(10);
		newPrice.setBounds(90, 117, 165, 25);
		contentPane.add(newPrice);
		
		lblNewLabel_1_3 = new JLabel("TOTAL");
		lblNewLabel_1_3.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(368, 78, 70, 19);
		contentPane.add(lblNewLabel_1_3);
		
		newTotal = new JTextField();
		newTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newTotal.setColumns(10);
		newTotal.setBounds(464, 75, 165, 25);
		contentPane.add(newTotal);
		
		lblNewLabel_1_4 = new JLabel("BRAND");
		lblNewLabel_1_4.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(368, 120, 70, 19);
		contentPane.add(lblNewLabel_1_4);
		
		newBrand = new JTextField();
		newBrand.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newBrand.setColumns(10);
		newBrand.setBounds(464, 117, 165, 25);
		contentPane.add(newBrand);
		
		lblNewLabel_1_5 = new JLabel("BATTERY");
		lblNewLabel_1_5.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(698, 78, 83, 19);
		contentPane.add(lblNewLabel_1_5);
		
		newBattery = new JTextField();
		newBattery.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newBattery.setColumns(10);
		newBattery.setBounds(806, 75, 165, 25);
		contentPane.add(newBattery);
		
		lblNewLabel_1_6 = new JLabel("MEMORY");
		lblNewLabel_1_6.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(698, 123, 70, 19);
		contentPane.add(lblNewLabel_1_6);
		
		newMemory = new JTextField();
		newMemory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newMemory.setColumns(10);
		newMemory.setBounds(806, 117, 165, 25);
		contentPane.add(newMemory);
		
		backPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				 
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				 
			}
			 
			@Override
			public void mouseClicked(MouseEvent e) {
				Window trangChuGUI = null;
				try {
					trangChuGUI = new TrangChuGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				trangChuGUI.setLocationRelativeTo(null);
				((Frame) trangChuGUI).setResizable(false);
				trangChuGUI.setVisible(true);
				dispose();
				
				
			}
		});
	}
	
	public boolean checkValue() {

		StringBuilder strb = new StringBuilder();
		
		if(newName.getText().equals(""))
			strb.append("Tên không được để trống!\n");
		
		try {
			if(newPrice.getText().equals(""))
				strb.append("Giá không được bỏ trống!\n");
			else if(Double.parseDouble(newPrice.getText()) < 0)	
				strb.append("Số tiền không hợp lệ!\n");
		} catch (Exception e) {
			strb.append("Số tiền không hợp lệ!\n");
		}
		
		try {
			if(newTotal.getText().equals(""))
				strb.append("Số lương không được bỏ trống!\n");
			else if(Integer.parseInt(newTotal.getText())  < 0)
				strb.append("Số lượng không hợp lệ!\n");
		} catch (Exception e) {
			strb.append("Số lượng không hợp lệ!\n");
		}
		
		if(newBrand.getText().equals(""))
			strb.append("Nhãn không được để trống!\n");
		
		try {
			if(newBattery.getText().equals(""))
				strb.append("Pin không được bỏ trống!\n");
			else if(Double.parseDouble(newBattery.getText()) < 0)	
				strb.append("Pin không hợp lệ!\n");
		} catch (Exception e) {
			strb.append("Pin không hợp lệ!\n");
		}
		
		try {
			if(newMemory.getText().equals(""))
				strb.append("Dung lượng bộ nhớ không được bỏ trống!\n");
			else if(Integer.parseInt(newMemory.getText())  < 0)
				strb.append("Dung lượng bộ nhớ không hợp lệ!\n");
		} catch (Exception e) {
			strb.append("Dung lượng bộ nhớ không hợp lệ!\n");
		}
			
		if(strb.length() > 0) {
			JOptionPane.showMessageDialog(contentPane, strb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false; 
		}
		return true;
	}
	
	public void showTable(ArrayList<Mobile> mobile) {
		// clear table
		model.setRowCount(0);
		list = FileMobile.readMobiles();
		// duyet list
		for (int i = 0; i < mobile.size(); i++) {
			Mobile tmpMobile = mobile.get(i);
			model.addRow(new Object[] { tmpMobile.getProduct_id(), tmpMobile.getProduct_name(),
					tmpMobile.getProduct_price(), tmpMobile.getProduct_total(), tmpMobile.getMobile_brand(),
					tmpMobile.getMobile_battery(), tmpMobile.getMobile_memory() });
		}
	}

	@Override
	public boolean addMobile(Mobile m) {
		if (list.stream().anyMatch(x -> x.getProduct_id().equals(m.getProduct_id()))) {
			JOptionPane.showMessageDialog(contentPane, "ID is existed!! Re-enter!!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else {
			// add new mobile into list
			list.add(m);
		}
		try {
			FileMobile.writeMobile(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (list.contains(m)) ? true : false;
	}

	@Override
	public boolean editMobile(Mobile m) {
		if(!checkValue())	return false;
		
		m.setProduct_name(newName.getText());
		m.setProduct_price(Double.parseDouble(newPrice.getText()));
		m.setProduct_total(Integer.parseInt(newTotal.getText()));
		m.setMobile_brand(newBrand.getText());
		m.setMobile_battery(Double.parseDouble(newBattery.getText()));
		m.setMobile_memory(Integer.parseInt(newMemory.getText()));
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getProduct_id().equals(table.getValueAt(table.getSelectedRow(), 0))) {
				list.set(i, m);
			}
		}
		try {
			FileMobile.writeMobile(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delMobile(Mobile m) {
		if(!list.contains(m)) return false;
		list.remove(m);
		try {
			FileMobile.writeMobile(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Mobile> searchMobile(String name) {
		ArrayList<Mobile> result = new ArrayList<>();
		switch (name) {
		case "Name": {
			result = (ArrayList<Mobile>) list.stream().filter(x -> x.getProduct_name().equals(tf_search.getText()))
					.collect(Collectors.toList());
			break;
		}
		case "Price": {
			result = (ArrayList<Mobile>) list.stream()
					.filter(x -> x.getProduct_price() == Double.parseDouble(tf_search.getText()))
					.collect(Collectors.toList());

			break;
		}
		case "Brand": {
			result = (ArrayList<Mobile>) list.stream().filter(x -> x.getMobile_brand().equals(tf_search.getText()))
					.collect(Collectors.toList());

			break;
		}
		case "Battery": {
			result = (ArrayList<Mobile>) list.stream()
					.filter(x -> x.getMobile_battery() == Double.parseDouble(tf_search.getText()))
					.collect(Collectors.toList());

			break;
		}
		case "Memory": {
			result = (ArrayList<Mobile>) list.stream()
					.filter(x -> x.getMobile_memory() == Integer.parseInt(tf_search.getText()))
					.collect(Collectors.toList());

			break;
		}
		default: 
			break;
		}
		// clear table
		model.setRowCount(0);

		// duyet list
		for (int i = 0; i < result.size(); i++) {
			Mobile tmpMobile = result.get(i);
			model.addRow(new Object[] { tmpMobile.getProduct_id(), tmpMobile.getProduct_name(),
					tmpMobile.getProduct_price(), tmpMobile.getProduct_total(), tmpMobile.getMobile_brand(),
					tmpMobile.getMobile_battery(), tmpMobile.getMobile_memory() });
		}
		return result;
	}

	
	
	@Override
	public List<Mobile> sortedMobile(double price) {
		ArrayList<Mobile> sortedList = list;
		sortedList.sort(Comparator.comparing(Mobile::getProduct_price));
		if (price == 0) {
			Collections.reverse(sortedList);
		}

		// clear table
		model.setRowCount(0);

		// duyet list
		for (int i = 0; i < sortedList.size(); i++) {
			Mobile tmpMobile = sortedList.get(i);
			model.addRow(new Object[] { tmpMobile.getProduct_id(), tmpMobile.getProduct_name(),
					tmpMobile.getProduct_price(), tmpMobile.getProduct_total(), tmpMobile.getMobile_brand(),
					tmpMobile.getMobile_battery(), tmpMobile.getMobile_memory() });
		}
		return sortedList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
