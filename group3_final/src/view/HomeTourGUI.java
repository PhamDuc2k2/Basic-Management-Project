package view;

import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import files.FileTour;
import model.entities.Tour;
import model.lists.ListTours;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;

/**
 *
 * @author admin
 */
public class HomeTourGUI extends javax.swing.JFrame {

    /**
     * Creates new form Swing
     */
    final ListTours xmanager = new ListTours();

	public static final String LOCAL_PATH = TrangChuGUI.LOCAL_PATH;
    public Tour getTour() {
        Tour t = new Tour();
        t.setProduct_id(id.getText().trim());
        t.setProduct_name(name.getText().trim());
        t.setProduct_price(Double.valueOf(price.getText().trim()));
        t.setProduct_total(Long.valueOf(total.getText().trim()));
        t.setTour_place(place.getText().trim());
        t.setTour_time(Integer.valueOf(time.getText().trim()));
        return t;
    }
    
    public void setTour() {
        id.setText("");
        name.setText("");
        price.setText("");
        total.setText("");
        name.setText("");
        place.setText("");
        time.setText("");
    }
    
    public void setTable(List<Tour> list) {
        DefaultTableModel dtm = (DefaultTableModel) tableTour.getModel();
        dtm.setRowCount(list.size());
        tableTour.setModel(dtm);
        for (int i = 0; i < list.size(); i++) {
            Tour tt = list.get(i);
            tableTour.setValueAt(tt.getProduct_id(), i, 0);
            tableTour.setValueAt(tt.getProduct_name(), i, 1);
            tableTour.setValueAt(tt.getProduct_price(), i, 2);
            tableTour.setValueAt(tt.getProduct_total(), i, 3);
            tableTour.setValueAt(tt.getTour_place(), i, 4);
            tableTour.setValueAt(tt.getTour_time(), i, 5);
        }
    }
    
    public boolean checkValidate() {
        if (id.getText().trim().isEmpty()) return false;
        if (name.getText().trim().isEmpty()) return false;
        if (price.getText().trim().isEmpty()) return false;
        if (total.getText().trim().isEmpty()) return false;
        if (place.getText().trim().isEmpty()) return false;
        if (time.getText().trim().isEmpty()) return false;
        return true;
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(
                    this.getContentPane(), 
                    message.toString(), "Message",
                    JOptionPane.WARNING_MESSAGE
        );
    }   

    public HomeTourGUI() throws IOException {
    	 try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(HomeTourGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(HomeTourGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(HomeTourGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(HomeTourGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(TrangChuGUI.LOCAL_PATH+"tour.png"));
		this.setTitle("HOME TOUR");
    	getContentPane().setBackground(new Color(233, 252, 250));
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws IOException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws IOException {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTour = new javax.swing.JTable();
        them = new javax.swing.JButton();
        place = new javax.swing.JTextField();
        sua = new javax.swing.JButton();
        xoa = new javax.swing.JButton();
        searchByName = new javax.swing.JButton();
        searchByPrice = new javax.swing.JButton();
        searchByTime = new javax.swing.JButton();
        sortByPrice = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        on = new javax.swing.JRadioButton();
        off = new javax.swing.JRadioButton();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("INPUT INFORMATION");

        jLabel2.setText("id:");
        JPanel backPanel = new JPanel();
		backPanel.setBounds(23, 15, 165, 35);
		backPanel.setBackground(new Color(233, 252, 250));
		getContentPane().add(backPanel);
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
		
		backPanel.addMouseListener(new MouseListener() {
			
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
				dispose();
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

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel3.setText("name:");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel4.setText("price:");

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        jLabel5.setText("total:");

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        jLabel6.setText("place:");

        jLabel7.setText("time:");

        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });

        tableTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "NAME", "PRICE", "TOTAL", "PLACE", "TIME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Long.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTour.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableTour);
        if (tableTour.getColumnModel().getColumnCount() > 0) {
            tableTour.getColumnModel().getColumn(0).setResizable(false);
            tableTour.getColumnModel().getColumn(1).setResizable(false);
            tableTour.getColumnModel().getColumn(2).setResizable(false);
            tableTour.getColumnModel().getColumn(3).setResizable(false);
            tableTour.getColumnModel().getColumn(4).setResizable(false);
            tableTour.getColumnModel().getColumn(5).setResizable(false);
        }
        
        tableTour.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int row = tableTour.getSelectedRow();
        		id.setText(String.valueOf(tableTour.getValueAt(row, 0)));
        		name.setText(String.valueOf(tableTour.getValueAt(row, 1)));
        		price.setText(String.valueOf(tableTour.getValueAt(row, 2)));
        		total.setText(String.valueOf(tableTour.getValueAt(row, 3)));
        		place.setText(String.valueOf(tableTour.getValueAt(row, 4)));
        		time.setText(String.valueOf(tableTour.getValueAt(row, 5)));
        	}
        
        });
        
        hienthiActionPerformed();

        them.setText("Add");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });

        sua.setText("Edit");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });

        xoa.setText("Delete");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });

        searchByName.setText("Search by name");
        searchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNameActionPerformed(evt);
            }
        });

        searchByPrice.setText("Search by price");
        searchByPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByPriceActionPerformed(evt);
            }
        });

        searchByTime.setText("Search by time");
        searchByTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByTimeActionPerformed(evt);
            }
        });

        sortByPrice.setText("Sort by price");
        sortByPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByPriceActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("MENU");

        jLabel9.setText("Reset");

        buttonGroup1.add(on);
        on.setSelected(true);
        on.setText("On");
        on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onActionPerformed(evt);
            }
        });

        buttonGroup1.add(off);
        off.setText("Off");
        
        JButton btnReset = new JButton("RESET");
        btnReset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		resetActionPerformed();
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(43)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(id, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(price, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(name, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(total, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(place))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(time, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
        					.addGap(80)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(on, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(off, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(searchByName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(searchByTime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(jLabel8)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(them, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        								.addGap(52)
        								.addComponent(sua, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(30)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
        						.addComponent(searchByPrice, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
        						.addComponent(xoa, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(btnReset)
        							.addComponent(sortByPrice, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(97)
        					.addComponent(jLabel1)))
        			.addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(62)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(jLabel8))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(them)
        				.addComponent(sua)
        				.addComponent(xoa))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(15)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel3)
        						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(15)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel4)
        						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel5)
        						.addComponent(total, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(15)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel6)
        						.addComponent(place, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(15)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel7)
        						.addComponent(time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(30)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(searchByName)
        						.addComponent(searchByPrice))
        					.addGap(30)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(searchByTime)
        						.addComponent(sortByPrice))
        					.addGap(30)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel9)
        						.addComponent(on)
        						.addComponent(off)
        						.addComponent(btnReset))))
        			.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
        			.addGap(40))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeActionPerformed

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        // TODO add your handling code here:
        if (!checkValidate()) {
            showMessage("Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        Tour t = getTour();
        boolean can = true;
        for (Tour i : xmanager.getTour()) {
            if (i.getProduct_id().equals(t.getProduct_id())) {
                can = false;
                break;
            }
        }
        if (!can) {
            showMessage("Đã tồn tại id này!");
            return;
        }
        xmanager.getM().addTour(t);
        List<Tour> list = new LinkedList<>();
        for (Tour i: xmanager.getTour()) {
            list.add(i);
        }
        try {
			FileTour.outputList(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
        setTable(list);
        if (on.isSelected()) setTour();
    }//GEN-LAST:event_themActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        // TODO add your handling code here:
        if (!checkValidate()) {
            showMessage("Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        Tour t = getTour();
        boolean can = xmanager.getM().editTour(t);
        if (!can) {
            showMessage("Không tồn tại id này!");
            return;
        }
        List<Tour> list = new LinkedList<>();
        for (Tour i: xmanager.getTour()) {
            list.add(i);
        }
        try {
        	FileTour.outputList(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
        setTable(list);
        if (on.isSelected()) setTour();
    }//GEN-LAST:event_suaActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
        // TODO add your handling code here:
        if (!checkValidate()) {
            showMessage("Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        Tour t = getTour();
        boolean can = xmanager.getM().delTour(t);
        if (!can) {
            showMessage("Không tồn tại id này!");
            return;
        }
        List<Tour> list = new LinkedList<>();
        list = xmanager.getTour();
        try {
        	FileTour.outputList(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
        setTable(list);
        if (on.isSelected()) setTour();
    }//GEN-LAST:event_xoaActionPerformed

    private void hienthiActionPerformed() {//GEN-FIRST:event_hienthiActionPerformed
        // TODO add your handling code here:
        List<Tour> list = new LinkedList<>();
        
        
        try {
        	xmanager.setTour(FileTour.inputList());
        	list = xmanager.getTour();
        	FileTour.outputList(list);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        setTable(list);
        if (on.isSelected()) setTour();
    }//GEN-LAST:event_hienthiActionPerformed
    
    private void resetActionPerformed() {
    	List<Tour> list = new LinkedList<>();
    	try {
			list = FileTour.inputList();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	setTable(list);
    	if(on.isSelected()) setTour();
    }

    private void searchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByNameActionPerformed
        // TODO add your handling code here:
        if (name.getText().trim().toString().isEmpty()) {
            showMessage("Vui lòng nhập tên!");
            return;
        }
        List<Tour> list = new LinkedList<>();
        list = xmanager.getM().searchTourByName(name.getText().trim());
        setTable(list);
        if (on.isSelected()) setTour();
    }//GEN-LAST:event_searchByNameActionPerformed

    private void searchByPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByPriceActionPerformed
        // TODO add your handling code here:
        if (price.getText().trim().toString().isEmpty()) {
            showMessage("Vui lòng nhập giá!");
            return;
        }
        List<Tour> list = new LinkedList<>();
        list = xmanager.getM().searchTourByPrice(Double.valueOf(price.getText().trim()));
        setTable(list);
        if (on.isSelected()) setTour();
    }//GEN-LAST:event_searchByPriceActionPerformed

    private void searchByTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByTimeActionPerformed
        // TODO add your handling code here:
        if (time.getText().trim().toString().isEmpty()) {
            showMessage("Vui lòng nhập thời gian!");
            return;
        }
        List<Tour> list = new LinkedList<>();
        list = xmanager.getM().searchTourByTime(Integer.valueOf(time.getText().trim()));
        setTable(list);
        if (on.isSelected()) setTour();
    }//GEN-LAST:event_searchByTimeActionPerformed

    private void sortByPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByPriceActionPerformed
        // TODO add your handling code here:
        List<Tour> list = new LinkedList<>();
        list = xmanager.getM().sortedTour(1.1);
        setTable(list);
        if (on.isSelected()) setTour();
    }//GEN-LAST:event_sortByPriceActionPerformed

    private void onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JRadioButton off;
    private javax.swing.JRadioButton on;
    private javax.swing.JTextField place;
    private javax.swing.JTextField price;
    private javax.swing.JButton searchByName;
    private javax.swing.JButton searchByPrice;
    private javax.swing.JButton searchByTime;
    private javax.swing.JButton sortByPrice;
    private javax.swing.JButton sua;
    private javax.swing.JTable tableTour;
    private javax.swing.JButton them;
    private javax.swing.JTextField time;
    private javax.swing.JTextField total;
    private javax.swing.JButton xoa;
}
