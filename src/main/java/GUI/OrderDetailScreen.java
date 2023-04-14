/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.CategoryBLL;
import BLL.VegetableBLL;
import Entity.Category;
import Entity.Vegetable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class OrderDetailScreen extends JFrame{
    int amountClone;
    Calendar calendar = Calendar.getInstance();
    
    JLabel labOrderDetail, labVegetableID, labVegetableName, labCategory,
           labUnit, labAmount, labPrice, labDate, labTotal, labTotalPrice, labNote;
    JTextField txtSearch, txtVegetableID, txtCategory, txtVegetableName, txtUnit, txtAmount, txtPrice, txtDate, txtTotal, txtTotalPrice, txtNote;
    JButton btnSearch, btnCancel, btnMinus, btnPlus, btnSort, btnAdd, btnEdit, btnDelete, btnFinish;
    JScrollPane pnlStock, pnlOrder;
    JTable tabStock, tabOrder;
    JComboBox cbbSort;
    DefaultTableModel stockTable, orderTable;
    MenuScreen menu;
    
    VegetableBLL vegetableBLL;
    CategoryBLL categoryBLL;
    List<Vegetable> vegetableList;
    List<Category> categoryList;
    Vegetable selectedVegetable; 
    Object[][] category;
    
    public OrderDetailScreen(MenuScreen menu, int customerID){
        this.menu = menu;
        this.setPreferredSize(new Dimension(1500,800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        
        vegetableBLL = new VegetableBLL();
        vegetableList = vegetableBLL.loadVegetable();
        categoryBLL = new CategoryBLL();
        categoryList = categoryBLL.loadCategory();
        category = categoryBLL.convertList(categoryList);
        
        GUI();
        ShowVegetable();
        this.pack();
        this.setLocationRelativeTo(null);       
    }
    
    private void GUI(){
        labOrderDetail = new JLabel("ORDER DETAIL");
            labOrderDetail.setForeground(Color.black);
            labOrderDetail.setBounds( 20 , 5 , 240 , 30 );
            labOrderDetail.setFont(new Font( "Jaldi" , Font.BOLD , 20 ));
        
        labVegetableID = new JLabel("Vegetable ID");
            labVegetableID.setForeground(Color.black);
            labVegetableID.setBounds( 480 , 80 , 240 , 30 );
            labVegetableID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        labCategory = new JLabel("Category");
            labCategory.setForeground(Color.black);
            labCategory.setBounds( 480 , 160 , 240 , 30 );
            labCategory.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));  
            
        labVegetableName= new JLabel("Vegetable Name");
            labVegetableName.setForeground(Color.black);
            labVegetableName.setBounds( 480 , 240 , 240 , 30 );
            labVegetableName.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labUnit = new JLabel("Unit");
            labUnit.setForeground(Color.black);
            labUnit.setBounds( 480 , 320 , 240 , 30 );
            labUnit.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labAmount = new JLabel("Amount");
            labAmount.setForeground(Color.black);
            labAmount.setBounds( 480 , 400 , 240 , 30 );
            labAmount.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labPrice = new JLabel("Price");
            labPrice.setForeground(Color.black);
            labPrice.setBounds( 480 , 480 , 240 , 30 );
            labPrice.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        labTotalPrice = new JLabel("Total Price");
            labTotalPrice.setForeground(Color.black);
            labTotalPrice.setBounds( 480 , 560 , 240 , 30 );
            labTotalPrice.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labDate = new JLabel("Date");
            labDate.setForeground(Color.black);
            labDate.setBounds( 900 , 520 , 240 , 30 );
            labDate.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labTotal = new JLabel("Total");
            labTotal.setForeground(Color.black);
            labTotal.setBounds( 1180 , 520 , 240 , 30 );
            labTotal.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labNote = new JLabel("Note");
            labNote.setForeground(Color.black);
            labNote.setBounds( 900 , 600 , 240 , 30 );
            labNote.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        txtSearch = new JTextField();
            txtSearch.setBounds( 20 , 40 , 300 , 30 );
            txtSearch.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtSearch.setForeground(Color.black);
            
        txtVegetableID = new JTextField();
            txtVegetableID.setBounds( 485 , 110 , 285 , 40 );
            txtVegetableID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtVegetableID.setForeground(Color.black);
            txtVegetableID.setEnabled(false);
            
        txtCategory = new JTextField();
            txtCategory.setBounds( 485 , 190 , 285 , 40 );
            txtCategory.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtCategory.setBackground(Color.white);
            txtCategory.setEnabled(false);
            
        txtVegetableName = new JTextField();
            txtVegetableName.setBounds( 485 , 270 , 285 , 40 );
            txtVegetableName.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtVegetableName.setForeground(Color.black);
            txtVegetableName.setEnabled(false);
            
            
        txtUnit = new JTextField();
            txtUnit.setBounds( 485 , 350 , 285 , 40 );
            txtUnit.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtUnit.setForeground(Color.black);
            txtUnit.setEnabled(false);
            
        txtAmount = new JTextField();
            txtAmount.setBounds( 540 , 430 , 150 , 40 );
            txtAmount.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtAmount.setForeground(Color.black);
            txtAmount.addKeyListener(new CustomKeyListener());
        
        txtPrice = new JTextField();
            txtPrice.setBounds( 485 , 510 , 285 , 40 );
            txtPrice.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtPrice.setForeground(Color.black);
            txtPrice.setEnabled(false);
         
        txtTotalPrice = new JTextField();
            txtTotalPrice.setBounds( 485 , 590 , 285 , 40 );
            txtTotalPrice.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtTotalPrice.setForeground(Color.black);
            txtTotalPrice.setEnabled(false);
            
        txtDate = new JTextField();
            txtDate.setBounds( 905 , 550 , 255 , 40 );
            txtDate.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtDate.setForeground(Color.black);
            txtDate.setEnabled(false);
            txtDate.setText(Integer.toString(calendar.get(Calendar.YEAR)) + "/" +
                            Integer.toString(calendar.get(Calendar.MONTH)) + "/" +
                            Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)));
            
        txtTotal = new JTextField();
            txtTotal.setBounds( 1185 , 550 , 255 , 40 );
            txtTotal.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtTotal.setForeground(Color.black);
            txtTotal.setEnabled(false);
            
        txtNote = new JTextField();
            txtNote.setBounds( 905 , 630 , 535 , 40 );
            txtNote.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtNote.setForeground(Color.black);
        
        btnSearch = new JButton("Search");
            btnSearch.setBackground(Color.black);
            btnSearch.setForeground(Color.WHITE);
            btnSearch.setBorder(null);
            btnSearch.setFocusable(false);
            btnSearch.setBounds( 330 , 40 , 100 , 29 );
            btnSearch.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnSort = new JButton("Sort");
            btnSort.setBackground(Color.black);
            btnSort.setForeground(Color.WHITE);
            btnSort.setBorder(null);
            btnSort.setFocusable(false);
            btnSort.setBounds( 230 , 85 , 100 , 29 );
            btnSort.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnMinus = new JButton("-");
            btnMinus.setBackground(Color.WHITE);
            btnMinus.setForeground(Color.black);
            btnMinus.setBorder(null);
            btnMinus.setFocusable(false);
            btnMinus.setBounds( 485 , 430 , 40, 40 );
            btnMinus.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnPlus = new JButton("+");
            btnPlus.setBackground(Color.WHITE);
            btnPlus.setForeground(Color.black);
            btnPlus.setBorder(null);
            btnPlus.setFocusable(false);
            btnPlus.setBounds( 700 , 430 , 40 , 40 );
            btnPlus.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnAdd = new JButton("Add");
            btnAdd.setBackground(Color.black);
            btnAdd.setForeground(Color.WHITE);
            btnAdd.setBorder(null);
            btnAdd.setFocusable(false);
            btnAdd.setBounds( 485 , 670 , 100 , 29 );
            btnAdd.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            btnAdd.setEnabled(false);
            
        btnEdit = new JButton("Edit");
            btnEdit.setBackground(Color.black);
            btnEdit.setForeground(Color.WHITE);
            btnEdit.setBorder(null);
            btnEdit.setFocusable(false);
            btnEdit.setBounds( 600 , 670 , 100 , 29 );
            btnEdit.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            btnEdit.setEnabled(false);
            
        btnDelete = new JButton("Delete");
            btnDelete.setBackground(Color.black);
            btnDelete.setForeground(Color.WHITE);
            btnDelete.setBorder(null);
            btnDelete.setFocusable(false);
            btnDelete.setBounds( 715 , 670 , 100 , 29 );
            btnDelete.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            btnDelete.setEnabled(false);
        
        btnCancel = new JButton("Cancel");
            btnCancel.setBackground(Color.red);
            btnCancel.setForeground(Color.WHITE);
            btnCancel.setBorder(null);
            btnCancel.setFocusable(false);
            btnCancel.setBounds( 20 , 720 , 100 , 29 );
            btnCancel.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnFinish = new JButton("Finish");
            btnFinish.setBackground(Color.BLACK);
            btnFinish.setForeground(Color.WHITE);
            btnFinish.setBorder(null);
            btnFinish.setFocusable(false);
            btnFinish.setBounds( 1370 , 720 , 100 , 29 );
            btnFinish.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
        
        stockTable = new DefaultTableModel(new Object[] { "Vegetable ID", "Category", "Veg Name", "Unit" , "Amount", "Price" }, 0);
        
        orderTable = new DefaultTableModel(new Object[] { "Vegetable ID", "Category", "Veg Name", "Unit" , "Amount" , "Price", "Total Price" }, 0);
        
        tabStock = new JTable(stockTable);
            tabStock.setBackground(Color.white);
            tabStock.getTableHeader().setOpaque(false);
            tabStock.getTableHeader().setBackground(Color.BLACK);
            tabStock.getTableHeader().setForeground(Color.WHITE);
            
        tabOrder = new JTable(orderTable);
            tabStock.setBackground(Color.white);
            tabStock.getTableHeader().setOpaque(false);
            tabStock.getTableHeader().setBackground(Color.BLACK);
            tabStock.getTableHeader().setForeground(Color.WHITE);
        
        pnlStock = new JScrollPane(tabStock);
            pnlStock.setBounds( 20 , 150 , 420, 500);
            
        pnlOrder = new JScrollPane(tabOrder);
            pnlOrder.setBounds( 900 , 20 , 580, 500);
        
        cbbSort = new JComboBox();
            cbbSort.setBounds( 20 , 80 , 170 , 40 );
            cbbSort.setFont(new Font( "Jaldi" , Font.BOLD , 16 )); 
            cbbSort.setBackground(Color.WHITE);
            for(int i = 0; i < category.length; i++) {
                cbbSort.addItem(category[i][1]);
            }
            
        tabStock.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    btnAdd.setEnabled(true);
                    btnEdit.setEnabled(false);
                    btnDelete.setEnabled(false);
                    int row = tabStock.getSelectedRow();
                    if (row >= 0 ){
                    txtVegetableID.setText(Integer.toString((int) tabStock.getValueAt(row,0)));
                    txtCategory.setText(tabStock.getValueAt(row,1).toString());
                    txtVegetableName.setText(tabStock.getValueAt(row,2).toString());
                    txtUnit.setText(tabStock.getValueAt(row,3).toString());
                    amountClone = (int)tabStock.getValueAt(row,4);
                    txtAmount.setText(Integer.toString(1));
                    txtPrice.setText(Float.toString((float) tabStock.getValueAt(row,5)));
                    txtTotalPrice.setText(Float.toString((float) tabStock.getValueAt(row,5)));
                    }
                }    
                });
        
        tabOrder.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    btnAdd.setEnabled(false);
                    btnEdit.setEnabled(true);
                    btnDelete.setEnabled(true);
                    int row = tabOrder.getSelectedRow();
                    if (row >= 0 ){
                    txtVegetableID.setText(Integer.toString((int) tabOrder.getValueAt(row,0)));
                    txtCategory.setText(tabOrder.getValueAt(row,1).toString());
                    txtVegetableName.setText(tabOrder.getValueAt(row,2).toString());
                    txtUnit.setText(tabOrder.getValueAt(row,3).toString());
                    txtAmount.setText(Integer.toString((int) tabOrder.getValueAt(row,4)));
                    txtPrice.setText(Float.toString((float) tabOrder.getValueAt(row,5)));
                    txtTotalPrice.setText(Float.toString((float) tabOrder.getValueAt(row,6)));
                    }
                }    
                });
        
        btnPlus.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e){
                        int flag = Integer.parseInt(txtAmount.getText());
                        if(flag < amountClone){
                            txtAmount.setText(Integer.toString(flag+ 1));
                            txtTotalPrice.setText(Float.toString(Float.parseFloat(txtPrice.getText())*(flag+1)));
                        }
                    }
            });    
        
        btnMinus.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e){
                        int flag = Integer.parseInt(txtAmount.getText());
                        if(flag > 1){
                            txtAmount.setText(Integer.toString(flag - 1));
                            txtTotalPrice.setText(Float.toString(Float.parseFloat(txtPrice.getText())*(flag - 1)));
                        }
                    }
            });
        
        btnAdd.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e){
                        int VegetableID = Integer.parseInt(txtVegetableID.getText());
                        String Category = txtCategory.getText();
                        String VegetableName = txtVegetableName.getText();
                        String Unit = txtUnit.getText();
                        int Amount = Integer.parseInt(txtAmount.getText());
                        float Price = Float.parseFloat(txtPrice.getText());
                        float TotalPrice = Float.parseFloat(txtTotalPrice.getText());
                        if ( tabOrder.getRowCount() != 0){ 
                            boolean flag = true;
                            for (int i = 0; i < tabOrder.getRowCount(); i++){
                                if ( orderTable.getValueAt( i , 0).equals(VegetableID)){
                                    JOptionPane.showMessageDialog(rootPane, "Product already in the table!" , "Wanning!",  JOptionPane.INFORMATION_MESSAGE);
                                    flag = false;
                                    break;
                                }
                            }
                                if (flag){
                                    orderTable.addRow(new Object[]{VegetableID, Category, VegetableName, Unit, Amount, Price, TotalPrice});

                                }
                            
                        }else{
                            orderTable.addRow(new Object[]{VegetableID, Category, VegetableName, Unit, Amount, Price, TotalPrice});
                        }
                        calTotal();
                    }
            });
        
        btnEdit.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        int VegetableID = Integer.parseInt(txtVegetableID.getText());
                        for (int i = 0; i < tabOrder.getRowCount(); i++){
                            if ( orderTable.getValueAt( i , 0).equals(VegetableID)){
                                orderTable.setValueAt(Integer.parseInt(txtAmount.getText()),i,4);
                                orderTable.setValueAt(Float.parseFloat(txtTotalPrice.getText()), i, 6);
                                break;
                            }
                        }
                        calTotal();
                    }
            });    
        
        btnDelete.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        int VegetableID = Integer.parseInt(txtVegetableID.getText());
                        for (int i = 0; i < tabOrder.getRowCount(); i++){
                            if ( orderTable.getValueAt( i , 0).equals(VegetableID)){
                                orderTable.removeRow(i);
                                break;
                            }
                        }
                        calTotal();
                    }
            });
        
        btnCancel.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        if ( JOptionPane.showConfirmDialog(menu,"Do you want to cancel order?","Confirm",JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
                            return;
                            }
                        menu.setVisible(true);
                        dispose();
                    }
            });
        
        btnFinish.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        if ( JOptionPane.showConfirmDialog(menu,"Do you want to finish order?","Confirm",JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
                            return;
                            }
                        
                        //add code here
                        
                        menu.setVisible(true);
                        dispose();
                    }
            });  
            
        this.add(labOrderDetail);
        this.add(labVegetableID);
        this.add(labUnit);
        this.add(labCategory);
        this.add(labVegetableName);
        this.add(labAmount);
        this.add(labPrice);
        this.add(labTotalPrice);
        this.add(labDate);
        this.add(labTotal);
        this.add(labNote);
        this.add(txtSearch);
        this.add(txtVegetableID);
        this.add(txtUnit);
        this.add(txtVegetableName);
        this.add(txtCategory);
        this.add(txtAmount);
        this.add(txtPrice);
        this.add(txtTotalPrice);
        this.add(txtDate);
        this.add(txtTotal);
        this.add(txtNote);
        this.add(btnSearch);
        this.add(btnSort);
        this.add(btnMinus);
        this.add(btnPlus);
        this.add(btnAdd);
        this.add(btnEdit);
        this.add(btnDelete);
        this.add(btnCancel);
        this.add(btnFinish);
        this.add(pnlStock);
        this.add(pnlOrder);
        this.add(cbbSort);
    }
    
    public void ShowVegetable(){
        Object[][] table = vegetableBLL.convertList(vegetableList,false);
        stockTable.setRowCount(0);
        
        for(int i = 0; i < table.length; i++) {
            stockTable.addRow(table[i]);
        }
        tabStock.setModel(stockTable);
    }
    
    public void calTotal(){
        float total = 0;
        for (int i = 0; i < tabOrder.getRowCount(); i++){
            total = total + (float)orderTable.getValueAt(i, 6); 
        }
        txtTotal.setText(Float.toString(total));
    }
    
    class CustomKeyListener implements KeyListener {
        public void keyTyped(KeyEvent e) {
        }
 
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                int clone = Integer.parseInt(txtAmount.getText());
                if(clone > 0)
                    txtTotalPrice.setText(Float.toString(Float.parseFloat(txtPrice.getText())*clone));
                else{
                    JOptionPane.showMessageDialog(menu, "Invalid number!");
                }
            }
        }
 
        public void keyReleased(KeyEvent e) {
        }
    }
}
