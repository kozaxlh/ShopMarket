/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.VegetableBLL;
import BLL.CategoryBLL;
import Entity.Category;
import Entity.Vegetable;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class StockPanel extends JPanel{
    JLabel labStock, labVegetableID, labVegetableName, labCategoryID,
           labUnit, labAmount, labPrice, labStockImage, labPictrue;
    JTextField txtVegetableID, txtCategoryID, txtVegetableName, txtUnit, txtAmount, txtPrice, txtSearch, txtURL;
    JTable tabStock;
    JButton btnAdd, btnClear, btnDelete, btnEdit, btnSearch, btnChooseImage;
    JScrollPane pnlTable;
    DefaultTableModel tableModel;
    MenuScreen menu; 
    
    VegetableBLL vegetableBLL;
    CategoryBLL categoryBLL;
    List<Vegetable> vegetableList;
    Vegetable selectedVegetable;
    int vegetableIndex;
    public StockPanel(){
        super();
        vegetableBLL = new VegetableBLL();
        categoryBLL = new CategoryBLL();
        vegetableList = vegetableBLL.loadVegetable();
        GUI();
        Show();
    }
   
    private void GUI(){ 
        this.setBounds(0,0,1500, 750);
        this.setVisible(true);
        this.setLayout(null);
        
        labStock = new JLabel("STOCK MANAGER");
            labStock.setForeground(Color.black);
            labStock.setBounds( 30 , 5 , 240 , 30 );
            labStock.setFont(new Font( "Jaldi" , Font.BOLD , 20 ));
        
        labVegetableID = new JLabel("Vegetable ID");
            labVegetableID.setForeground(Color.black);
            labVegetableID.setBounds( 50 , 40 , 240 , 30 );
            labVegetableID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        labCategoryID = new JLabel("Category ID");
            labCategoryID.setForeground(Color.black);
            labCategoryID.setBounds( 50 , 120 , 240 , 30 );
            labCategoryID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));  
            
        labVegetableName= new JLabel("Vegetable Name");
            labVegetableName.setForeground(Color.black);
            labVegetableName.setBounds( 50 , 200 , 240 , 30 );
            labVegetableName.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labUnit = new JLabel("Unit");
            labUnit.setForeground(Color.black);
            labUnit.setBounds( 50 , 280 , 240 , 30 );
            labUnit.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labAmount = new JLabel("Amount");
            labAmount.setForeground(Color.black);
            labAmount.setBounds( 50 , 360 , 240 , 30 );
            labAmount.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labPrice = new JLabel("Price");
            labPrice.setForeground(Color.black);
            labPrice.setBounds( 50 , 440 , 240 , 30 );
            labPrice.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        labStockImage = new JLabel("Image");
            labStockImage.setForeground(Color.black);
            labStockImage.setBounds( 520 , 40 , 240 , 30 );
            labStockImage.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labPictrue = new JLabel("Picture Here!");
            labPictrue.setBackground(Color.black);
            labPictrue.setBounds( 530 , 70 , 250 , 250 );
            labPictrue.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        txtVegetableID = new JTextField();
            txtVegetableID.setBounds( 55 , 70 , 285 , 40 );
            txtVegetableID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtVegetableID.setForeground(Color.black);
            
        txtCategoryID = new JTextField();
            txtCategoryID.setBounds( 55 , 150 , 285 , 40 );
            txtCategoryID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtCategoryID.setBackground(Color.white);
            
        txtVegetableName = new JTextField();
            txtVegetableName.setBounds( 55 , 230 , 285 , 40 );
            txtVegetableName.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtVegetableName.setForeground(Color.black);
            
        txtUnit = new JTextField();
            txtUnit.setBounds( 55 , 310 , 285 , 40 );
            txtUnit.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtUnit.setForeground(Color.black);
            
        txtAmount = new JTextField();
            txtAmount.setBounds( 55 , 390 , 285 , 40 );
            txtAmount.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtAmount.setForeground(Color.black);
        
        txtPrice = new JTextField();
            txtPrice.setBounds( 55 , 470 , 285 , 40 );
            txtPrice.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtPrice.setForeground(Color.black);
        
        txtURL = new JTextField();
            txtURL.setBounds( 530 , 370 , 250 , 30 );
            txtURL.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtURL.setForeground(Color.black);
            txtURL.setEnabled(false);
            
        txtSearch = new JTextField();
            txtSearch.setBounds( 830 , 5 , 515 , 30 );
            txtSearch.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtSearch.setForeground(Color.black);
            
        btnSearch = new JButton("Search");
            btnSearch.setBackground(Color.black);
            btnSearch.setForeground(Color.WHITE);
            btnSearch.setBorder(null);
            btnSearch.setFocusable(false);
            btnSearch.setBounds( 1350 , 5 , 100 , 29 );
            btnSearch.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));    
         
        btnAdd = new JButton("Add");
            btnAdd.setBackground(Color.black);
            btnAdd.setForeground(Color.WHITE);
            btnAdd.setBorder(null);
            btnAdd.setFocusable(false);
            btnAdd.setBounds( 640 , 650 , 150 , 29 );
            btnAdd.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnEdit = new JButton("Edit");
            btnEdit.setBackground(Color.black);
            btnEdit.setForeground(Color.WHITE);
            btnEdit.setBorder(null);
            btnEdit.setFocusable(false);
            btnEdit.setBounds( 480 , 650 , 150 , 29 );
            btnEdit.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnDelete = new JButton("Delete");
            btnDelete.setBackground(Color.red);
            btnDelete.setForeground(Color.WHITE);
            btnDelete.setBorder(null);
            btnDelete.setFocusable(false);
            btnDelete.setBounds( 320 , 650 , 150 , 29 );
            btnDelete.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnClear = new JButton("Clear");
            btnClear.setBackground(Color.black);
            btnClear.setForeground(Color.WHITE);
            btnClear.setBorder(null);
            btnClear.setFocusable(false);
            btnClear.setBounds( 690 , 5 , 100 , 29 );
            btnClear.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
        
        btnChooseImage = new JButton("Choose Image");
            btnChooseImage.setBackground(Color.black);
            btnChooseImage.setForeground(Color.WHITE);
            btnChooseImage.setBorder(null);
            btnChooseImage.setFocusable(false);
            btnChooseImage.setBounds( 530 , 330 , 250 , 29 );
            btnChooseImage.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
        
        tableModel = new DefaultTableModel(new Object[] { "Vegetable ID", "Category ID", "Vegetable Name" , "Unit" , "Amount" , "Price" }, 0);    
            
        tabStock = new JTable(tableModel);
            tabStock.setBackground(Color.white);
            tabStock.getTableHeader().setOpaque(false);
            tabStock.getTableHeader().setBackground(Color.BLACK);
            tabStock.getTableHeader().setForeground(Color.WHITE);
        
        pnlTable = new JScrollPane(tabStock);
            pnlTable.setBounds( 830 , 40 , 620, 650);  
            
        this.add(pnlTable);
        this.add(labStock);
        this.add(labUnit);
        this.add(labCategoryID);
        this.add(labVegetableName);
        this.add(labAmount);
        this.add(labPrice);
        this.add(labStockImage);
        this.add(labPictrue);
        this.add(txtUnit);
        this.add(txtVegetableName);
        this.add(txtCategoryID);
        this.add(txtAmount);
        this.add(txtPrice);
        this.add(txtURL);
        this.add(txtSearch);
        this.add(btnSearch);
        this.add(btnAdd);
        this.add(btnEdit);
        this.add(btnDelete);
        this.add(btnClear);
        this.add(btnChooseImage);
        this.add(labVegetableID);
        this.add(txtVegetableID);
        
        tabStock.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    int row = tabStock.getSelectedRow();
                    if (row >= 0 ){
                    vegetableIndex = vegetableList.indexOf(new Vegetable((int) tabStock.getValueAt(row,0)));
                    selectedVegetable = vegetableList.get(vegetableIndex);
                    
                    txtVegetableID.setText(Integer.toString((int) tabStock.getValueAt(row,0)));
                    txtCategoryID.setText(selectedVegetable.getCategory().getName());
                    txtVegetableName.setText((String)tabStock.getValueAt(row,2));
                    txtUnit.setText((String)tabStock.getValueAt(row,3));
                    txtAmount.setText(Integer.toString((int) tabStock.getValueAt(row,4)));
                    txtPrice.setText(Float.toString((float) tabStock.getValueAt(row,5)));
                    }
                }    
                });
        btnAdd.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        ReturnWhite();
                        if ( JOptionPane.showConfirmDialog(menu,"Do you want to add the new information?","Confirm",JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
//                        DataValidator.validateTextEmpty(txtVegetableID, sb, "Please enter Vegetable ID" );
                        DataValidator.validateTextEmpty(txtCategoryID, sb, "Please enter Category ID" );
                        DataValidator.validateTextEmpty(txtVegetableName, sb, "Please enter Vegetable Name" );
                        DataValidator.validateTextEmpty(txtUnit, sb, "Please enter Unit" );
                        DataValidator.validateTextEmpty(txtAmount, sb, "Please enter Amount" );
                        DataValidator.validateTextEmpty(txtPrice, sb, "Please enter Price" );
                        if (sb.length() > 0){
                            JOptionPane.showMessageDialog(menu, sb.toString() , "Information is missing!",  JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        
                        //add code here
                        Category category = categoryBLL.getCategory(txtCategoryID.getText());
                        
                        Vegetable vegetable = new Vegetable();
                            vegetable.setCategory(category);
                            vegetable.setCatagoryID(category.getCatagoryID());
                            vegetable.setVegetableName(txtVegetableName.getText());
                            vegetable.setUnit(txtUnit.getText());
                            vegetable.setAmount((Integer.parseInt(txtAmount.getText())));
                            vegetable.setPrice(Float.parseFloat(txtPrice.getText()));
                            vegetable.setImage(txtURL.getText());
                            
                        System.out.println(vegetable.toString());
                        vegetableList.add(vegetable);
                        vegetableBLL.addVegetable(vegetable);
                        
                        JOptionPane.showMessageDialog(menu, "Customer added successfully!" , "Done!",  JOptionPane.INFORMATION_MESSAGE);
                        Clear();
                        Show();
                    }
            });
        btnDelete.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        ReturnWhite();
                        if ( JOptionPane.showConfirmDialog(menu,"Do you want to delete the information?","Confirm",JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        DataValidator.validateTextEmpty(txtVegetableID, sb, "Please choose Stock!" );
                        if (sb.length() > 0){
                            JOptionPane.showMessageDialog(menu, sb.toString() , "Information is missing!",  JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        
                        //add code here
                        vegetableBLL.deleteVegetable(selectedVegetable);
                        vegetableList.remove(selectedVegetable);
                        
                        JOptionPane.showMessageDialog(menu, "Stock deleted successfully!" , "Done!",  JOptionPane.INFORMATION_MESSAGE);
                        Clear();
                        Show();
                    }
            });
        btnEdit.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        ReturnWhite();
                        if ( JOptionPane.showConfirmDialog(menu,"Do you want to change the information?","Confirm",JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
                            return;
                        }
                        
                        StringBuilder sb = new StringBuilder();
                        DataValidator.validateTextEmpty(txtVegetableID, sb, "Please choose Stock!" );
                        DataValidator.validateTextEmpty(txtCategoryID, sb, "Please enter Category ID" );
                        DataValidator.validateTextEmpty(txtVegetableName, sb, "Please enter Vegetable Name" );
                        DataValidator.validateTextEmpty(txtUnit, sb, "Please enter Unit" );
                        DataValidator.validateTextEmpty(txtAmount, sb, "Please enter Amount" );
                        DataValidator.validateTextEmpty(txtPrice, sb, "Please enter Price" );
                        if (sb.length() > 0){
                            JOptionPane.showMessageDialog(menu, sb.toString() , "Information is missing!",  JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        ReturnWhite();
                        if ( JOptionPane.showConfirmDialog(menu,"Do you want to change the information?","Confirm",JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
                            return;
                        }
                        
                        //add code here
                        Category category = categoryBLL.getCategory(txtCategoryID.getText());
                        
                        selectedVegetable.setCategory(category);
                        selectedVegetable.setCatagoryID(category.getCatagoryID());
                        selectedVegetable.setVegetableName(txtVegetableName.getText());
                        selectedVegetable.setUnit(txtUnit.getText());
                        selectedVegetable.setAmount((Integer.parseInt(txtAmount.getText())));
                        selectedVegetable.setPrice(Float.parseFloat(txtPrice.getText()));
                        selectedVegetable.setImage(txtURL.getText());
                        
                        vegetableBLL.addVegetable(selectedVegetable);
                        vegetableList.set(vegetableIndex, selectedVegetable);
                        
                        JOptionPane.showMessageDialog(menu, "Account edited successfully!" , "Done!",  JOptionPane.INFORMATION_MESSAGE);    
                        Clear();
                        Show();
                    }
            });  
            
            btnClear.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        Clear();
                        JOptionPane.showMessageDialog(menu, "All input fields have been refreshed.");
                    }
            });
            
            btnChooseImage.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        String filename = null;
                        JFileChooser file = new JFileChooser();
                        file.showOpenDialog(null);
                        File F = file.getSelectedFile();
                        filename = F.getAbsolutePath();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(labPictrue.getWidth(), labPictrue.getHeight(), Image.SCALE_SMOOTH));
                        labPictrue.setIcon(imageIcon); 
                        txtURL.setText(filename);
                    }
            });
           
    }
    public void Clear(){
        txtVegetableID.setText("");
        txtCategoryID.setText("");
        txtVegetableName.setText("");
        txtUnit.setText("");
        txtAmount.setText("");
        txtPrice.setText("");
        labPictrue.setIcon(null);
        txtURL.setText("");
    }
    public void ReturnWhite(){
        txtVegetableID.setBackground(Color.WHITE);
        txtCategoryID.setBackground(Color.WHITE);
        txtVegetableName.setBackground(Color.WHITE);
        txtUnit.setBackground(Color.WHITE);
        txtAmount.setBackground(Color.WHITE);
        txtPrice.setBackground(Color.WHITE);
    }
    public void Show(){
        Object[][] table = vegetableBLL.convertList(vegetableList);
        tableModel.setRowCount(0);
        
        for(int i = 0; i < table.length; i++) {
            tableModel.addRow(table[i]);
        }
        tabStock.setModel(tableModel);
    }
}
