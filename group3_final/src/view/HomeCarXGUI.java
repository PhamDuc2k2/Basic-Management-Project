package view;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.CarXManager;
import files.FileCarX;
import model.entities.Car;
import model.entities.CarX;
import model.lists.ListCarXs;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Color;


public class HomeCarXGUI extends JFrame implements CarXManager{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTextField textFieldTotal;
	private JTextField textFieldCylinder;
	private JTextField textFieldColor;
	private List<CarX> list = new ArrayList<>();
	private static String idSelected;
	private JTextField textFieldSearch;
	private JTextField textFieldSort;

	public static final String LOCAL_PATH = TrangChuGUI.LOCAL_PATH;



	/**
	 * Create the frame.
	 */
	public HomeCarXGUI() throws Exception, ClassNotFoundException {
		
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
		
		
		
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(TrangChuGUI.LOCAL_PATH+"carV2_icon.png"));
		this.setTitle("HOME CAR V2");
		this.setResizable(false);
		
		list = FileCarX.inputList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1165, 650);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 252, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		scrollPane.setBounds(23, 76, 719, 308);
		contentPane.add(scrollPane);
		String[] tableHeader = new String[] {
				"ID", "Name", "Price", "Total", "Cylinder Capacity", "Color"
			};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(tableHeader);

		
		showTable(list);
		
		table = new JTable();
		
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		table.setModel(model);
		table.setRowHeight(20);
		
        scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				textFieldName.setText((String) table.getValueAt(row, 1));
				textFieldPrice.setText(String.valueOf(table.getValueAt(row, 2)));
				textFieldTotal.setText(String.valueOf(table.getValueAt(row, 3)));
				textFieldCylinder.setText(String.valueOf(table.getValueAt(row, 4)));
				textFieldColor.setText(String.valueOf(table.getValueAt(row, 5)));
				idSelected =   String.valueOf(table.getValueAt(row, 0));
			}
		});
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(128, 0, 128));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblName.setBackground(new Color(0, 0, 0));
		lblName.setBounds(23, 436, 90, 21);
		contentPane.add(lblName);
		
		textFieldName = new JTextField(); 
		textFieldName.setBounds(146, 438, 203, 21);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(new Color(128, 0, 128));
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setBounds(23, 483, 90, 21);
		contentPane.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(146, 485, 203, 21);
		contentPane.add(textFieldPrice);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setForeground(new Color(128, 0, 128));
		lblTotal.setBounds(23, 541, 90, 20);
		contentPane.add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(146, 544, 203, 19);
		contentPane.add(textFieldTotal);
		
		JLabel lblCylinder = new JLabel("CYLINDER");
		lblCylinder.setForeground(new Color(128, 0, 128));
		lblCylinder.setHorizontalAlignment(SwingConstants.LEFT);
		lblCylinder.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCylinder.setBounds(411, 484, 113, 19);
		contentPane.add(lblCylinder);
		
		textFieldCylinder = new JTextField();
		textFieldCylinder.setColumns(10);
		textFieldCylinder.setBounds(539, 486, 203, 19);
		contentPane.add(textFieldCylinder);
		
		JLabel lblColor = new JLabel("COLOR");
		lblColor.setForeground(new Color(128, 0, 128));
		lblColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblColor.setBounds(411, 544, 90, 15);
		contentPane.add(lblColor);
		
		textFieldColor = new JTextField();
		textFieldColor.setColumns(10);
		textFieldColor.setBounds(539, 544, 203, 19);
		contentPane.add(textFieldColor);
		
		JPanel backPanel = new JPanel();
		backPanel.setBounds(23, 15, 165, 35);
		backPanel.setBackground(new Color(233, 252, 250));
		contentPane.add(backPanel);
		BufferedImage backBufferedImage = ImageIO.read(new File(LOCAL_PATH+"back_icon.png"));		
		backPanel.setLayout(null);		
		JLabel backImageJLabel = new JLabel((Icon) new ImageIcon( 
				backBufferedImage.getScaledInstance(35,35,Image.SCALE_SMOOTH)));
		backImageJLabel.setSize(35,35);
		backPanel.add(backImageJLabel);
		
		JLabel lblHome = new JLabel("Back to Home");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHome.setBounds(45, 0, 124, 35);
		backPanel.add(lblHome);
		
		backPanel.addMouseListener((MouseListener) new MouseListener() {
			
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

				TrangChuGUI trangChuGUI = null;
				try {
					trangChuGUI = new TrangChuGUI();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				trangChuGUI.setLocationRelativeTo(null);
				trangChuGUI.setResizable(false);
				trangChuGUI.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setForeground(new Color(0, 128, 255));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkValue()) return;
				CarX car = takeValueCar(String.valueOf(Integer.parseInt(list.get(list.size()-1).getProduct_id()) + 1));
				if(!addCar(car)) {
					JOptionPane.showMessageDialog(contentPane, "Đã tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(contentPane, "Thêm thành công!");
				fillTable();
			}
		});
		btnAdd.setBounds(764, 434, 106, 27);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setForeground(new Color(0, 128, 255));
		btnEdit.setBackground(new Color(255, 255, 255));
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkValue()) return;
				if(!editCar(takeValueCar(idSelected))) {
					JOptionPane.showMessageDialog(contentPane, "Editing Invalid");
					return;
				}
				JOptionPane.showMessageDialog(contentPane, "Sửa thành công!");
				
				fillTable();
			}
		});
		btnEdit.setBounds(899, 434, 106, 27);
		contentPane.add(btnEdit);
		
		JButton btnDel = new JButton("DELETE");
		btnDel.setForeground(new Color(0, 128, 255));
		btnDel.setBackground(new Color(255, 255, 255));
		btnDel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!delCar(null)) {
					JOptionPane.showMessageDialog(contentPane, "Deleting Invalid");
					return;
				}
				JOptionPane.showMessageDialog(contentPane, "Xóa thành công!");
				resetId(list);
				fillTable();

			}
		});
		btnDel.setBounds(1035, 434, 106, 27);
		contentPane.add(btnDel);
		
		JLabel lblNewLabel = new JLabel("TYPE OF SEARCH");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(750, 121, 138, 21);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxTypeSearch = new JComboBox();
		comboBoxTypeSearch.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxTypeSearch.setModel(new DefaultComboBoxModel(new String[] {"Tên ô tô", "Giá ô tô", "Số lượng ô tô", "Dung tích xylanh ô tô", "Màu ô tô"}));
		comboBoxTypeSearch.setBounds(938, 118, 203, 27);
		contentPane.add(comboBoxTypeSearch);
		
		JLabel lblNewLabel_1 = new JLabel("VALUE SEARCH");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(752, 172, 165, 19);
		contentPane.add(lblNewLabel_1);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(938, 164, 203, 27);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch.setForeground(new Color(0, 128, 255));
		btnSearch.setBackground(new Color(0, 128, 255));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<CarX> listSearch = new ArrayList<>();
				String valueSearch = comboBoxTypeSearch.getSelectedItem().toString();
				String typeSearch = textFieldSearch.getText();
				if(valueSearch.trim().toLowerCase().equals(comboBoxTypeSearch.getItemAt(0).toString().toLowerCase())) {
					if(typeSearch.equals("")) {
						inValidValue();
						return;
					}
					listSearch = searchCar(typeSearch);
					showTable(listSearch);
				} 
				
				else if(valueSearch.trim().toLowerCase().equals(comboBoxTypeSearch.getItemAt(1).toString().toLowerCase())) {
					try {
						double price = Double.parseDouble(typeSearch);
						if(price < 0) {
							inValidValue();
							return;
						}
						listSearch = searchCar(price);
						showTable(listSearch);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(contentPane, "Số liệu nhập vào không hợp lệ!");
					}
				} 
				
				else if(valueSearch.trim().toLowerCase().equals(comboBoxTypeSearch.getItemAt(2).toString().toLowerCase())) {
					try {
						int total = Integer.parseInt(typeSearch);
						if(total < 0) {
							inValidValue();
							return;
						}
						listSearch = searchCar(total);
						showTable(listSearch);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(contentPane, "Số liệu nhập vào không hợp lệ!");
					}
				} 
				
				else if(valueSearch.trim().toLowerCase().equals(comboBoxTypeSearch.getItemAt(3).toString().toLowerCase())) {
					try {
						double cylinder = Double.parseDouble(typeSearch);
						if(cylinder < 0) {
							inValidValue();
							return;
						}
						listSearch = searchCarByCylinder(cylinder);
						showTable(listSearch);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(contentPane, "Số liệu nhập vào không hợp lệ!");
					}
				} 
				
				else if(valueSearch.trim().toLowerCase().equals(comboBoxTypeSearch.getItemAt(4).toString().toLowerCase())) {
					try {
						String color = String.valueOf(typeSearch);
						if(color.equals("")) {
							inValidValue();
							return;
						}
						listSearch = searchCarByColor(color);
						showTable(listSearch);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(contentPane, "Số liệu nhập vào không hợp lệ!");
						
					}
				}
				
			}
		});
		btnSearch.setBounds(899, 539, 106, 27);
		contentPane.add(btnSearch);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setForeground(new Color(255, 0, 128));
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(1035, 539, 106, 27);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_2 = new JLabel("TYPE OF SORT");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(753, 244, 153, 21);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBoxTypeSort = new JComboBox();
		comboBoxTypeSort.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxTypeSort.setModel(new DefaultComboBoxModel(new String[] {"Sắp xếp theo giá", "Sắp xếp theo dung tích xylanh"}));
		comboBoxTypeSort.setBounds(938, 241, 203, 27);
		contentPane.add(comboBoxTypeSort);
		
		JComboBox comboBoxSort = new JComboBox();
		comboBoxSort.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxSort.setModel(new DefaultComboBoxModel(new String[] {"Tăng dần", "Giảm dần"}));
		comboBoxSort.setBounds(938, 295, 203, 27);
		contentPane.add(comboBoxSort);
		
		textFieldSort = new JTextField();
		textFieldSort.setBounds(938, 357, 203, 27);
		contentPane.add(textFieldSort);
		textFieldSort.setColumns(10);
		
		JButton btnSort = new JButton("SORT");
		btnSort.setForeground(new Color(0, 128, 255));
		btnSort.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSort.setBackground(new Color(0, 128, 255));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<CarX> listSort = new ArrayList<>();
				String valueSort = comboBoxTypeSort.getSelectedItem().toString();
				String valueINC = comboBoxSort.getSelectedItem().toString();
				boolean isINC =  true;
				if(valueINC.equals("Giảm dần"))
					isINC = false;
				String typeSort = textFieldSort.getText();

				
				if(valueSort.trim().toLowerCase().equals(comboBoxTypeSort.getItemAt(0).toString().toLowerCase())) {
					try {
						double price = Double.parseDouble(typeSort);
						if(price < 0) {
							inValidValue();
						}
						listSort = sortedCar(price, isINC);
						showTable(listSort);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "Số liệu nhập vào không hợp lệ!");
					}
				} else if(valueSort.trim().toLowerCase().equals(comboBoxTypeSort.getItemAt(1).toString().toLowerCase())) {
					try {
						double cylinder = Double.parseDouble(typeSort);
						if(cylinder < 0) {
							inValidValue();
						}
						listSort = sortedCarByCylinder(cylinder, isINC);
						showTable(listSort);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "Số liệu nhập vào không hợp lệ!");
					}
				}
			}
		});
		btnSort.setBounds(764, 539, 106, 27);
		contentPane.add(btnSort);
		
		JLabel lblNewLabel_4 = new JLabel("VALUE SORT");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(new Color(255, 128, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(752, 365, 153, 19);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CAR MANAGEMENT V2");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(350, 10, 436, 34);
		contentPane.add(lblNewLabel_5);
	}
	
	
	public boolean checkValue() {

		StringBuilder strb = new StringBuilder();
		
		if(textFieldName.getText().equals(""))
			strb.append("Tên không được để trống!\n");
		
		try {
			if(textFieldPrice.getText().equals(""))
				strb.append("Giá không được bỏ trống!\n");
			else if(Double.parseDouble(textFieldPrice.getText()) < 0)	
				strb.append("Số tiền không hợp lệ!\n");
		} catch (Exception e) {
			strb.append("Số tiền không hợp lệ!\n");
		}
		
		try {
			if(textFieldTotal.getText().equals(""))
				strb.append("Số lương không được bỏ trống!\n");
			else if(Integer.parseInt(textFieldTotal.getText())  < 0)
				strb.append("Số lượng không hợp lệ!\n");
		} catch (Exception e) {
			strb.append("Số lượng không hợp lệ!\n");
		}
		
		try {
			if(textFieldCylinder.getText().equals(""))
				strb.append("Dung tích xylanh không được để trống!\n");
			else if(Double.parseDouble(textFieldCylinder.getText()) < 0)
				strb.append("Dung tích xylanh không hợp lệ!\n");
		} catch (Exception e) {
			strb.append("Dung tích xylanh không hợp lệ!\n");
		}
		
		try {
			if(textFieldColor.getText().equals(""))
				strb.append("Số chỗ ngồi không được để trống!\n");
			else if(Integer.parseInt(textFieldColor.getText()) < 0)
				strb.append("Số chỗ ngồi không hợp lệ!\n");
		} catch (Exception e) {
			strb.append("Số chỗ ngồi không hợp lệ!\n");
		}
		
			
		if(strb.length() > 0) {
			JOptionPane.showMessageDialog(contentPane, strb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false; 
		}
		return true;
	}
	
	public void inValidValue() {
		JOptionPane.showMessageDialog(contentPane, "Số liệu nhập vào không hợp lệ!");
		return;
	}

	public void resetId(List<CarX> list) {
		int i = 0;
		for(CarX car: list) {
			car.setProduct_id(String.valueOf(++i));
		}
	}
	
	public void reset() {
		resetTextField();
		fillTable();
	}
	
	public void resetTextField() {
		textFieldName.setText("");
		textFieldPrice.setText("");
		textFieldTotal.setText("");
		textFieldCylinder.setText("");
		textFieldColor.setText("");
	}
	
	public void fillTable() {
		try {
			list = FileCarX.InOutFile(list);
			showTable(list);
			resetTextField();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public void showTable(List<CarX> list) {
		model.setRowCount(0);
		for(CarX car : list) {
			model.addRow(new Object[] { car.getProduct_id(), car.getProduct_name(), car.getProduct_price(),
					car.getProduct_total(), car.getCylinder(), car.getColor() });
		}
	}

	
	public CarX takeValueCar(String id) {
		CarX car = new CarX();
		car.setProduct_id(id);
			car.setProduct_name(textFieldName.getText());
			car.setProduct_price(Double.parseDouble(textFieldPrice.getText()));
			car.setProduct_total(Integer.parseInt(textFieldTotal.getText()));
			car.setCylinder(Double.parseDouble(textFieldCylinder.getText()));
			car.setColor(textFieldColor.getText());
		return car;
	}


	@Override
	public boolean addCar(CarX c) {
		for (CarX car : list) {
			if(car.equals(c))
				return false;
		}
		list.add(c);
		return true;
	}

	@Override
	public boolean editCar(CarX c) {
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).getProduct_id().equals(idSelected)) {
				list.set(i, c);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delCar(CarX c) {
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).getProduct_id().equals(idSelected)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<CarX> searchCar(String name) {
		List<CarX> tmp = new ArrayList<CarX>();
		for (CarX car : list) {
			if(car.getProduct_name().compareToIgnoreCase(name) == 0) {
				tmp.add(car);
			}
		}
		return tmp;
	}

	@Override
	public List<CarX> searchCar(double price) {
		List<CarX> tmp = new ArrayList<CarX>();
		for (CarX car : list) {
			if(car.getProduct_price() >= price) {
				tmp.add(car);
			}
		}
		return tmp;
	}

	@Override
	public List<CarX> searchCar(int total) {
		List<CarX> tmp = new ArrayList<CarX>();
		for (CarX car : list) {
			if(car.getProduct_total() >= total) {
				tmp.add(car);
			}
		}
		return tmp;
	}

	@Override
	public List<CarX> searchCarByCylinder(double cylinder) {
		List<CarX> tmp = new ArrayList<CarX>();
		for (CarX car : list) {
			if(car.getCylinder() >= cylinder) {
				tmp.add(car);
			}
		}
		return tmp;
	}

	@Override
	public List<CarX> searchCarByColor(String color) {
		List<CarX> tmp = new ArrayList<CarX>();
		for (CarX car : list) {
			if(car.getColor().compareToIgnoreCase(color) == 0) {
				tmp.add(car);
			}
		}
		return tmp;
	}

	@Override
	public List<CarX> sortedCar(double price, boolean isINC) {
		List<CarX> tmp = new ArrayList<CarX>();
		for (CarX car : list) {
			if(car.getProduct_price() >= price)
				tmp.add(car);
		}
		if(isINC)
			Collections.sort(tmp, new sortedByPriceX());
		else 
			Collections.sort(tmp, new sortedByPriceX().reversed());
		return tmp;
	}

	@Override
	public List<CarX> sortedCarByCylinder(double cylinder, boolean isINC) {
		List<CarX> tmp = new ArrayList<CarX>();
		for (CarX car : list) {
			if(car.getCylinder() >= cylinder)
				tmp.add(car);
		}
		if(isINC)
			Collections.sort(tmp, new sortedByCylinderCapacityX());
		else 
			Collections.sort(tmp, new sortedByCylinderCapacityX().reversed());
		return tmp;
	}

	
	
}

class sortedByPriceX implements Comparator<CarX> {
	@Override
	public int compare(CarX o1, CarX o2) {
		return (int) (o1.getProduct_price() - o2.getProduct_price());
	}
	
}

class sortedByCylinderCapacityX implements Comparator<CarX> {
	@Override
	public int compare(CarX o1, CarX o2) {
		return (int)(o1.getCylinder() * 10 - o2.getCylinder() * 10);
	}
	
}
