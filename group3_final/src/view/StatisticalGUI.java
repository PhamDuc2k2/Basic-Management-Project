package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import files.*;
import model.entities.Appear;
import model.entities.Car;
import model.entities.CarX;
import model.entities.Mobile;
import model.entities.Product;
import model.entities.Tour;
public class StatisticalGUI<X> extends JFrame {

	private JPanel contentPane;
	private JTable table_Car;
	private JTable table_Tour;
	private JTable table_Mobile;
	private JTable table_Statistic;
	
	private List<Car> listCar = new ArrayList<Car>(); 
	private List<Mobile> listMobile = new ArrayList<Mobile>(); 
	private List<Tour> listTour = new ArrayList<Tour>(); 
	private List<CarX> listCarX = new ArrayList<CarX>(); 
	
	private List<Product> list_Statistic_Max = new ArrayList<>(); 

	private List<Appear> list_Appear = new ArrayList<Appear>();
	
	private DefaultTableModel model_Car;
	private DefaultTableModel model_Mobile;
	private DefaultTableModel model_Tour;
	private DefaultTableModel model_Statistic; 
	private DefaultTableModel model_Appear; 
	private DefaultTableModel model_CarX; 
	
	
	private String[] columnHeaders_Car = new String[] {
			"ID", "NAME", "PRICE", "TOTAL", "CAPACITY", "SEAT" 
	};
	private String[] columnHeaders_Tour = new String[] {
			"ID", "NAME", "PRICE", "TOTAL", "PLACE", "TIME", 
	}; 
	private String[] columnHeaders_Mobile = new String[] {
			"ID", "NAME", "PRICE", "TOTAL", "BRAND", "BATTERY", "MEMORY"
	}; 
	private String[] columnHeaders_Statistic = new String[] {
			"ID", "NAME", "PRICE", "TOTAL"
	}; 
	private String[] columnHeaders_Appear = new String[] {
			"Tên hàng", "Số loại sản phẩm"
	}; 
	private String[] columnHeaders_CarX = new String[] {
			"ID", "NAME", "PRICE", "TOTAL", "CAPACITY", "COLOR"
	}; 
	private JTable table_Appear;
	private JTable table_CarX;
	//khoi tao du lieu cho bang car
	private void initData_Car() {
		try {
			listCar = FileCar.inputList();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//ghi du lieu vao bang danh sach car
	private void initTable_Car() {
		model_Car = new DefaultTableModel(); 
		model_Car.setColumnIdentifiers(columnHeaders_Car);
		initData_Car();
		listCar.forEach(item ->{
			model_Car.addRow(new Object[] {
					item.getProduct_id(), item.getProduct_name(), item.getProduct_price(), item.getProduct_total(),
					item.getCylinderCapacity(), item.getSeat()
			}); 
		});
		table_Car.setModel(model_Car); 
	}
	//khoi tao du lieu cho bang tour
	private void initData_Tour() {
		try {
			listTour = FileTour.inputList();
		} catch (IOException  | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ghi vao bang danh sach tour
	private void initTable_Tour() {
		model_Tour = new DefaultTableModel(); 
		model_Tour.setColumnIdentifiers(columnHeaders_Tour);
		initData_Tour();
		listTour.forEach(item ->{
			model_Tour.addRow(new Object[] {
					item.getProduct_id(), item.getProduct_name(), item.getProduct_price(), item.getProduct_total(),
					item.getTour_place(), item.getTour_time()
			}); 
		});
		table_Tour.setModel(model_Tour); 
	}
	//khoi tao du lieu cho bang mobile
	private void initData_Mobile() {
		listMobile = FileMobile.readMobiles();
	}
	//ghi vao bang danh sach mobile
	private void initTable_Mobile() {
		model_Mobile = new DefaultTableModel(); 
		model_Mobile.setColumnIdentifiers(columnHeaders_Mobile);
		initData_Mobile();
		listMobile.forEach(item ->{
			model_Mobile.addRow(new Object[] {
					item.getProduct_id(), item.getProduct_name(), item.getProduct_price(), item.getProduct_total(),
					item.getMobile_brand(), item.getMobile_battery(), item.getMobile_memory() 
			}); 
		});
		table_Mobile.setModel(model_Mobile); 
	}
	//khoi tao du lieu cho bang CarX 
	private void initData_CarX() throws ClassNotFoundException, IOException {
		listCarX = FileCarX.inputList(); 
	}
	//ghi vao bang danh sach CarX 
	private void initTable_CarX() throws ClassNotFoundException, IOException {
		model_CarX = new DefaultTableModel(); 
		model_CarX.setColumnIdentifiers(columnHeaders_CarX);
		initData_CarX(); 
		listCarX.forEach(item ->{
			model_CarX.addRow(new Object[] {
					item.getProduct_id(), item.getProduct_name(), item.getProduct_price(), item.getProduct_total(),
					item.getCylinder(), item.getColor()
			}); 
		});
		table_CarX.setModel(model_CarX); 
	}
	//ghi vao bang thong ke theo gia ban va so luong
	private void initTable_Statistic() {
		model_Statistic = new DefaultTableModel(); 
		model_Statistic.setColumnIdentifiers(columnHeaders_Statistic);
		
		list_Statistic_Max.forEach(item ->{ 
			model_Statistic.addRow(new Object[] {
					item.getProduct_id(), item.getProduct_name(), item.getProduct_price(), item.getProduct_total() 
			}); 
		});
		table_Statistic.setModel(model_Statistic); 
	}
	//ghi gia tri vao bang thong ke san pham 
	private void initTable_Appear() {
		model_Appear= new DefaultTableModel(); 
		model_Appear.setColumnIdentifiers(columnHeaders_Appear);
		 
		list_Appear.forEach(item ->{
			model_Appear.addRow(new Object[] {
					item.getName(), item.getTotal()
			}); 
		});
		table_Appear.setModel(model_Appear); 
	}
	//ham tim san pham co gia ban cao nhat
	public double maxPrice(String X) {
		double max_Price = 0; 
		if(X.equals("Car")) {
			max_Price = listCar.get(0).getProduct_price(); 
			for(int i=0;i<listCar.size();i++) {
				if(listCar.get(i).getProduct_price() > max_Price) {
					max_Price = listCar.get(i).getProduct_price();
				}
			}
		} else if(X.equals("Tour")) {
			max_Price = listTour.get(0).getProduct_price(); 
			for(int i=0;i<listTour.size();i++) {
				if(listTour.get(i).getProduct_price() > max_Price) {
					max_Price = listTour.get(i).getProduct_price();
				}
			} 
		} else if(X.equals("Mobile")) {
			max_Price = listMobile.get(0).getProduct_price(); 
			for(int i=0;i<listMobile.size();i++) {
				if(listMobile.get(i).getProduct_price() > max_Price) {
					max_Price = listMobile.get(i).getProduct_price();
				}
			}
		} else if(X.equals("CarX")) {
			max_Price = listCarX.get(0).getProduct_price(); 
			for(int i=0;i<listCarX.size();i++) {
				if(listCarX.get(i).getProduct_price() > max_Price) {
					max_Price = listCarX.get(i).getProduct_price();
				}
			}
		}
		return max_Price; 
	}
	//Ham tim san pham co gia ban nho nhat
	public double minPrice(String X) {
		double min_Price = 0; 
		if(X.equals("Car")) {
			min_Price = listCar.get(0).getProduct_price(); 
			for(int i=0;i<listCar.size();i++) {
				if(listCar.get(i).getProduct_price() < min_Price) {
					min_Price = listCar.get(i).getProduct_price();
				}
			}
		} else if(X.equals("Tour")) {
			min_Price = listTour.get(0).getProduct_price(); 
			for(int i=0;i<listTour.size();i++) {
				if(listTour.get(i).getProduct_price() < min_Price) {
					min_Price = listTour.get(i).getProduct_price();
				}
			} 
		} else if(X.equals("Mobile")) {
			min_Price = listMobile.get(0).getProduct_price(); 
			for(int i=0;i<listMobile.size();i++) {
				if(listMobile.get(i).getProduct_price() < min_Price) {
					min_Price = listMobile.get(i).getProduct_price();
				}
			}
		} else if(X.equals("CarX")) {
			min_Price = listCarX.get(0).getProduct_price(); 
			for(int i=0;i<listCarX.size();i++) {
				if(listCarX.get(i).getProduct_price() < min_Price) {
					min_Price = listCarX.get(i).getProduct_price();
				}
			}
		}
		return min_Price; 
	}
	//Ham tim san pham co so luong nhieu nhat
	public long maxTotal(String X) {
		long max_Total = 0; 
		if(X.equals("Car")) {
			max_Total =  listCar.get(0).getProduct_total(); 
			for(int i=0;i<listCar.size();i++) {
				if(listCar.get(i).getProduct_total() > max_Total) {
					max_Total = listCar.get(i).getProduct_total();
				}
			}
		} else if(X.equals("Tour")) {
			max_Total = listTour.get(0).getProduct_total(); 
			for(int i=0;i<listTour.size();i++) {
				if(listTour.get(i).getProduct_total() > max_Total) {
					max_Total = listTour.get(i).getProduct_total(); 
				}
			} 
		} else if(X.equals("Mobile")) {
			max_Total = listMobile.get(0).getProduct_total(); 
			for(int i=0;i<listMobile.size();i++) {
				if(listMobile.get(i).getProduct_total() > max_Total) {
					max_Total = listMobile.get(i).getProduct_total(); 
				}
			}
		} else if(X.equals("CarX")) {
			max_Total = listCarX.get(0).getProduct_total(); 
			for(int i=0;i<listCarX.size();i++) {
				if(listCarX.get(i).getProduct_total() > max_Total) {
					max_Total = listCarX.get(i).getProduct_total(); 
				}
			}
		}
		return max_Total; 
	}
	//Ham tim san pham co so luong nho nhat
	public Long minTotal(String X) {
		Long min_Total = (long) 0; 
		if(X.equals("Car")) {
			min_Total = (long) listCar.get(0).getProduct_total(); 
			for(int i=0;i<listCar.size();i++) {
				if(listCar.get(i).getProduct_total() < min_Total) {
					min_Total = (long) listCar.get(i).getProduct_total(); 
				}
			}
		} else if(X.equals("Tour")) {
			min_Total = (long) listTour.get(0).getProduct_total(); 
			for(int i=0;i<listTour.size();i++) {
				if(listTour.get(i).getProduct_total() < min_Total) {
					min_Total = (long) listTour.get(i).getProduct_total(); 
				}
			} 
		} else if(X.equals("Mobile")) {
			min_Total = (long) listMobile.get(0).getProduct_total(); 
			for(int i=0;i<listMobile.size();i++) {
				if(listMobile.get(i).getProduct_total() < min_Total) {
					min_Total = (long) listMobile.get(i).getProduct_total(); 
				}
			}
		} else if(X.equals("CarX")) {
			min_Total = (long) listCarX.get(0).getProduct_total(); 
			for(int i=0;i<listCarX.size();i++) {
				if(listCarX.get(i).getProduct_total() < min_Total) {
					min_Total = (long) listCarX.get(i).getProduct_total(); 
				}
			}
		}
		return min_Total; 
	}
	//Ham dem 1 str trong chuoi str. 
	public HashMap<String, Integer> getStatistic(String str, String ch_split){
		String[] tmp_words = str.split(ch_split); 
		HashMap<String, Integer> words = new HashMap<>(); 
		
		//Duyet mang vao luu tru + thong ke 
		for(String word:tmp_words) {
			if(!"".equalsIgnoreCase(word.trim())) {
				//word = word.toLowerCase(); 
				if(words.containsKey(word)) {
					words.replace(word, words.get(word)+1); 
				} else {
					words.put(word,1); //xet gia tri bang 1 
				}
			}
		}
		return words; 
	}
	//Ham gan ten va so lan xuat hien trong chuoi str 
	public void printStatistic(HashMap<String, Integer> words, String X,  List<Appear> list_Appear_Car, List<Appear> list_Appear_Mobile, List<Appear> list_Appear_Tour, List<Appear> list_Appear_CarX) {
		if(X.equals("Car")) {
			for(Map.Entry<String, Integer> e: words.entrySet()) {
				Appear a = new Appear();
				a.setName(e.getKey());
				a.setTotal(e.getValue());
				list_Appear_Car.add(a); 
			}
		} else if(X.equals("Mobile")) {
			for(Map.Entry<String, Integer> e: words.entrySet()) {
				Appear a = new Appear();
				a.setName(e.getKey());
				a.setTotal(e.getValue());
				list_Appear_Mobile.add(a);
			}
		} else if(X.equals("Tour")){
			for(Map.Entry<String, Integer> e: words.entrySet()) {
				Appear a = new Appear();
				a.setName(e.getKey());
				a.setTotal(e.getValue());
				list_Appear_Tour.add(a);
			}
		} else {
			for(Map.Entry<String, Integer> e: words.entrySet()) {
				Appear a = new Appear();
				a.setName(e.getKey());
				a.setTotal(e.getValue());
				list_Appear_CarX.add(a);
			}
		}
	}
	//Ham tim hang xuat hien nhieu nhat trong danh sach 
	public int statistic_AppearMax(String X, List<Appear> list_Appear_Car, List<Appear> list_Appear_Mobile, List<Appear> list_Appear_Tour, List<Appear> list_Appear_CarX) {
		
		int max_Total = 0;
		if(X.equals("Car")) {
			for(int i=0;i<list_Appear_Car.size();i++) {
				if(list_Appear_Car.get(i).getTotal() > max_Total) {
					max_Total = list_Appear_Car.get(i).getTotal(); 
				}
			}
		} else if(X.equals("Mobile")) {
			for(int i=0;i<list_Appear_Mobile.size();i++) {
				if(list_Appear_Mobile.get(i).getTotal() > max_Total) {
					max_Total = list_Appear_Mobile.get(i).getTotal(); 
				}
			}
		} else if(X.equals("Tour")) {
			for(int i=0;i<list_Appear_Tour.size();i++) {
				if(list_Appear_Tour.get(i).getTotal() > max_Total) {
					max_Total = list_Appear_Tour.get(i).getTotal(); 
				}
			}
		} else {
			for(int i=0;i<list_Appear_CarX.size();i++) {
				if(list_Appear_CarX.get(i).getTotal() > max_Total) {
					max_Total = list_Appear_CarX.get(i).getTotal(); 
				}
			}
		}
		return max_Total; 
	}
	//Ham tim san pham co so lan xuat hien it nhat
	public int statistic_AppearMin(String X, List<Appear> list_Appear_Car, List<Appear> list_Appear_Mobile, List<Appear> list_Appear_Tour, List<Appear> list_Appear_CarX) {
		int min_Total = Integer.MAX_VALUE; 
		if(X.equals("Car")) {
			for(int i=0;i<list_Appear_Car.size();i++) {
				if(list_Appear_Car.get(i).getTotal() < min_Total) {
					min_Total = list_Appear_Car.get(i).getTotal(); 
				}
			}
		} else if(X.equals("Mobile")) {
			for(int i=0;i<list_Appear_Mobile.size();i++) {
				if(list_Appear_Mobile.get(i).getTotal() < min_Total) {
					min_Total = list_Appear_Mobile.get(i).getTotal(); 
				}
			}
		} else if(X.equals("Tour")) {
			for(int i=0;i<list_Appear_Tour.size();i++) {
				if(list_Appear_Tour.get(i).getTotal() < min_Total) {
					min_Total = list_Appear_Tour.get(i).getTotal(); 
				}
			}
		} else if(X.equals("CarX")) {
			for(int i=0;i<list_Appear_CarX.size();i++) {
				if(list_Appear_CarX.get(i).getTotal() < min_Total) {
					min_Total = list_Appear_CarX.get(i).getTotal(); 
				}
			}
		}
		return min_Total;
	}
	
	public void binaryOutputFile(List<Product> list) throws IOException {
		
		FileOutputStream fileOut = new FileOutputStream("report.bin", true);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		list.forEach(item -> {
			try {
				out.writeObject(item);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		fileOut.close();
		out.close();
		
	}
	
	public void binaryOutputFileAppear(List<Appear> list) throws IOException {
		FileOutputStream fileOut = new FileOutputStream("report.bin", true);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		list.forEach(item -> {
			try {
				out.writeObject(item);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		fileOut.close();
		out.close();
		
	}
	
	public void showMessage(String str) {
		JOptionPane.showMessageDialog(this, str);
	}

	/**
	 * Create the frame.
	 */
	public StatisticalGUI() throws IOException, ClassNotFoundException {
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(TrangChuGUI.LOCAL_PATH+"statistical.png"));
		this.setTitle("STATISTICAL");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1149, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(233, 252, 250));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH SẢN PHẨM");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(450, 10, 226, 31);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 500, 119);
		contentPane.add(scrollPane);
		
		
		
		table_Car = new JTable();
		table_Car.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null, null, null},
			},
			new String[] {
				"ID", "NAME", "PRICE", "TOTAL", "CAPACITY", "SEAT"
			}
		));
		scrollPane.setViewportView(table_Car);
		
		JLabel lblNewLabel_1 = new JLabel("Danh s\u00E1ch \u00F4 t\u00F4");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 71, 157, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Danh s\u00E1ch Tour du l\u1ECBch");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 230, 165, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 255, 500, 119);
		contentPane.add(scrollPane_1);
		
		
		JPanel backPanel = new JPanel();
		backPanel.setBounds(23, 15, 165, 35);
		backPanel.setBackground(new Color(233, 252, 250));
		contentPane.add(backPanel);
		BufferedImage backBufferedImage = ImageIO.read(new File(TrangChuGUI.LOCAL_PATH+"back_icon.png"));		
		backPanel.setLayout(null);		
		JLabel backImageJLabel = new JLabel(new ImageIcon( 
				backBufferedImage.getScaledInstance(35,35,Image.SCALE_SMOOTH)));
		backImageJLabel.setSize(35,35);
		backPanel.add(backImageJLabel);
		
		JLabel lblHome = new JLabel("Back to Home");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHome.setBounds(45, 0, 124, 35);
		backPanel.add(lblHome);
		
		backPanel.addMouseListener((MouseListener) new MouseListener() {
			
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

				TrangChuGUI trangChuGUI = null;
				try {
					trangChuGUI = new TrangChuGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				trangChuGUI.setLocationRelativeTo(null);
				trangChuGUI.setResizable(false);
				trangChuGUI.setVisible(true);
				dispose();
				
			}
		});
		
		
		table_Tour = new JTable();
		table_Tour.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "NAME", "RPICE", "TOTAL", "DESTINATION", "DATE", "PEOPLE"
			}
		));
		table_Tour.getColumnModel().getColumn(4).setPreferredWidth(102);
		scrollPane_1.setViewportView(table_Tour);
		
		JLabel lblNewLabel_3 = new JLabel("Danh s\u00E1ch Mobile ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(626, 71, 130, 14);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(626, 101, 500, 119);
		contentPane.add(scrollPane_2);
		
		table_Mobile = new JTable();
		table_Mobile.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "NAME", "TOTAL", "PRICE", "BRAND", "BATTERY", "MEMORY"
			}
		));
		scrollPane_2.setViewportView(table_Mobile);
		
		JLabel lblNewLabel_4 = new JLabel("Lựa chọn thống kê: ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 402, 140, 31);
		contentPane.add(lblNewLabel_4);
		
		
		JRadioButton rdbtnMaxPrice = new JRadioButton("Sản phẩm có giá bán cao nhất ");
		rdbtnMaxPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double max_Price_Car = maxPrice("Car");
					double max_Price_Tour = maxPrice("Tour"); 
					double max_Price_Mobile = maxPrice("Mobile");
					double max_Price_CarX = maxPrice("CarX"); 
					List<Product> list_Statistic_Max = new ArrayList<Product>();
					for(int i=0;i<listCar.size();i++) {
						if(listCar.get(i).getProduct_price()==max_Price_Car) {
							list_Statistic_Max.add(listCar.get(i)); 
						}
					}
					for(int i=0;i<listTour.size();i++) {
						if(listTour.get(i).getProduct_price()==max_Price_Tour) {
							list_Statistic_Max.add(listTour.get(i)); 
						}
					}
					for(int i=0;i<listMobile.size();i++) {
						if(listMobile.get(i).getProduct_price()==max_Price_Mobile) {
							list_Statistic_Max.add(listMobile.get(i)); 
						}
					}
					for(int i=0;i<listCarX.size();i++) {
						if(listCarX.get(i).getProduct_price()==max_Price_CarX) {
							list_Statistic_Max.add(listCarX.get(i)); 
						}
					}
					try {
						binaryOutputFile(list_Statistic_Max);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					model_Statistic.setRowCount(0);
					list_Statistic_Max.forEach(item ->{
						model_Statistic.addRow(new Object[] {
								item.getProduct_id(), item.getProduct_name(), item.getProduct_price(), item.getProduct_total()
						}); 
					});
					model_Statistic.fireTableDataChanged();
					showMessage("Thống kê sản phẩm có giá bán cao nhất thành công"); 
					
				} catch(Exception e1) {
					showMessage("error: " + e1.getMessage()); 
				}
			}
		});
		rdbtnMaxPrice.setBounds(209, 407, 209, 23);
		contentPane.add(rdbtnMaxPrice);
		
		JRadioButton rdbtnMinPrice = new JRadioButton("Sản phẩm có giá bán thấp nhất");
		rdbtnMinPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double min_Price_Car = minPrice("Car");
					double min_Price_Tour = minPrice("Tour"); 
					double min_Price_Mobile = minPrice("Mobile"); 
					double min_Price_CarX = minPrice("CarX"); 
					List<Product> list_Statistic_Min = new ArrayList<Product>();
					for(int i=0;i<listCar.size();i++) {
						if(listCar.get(i).getProduct_price()==min_Price_Car) {
							list_Statistic_Min.add(listCar.get(i)); 
						}
					}
					for(int i=0;i<listTour.size();i++) {
						if(listTour.get(i).getProduct_price()==min_Price_Tour) {
							list_Statistic_Min.add(listTour.get(i)); 
						}
					}
					for(int i=0;i<listMobile.size();i++) {
						if(listMobile.get(i).getProduct_price()==min_Price_Mobile) {
							list_Statistic_Min.add(listMobile.get(i)); 
						}
					}
					for(int i=0;i<listCarX.size();i++) {
						if(listCarX.get(i).getProduct_price()==min_Price_CarX) {
							list_Statistic_Min.add(listCarX.get(i)); 
						}
					}
					try {
						binaryOutputFile(list_Statistic_Min);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					model_Statistic.setRowCount(0);
					list_Statistic_Min.forEach(item ->{
						model_Statistic.addRow(new Object[] {
								item.getProduct_id(), item.getProduct_name(), item.getProduct_price(), item.getProduct_total()
						}); 
					});
					model_Statistic.fireTableDataChanged();
					showMessage("Thống kê sản phẩm có giá bán thấp nhất thành công"); 
					
				} catch(Exception e1) {
					showMessage("error: " + e1.getMessage()); 
				}
			}
		});
		rdbtnMinPrice.setBounds(209, 432, 209, 23);
		contentPane.add(rdbtnMinPrice);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 546, 530, 107);
		contentPane.add(scrollPane_3);
		
		table_Statistic = new JTable();
		table_Statistic.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_3.setViewportView(table_Statistic);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(24, 583, 157, 14);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtnToTalMax = new JRadioButton("Sản phẩm có số lượng cao nhất");
		rdbtnToTalMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Long max_Total_Car = maxTotal("Car");
					Long max_Total_Tour = maxTotal("Tour"); 
					Long max_Total_Mobile = maxTotal("Mobile");
					Long max_Total_CarX = maxTotal("CarX"); 
					List<Product> list_Total_Max = new ArrayList<Product>();
					for(int i=0;i<listCar.size();i++) {
						if(listCar.get(i).getProduct_total()==max_Total_Car) {
							list_Total_Max.add(listCar.get(i)); 
						}
					}
					for(int i=0;i<listTour.size();i++) {
						if(listTour.get(i).getProduct_total()==max_Total_Tour) {
							list_Total_Max.add(listTour.get(i)); 
						}
					}
					for(int i=0;i<listMobile.size();i++) {
						if(listMobile.get(i).getProduct_total()==max_Total_Mobile) {
							list_Total_Max.add(listMobile.get(i)); 
						}
					}
					for(int i=0;i<listCarX.size();i++) {
						if(listCarX.get(i).getProduct_total()==max_Total_CarX) {
							list_Total_Max.add(listCarX.get(i)); 
						}
					}
					try {
						binaryOutputFile(list_Total_Max);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
					model_Statistic.setRowCount(0);
					list_Total_Max.forEach(item ->{
						model_Statistic.addRow(new Object[] {
								item.getProduct_id(), item.getProduct_name(), item.getProduct_price(), item.getProduct_total()
						}); 
					});
					model_Statistic.fireTableDataChanged();
					showMessage("Thống kê sản phẩm có số lượng cao nhất thành công");
					
				} catch(Exception e1) {
					showMessage("error: " + e1.getMessage()); 
				}
			}
		});
		rdbtnToTalMax.setBounds(209, 457, 209, 23);
		contentPane.add(rdbtnToTalMax);
		
		JRadioButton rdbtnTotalMin = new JRadioButton("Sản phẩm có số lượng thấp nhất");
		rdbtnTotalMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Long min_Total_Car = minTotal("Car");
					Long min_Total_Tour = minTotal("Tour"); 
					Long min_Total_Mobile = minTotal("Mobile"); 
					Long min_Total_CarX = minTotal("CarX"); 
					List<Product> list_Total_Min = new ArrayList<Product>();
					for(int i=0;i<listCar.size();i++) {
						if(listCar.get(i).getProduct_total()==min_Total_Car) {
							list_Total_Min.add(listCar.get(i)); 
						}
					}
					for(int i=0;i<listTour.size();i++) {
						if(listTour.get(i).getProduct_total()==min_Total_Tour) {
							list_Total_Min.add(listTour.get(i)); 
						}
					}
					for(int i=0;i<listMobile.size();i++) {
						if(listMobile.get(i).getProduct_total()==min_Total_Mobile) {
							list_Total_Min.add(listMobile.get(i)); 
						}
					}
					for(int i=0;i<listCarX.size();i++) {
						if(listCarX.get(i).getProduct_total()==min_Total_CarX) {
							list_Total_Min.add(listCarX.get(i)); 
						}
					}
					
					try {
						binaryOutputFile(list_Total_Min);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
					model_Statistic.setRowCount(0);
					list_Total_Min.forEach(item ->{
						model_Statistic.addRow(new Object[] {
								item.getProduct_id(), item.getProduct_name(), item.getProduct_price(), item.getProduct_total()
						}); 
					});
					model_Statistic.fireTableDataChanged();
					showMessage("Thống kê sản phẩm có số lượng thấp nhất thành công");
					
				} catch(Exception e1) {
					showMessage("error: " + e1.getMessage());
				}
			}
		});
		rdbtnTotalMin.setBounds(209, 482, 209, 23);
		contentPane.add(rdbtnTotalMin);
		
		JLabel lblNewLabel_6 = new JLabel("Thống kê sản phẩm xuất hiện: ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(626, 402, 195, 31);
		contentPane.add(lblNewLabel_6);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(596, 546, 530, 107);
		contentPane.add(scrollPane_4);
		
		ButtonGroup group_Radio = new ButtonGroup(); 
		group_Radio.add(rdbtnMaxPrice);
		group_Radio.add(rdbtnMinPrice);
		group_Radio.add(rdbtnToTalMax);
		group_Radio.add(rdbtnTotalMin);
		
		
		table_Appear = new JTable();
		table_Appear.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null},
			},
			new String[] {
				"Tên hàng", "Số loại sản phẩm"
			}
		));
		table_Appear.getColumnModel().getColumn(0).setPreferredWidth(101);
		table_Appear.getColumnModel().getColumn(1).setPreferredWidth(111);
		scrollPane_4.setViewportView(table_Appear);
		
		JRadioButton rdbtnAppearMax = new JRadioButton("Xuất hiện nhiều nhất");
		rdbtnAppearMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String str_Car = "", str_Mobile = "", str_Tour = "", str_CarX = ""; 
					for(int i=0;i<listCar.size();i++) {
						str_Car = str_Car.concat("@".concat(listCar.get(i).getProduct_name())); 
					}
					for(int i=0;i<listMobile.size();i++) {
						str_Mobile = str_Mobile.concat("@".concat(listMobile.get(i).getProduct_name())); 
					}
					for(int i=0;i<listTour.size();i++) {
						str_Tour = str_Tour.concat("@".concat(listTour.get(i).getProduct_name())); 
					}
					for(int i=0;i<listCarX.size();i++) {
						str_Tour = str_Tour.concat("@".concat(listCarX.get(i).getProduct_name())); 
					}
					for(int i=0;i<listCarX.size();i++) {
						str_CarX = str_CarX.concat("@".concat(listCarX.get(i).getProduct_name())); 
					}
					List<Appear> list_Appear_Car = new ArrayList<Appear>(); 
					List<Appear> list_Appear_Mobile = new ArrayList<Appear>();
					List<Appear> list_Appear_Tour = new ArrayList<Appear>();
					List<Appear> list_Appear_CarX = new ArrayList<Appear>(); 
					
					printStatistic(getStatistic(str_Car,"@"), "Car", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX); 
					printStatistic(getStatistic(str_Mobile,"@"), "Mobile", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX);
					printStatistic(getStatistic(str_Tour,"@"), "Tour", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX);
					printStatistic(getStatistic(str_CarX,"@"), "CarX", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX); 
					
					
					int max_Total_Car = statistic_AppearMax("Car", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX);
					int max_Total_Mobile = statistic_AppearMax("Mobile", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX); 
					int max_Total_Tour = statistic_AppearMax("Tour", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX);  
					int max_Total_CarX = statistic_AppearMax("CarX", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX);  
					
					List<Appear> list_Appear_Max = new ArrayList<Appear>();
					for(int i=0;i<list_Appear_Car.size();i++) {
						if(list_Appear_Car.get(i).getTotal()==max_Total_Car) {
							list_Appear_Max.add(list_Appear_Car.get(i)); 
						}
					}
					for(int i=0;i<list_Appear_Mobile.size();i++) {
						if(list_Appear_Mobile.get(i).getTotal()==max_Total_Mobile) {
							list_Appear_Max.add(list_Appear_Mobile.get(i)); 
						}
					}
					for(int i=0;i<list_Appear_Tour.size();i++) {
						if(list_Appear_Tour.get(i).getTotal()==max_Total_Tour) {
							list_Appear_Max.add(list_Appear_Tour.get(i)); 
						}
					}
					for(int i=0;i<list_Appear_CarX.size();i++) {
						if(list_Appear_CarX.get(i).getTotal()==max_Total_CarX) {
							list_Appear_Max.add(list_Appear_CarX.get(i)); 
						}
					}
					
					try {
						binaryOutputFileAppear(list_Appear_Max);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
					model_Appear.setRowCount(0);
					list_Appear_Max.forEach(item ->{
						model_Appear.addRow(new Object[] {
								item.getName(), item.getTotal()
						}); 
					});
					model_Appear.fireTableDataChanged();
					showMessage("Thống kê loại sản phẩm nhiều nhất thành công");
					
				} catch(Exception e1) {
					showMessage("error: " + e1.getMessage());
				}
			}
		});
		rdbtnAppearMax.setBounds(883, 407, 195, 23);
		contentPane.add(rdbtnAppearMax);
		
		JRadioButton rdbtnAppearMin = new JRadioButton("Xuất hiện ít nhất");
		rdbtnAppearMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String str_Car = "", str_Mobile = "", str_Tour = "", str_CarX=""; 
					for(int i=0;i<listCar.size();i++) {
						str_Car = str_Car.concat("@".concat(listCar.get(i).getProduct_name())); 
					}
					for(int i=0;i<listMobile.size();i++) {
						str_Mobile = str_Mobile.concat("@".concat(listMobile.get(i).getProduct_name())); 
					}
					for(int i=0;i<listTour.size();i++) {
						str_Tour = str_Tour.concat("@".concat(listTour.get(i).getProduct_name())); 
					}
					for(int i=0;i<listCarX.size();i++) {
						str_CarX = str_CarX.concat("@".concat(listCarX.get(i).getProduct_name())); 
					}
					List<Appear> list_Appear_Car = new ArrayList<Appear>(); 
					List<Appear> list_Appear_Mobile = new ArrayList<Appear>();
					List<Appear> list_Appear_Tour = new ArrayList<Appear>();
					List<Appear> list_Appear_CarX = new ArrayList<Appear>();
					
					
					printStatistic(getStatistic(str_Car,"@"), "Car", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX); 
					printStatistic(getStatistic(str_Mobile,"@"), "Mobile", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX);
					printStatistic(getStatistic(str_Tour,"@"), "Tour", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX); 
					printStatistic(getStatistic(str_CarX,"@"), "CarX", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX); 
					
					int min_Total_Car = statistic_AppearMin("Car", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX);
					int min_Total_Mobile = statistic_AppearMin("Mobile", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX); 
					int min_Total_Tour = statistic_AppearMin("Tour", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX); 
					int min_Total_CarX = statistic_AppearMin("CarX", list_Appear_Car, list_Appear_Mobile, list_Appear_Tour, list_Appear_CarX);
					
					List<Appear> list_Appear_Min = new ArrayList<Appear>();
					for(int i=0;i<list_Appear_Car.size();i++) {
						if(list_Appear_Car.get(i).getTotal()==min_Total_Car) {
							list_Appear_Min.add(list_Appear_Car.get(i)); 
						}
					}
					for(int i=0;i<list_Appear_Mobile.size();i++) {
						if(list_Appear_Mobile.get(i).getTotal()==min_Total_Mobile) {
							list_Appear_Min.add(list_Appear_Mobile.get(i)); 
						}
					}
					for(int i=0;i<list_Appear_Tour.size();i++) {
						if(list_Appear_Tour.get(i).getTotal()==min_Total_Tour) {
							list_Appear_Min.add(list_Appear_Tour.get(i)); 
						}
					}
					for(int i=0;i<list_Appear_CarX.size();i++) {
						if(list_Appear_CarX.get(i).getTotal()==min_Total_CarX) {
							list_Appear_Min.add(list_Appear_CarX.get(i)); 
						}
					}
					try {
						binaryOutputFileAppear(list_Appear_Min);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
					model_Appear.setRowCount(0);
					list_Appear_Min.forEach(item ->{
						model_Appear.addRow(new Object[] {
								item.getName(), item.getTotal()
						}); 
					});
					model_Appear.fireTableDataChanged();
					showMessage("Thống kê loại sản phẩm ít nhất thành công");
					
				}catch(Exception e1) {
					showMessage("error: " + e1.getMessage());
				}
			}
		});
		rdbtnAppearMin.setBounds(883, 457, 195, 23);
		contentPane.add(rdbtnAppearMin);
		
		ButtonGroup group_Radio_Appear = new ButtonGroup(); 
		group_Radio_Appear.add(rdbtnAppearMax);
		group_Radio_Appear.add(rdbtnAppearMin);
		
		JLabel lblNewLabel_7 = new JLabel("Bảng thống kê theo lựa chọn");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 522, 186, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Bảng thống kê sản phẩm xuất hiện");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(596, 522, 219, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Danh sách CarX");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(626, 232, 140, 14);
		contentPane.add(lblNewLabel_9);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(626, 255, 497, 125);
		contentPane.add(scrollPane_5);
		
		table_CarX = new JTable();
		table_CarX.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "NAME", "PRICE", "TOTAL", "COLOR", "CAPACITY"
			}
		));
		scrollPane_5.setViewportView(table_CarX);

		initTable_Car(); 
		initTable_Tour(); 
		initTable_Mobile(); 
		initTable_CarX(); 
		
		initTable_Statistic(); 
		initTable_Appear(); 
		
	}
}
