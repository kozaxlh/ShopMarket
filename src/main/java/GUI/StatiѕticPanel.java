/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class StatiѕticPanel extends JPanel{
    
    JLabel labStatistic, labVegetableID, labVegetableName, labCategoryID,
           labUnit, labAmountSale, labPrice, labTotalSale,
           labYear, labMonth, labDay;
    JTextField txtVegetableID, txtCategoryID, txtVegetableName, txtUnit, txtAmountSale, txtPrice, txtTotalSale, txtSearch;
    JTable tabStatistic;
    JButton btnClear, btnSearch, btnTotalUp;
    JComboBox cbbYear, cbbMonth, cbbDay;
    JScrollPane pnlTable;
    DefaultTableModel tableModel;
    MenuScreen menu; 
    public StatiѕticPanel(){
        super();
        GUI();
        Show();
    }
   
    private void GUI(){ 
        this.setBounds(0,0,1500, 750);
        this.setVisible(true);
        this.setLayout(null);
        
        labStatistic = new JLabel("STATISTIC MANAGER");
            labStatistic.setForeground(Color.black);
            labStatistic.setBounds( 30 , 5 , 240 , 30 );
            labStatistic.setFont(new Font( "Jaldi" , Font.BOLD , 20 ));
        
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
            
        labAmountSale = new JLabel("Amount Sale");
            labAmountSale.setForeground(Color.black);
            labAmountSale.setBounds( 50 , 360 , 240 , 30 );
            labAmountSale.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        labPrice = new JLabel("Price");
            labPrice.setForeground(Color.black);
            labPrice.setBounds( 50 , 440 , 240 , 30 );
            labPrice.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        labTotalSale = new JLabel("Total Sale");
            labTotalSale.setForeground(Color.black);
            labTotalSale.setBounds( 50 , 520 , 240 , 30 );
            labTotalSale.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        labYear = new JLabel("Year");
            labYear.setForeground(Color.black);
            labYear.setBounds( 450 , 40 , 240 , 30 );
            labYear.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labMonth = new JLabel("Month");
            labMonth.setForeground(Color.black);
            labMonth.setBounds( 600 , 40 , 240 , 30 );
            labMonth.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        labDay = new JLabel("Day");
            labDay.setForeground(Color.black);
            labDay.setBounds( 700 , 40 , 240 , 30 );
            labDay.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
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
            
        txtAmountSale = new JTextField();
            txtAmountSale.setBounds( 55 , 390 , 285 , 40 );
            txtAmountSale.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtAmountSale.setForeground(Color.black);
        
        txtPrice = new JTextField();
            txtPrice.setBounds( 55 , 470 , 285 , 40 );
            txtPrice.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtPrice.setForeground(Color.black);
            
        txtTotalSale = new JTextField();
            txtTotalSale.setBounds( 55 , 550 , 285 , 40 );
            txtTotalSale.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtTotalSale.setForeground(Color.black);
            
        txtSearch = new JTextField();
            txtSearch.setBounds( 830 , 5 , 515 , 30 );
            txtSearch.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtSearch.setForeground(Color.black);
            
        cbbYear = new JComboBox();
            cbbYear.setBounds( 455 , 70 , 100 , 40 );
            cbbYear.setFont(new Font( "Jaldi" , Font.BOLD , 16 )); 
            cbbYear.setBackground(Color.WHITE);
            for(int i = 2000; i<=2500; i++){
                cbbYear.addItem(i);
            }
            
        cbbMonth = new JComboBox();
            cbbMonth.setBounds( 605 , 70 , 50 , 40 );
            cbbMonth.setFont(new Font( "Jaldi" , Font.BOLD , 16 )); 
            cbbMonth.setBackground(Color.WHITE);
            for(int i = 1; i<=12; i++){
                cbbMonth.addItem(i);
            }
            
            
        cbbDay = new JComboBox();
            cbbDay.setBounds( 705 , 70 , 50 , 40 );
            cbbDay.setFont(new Font( "Jaldi" , Font.BOLD , 16 )); 
            cbbDay.setBackground(Color.WHITE);
            if ((int)cbbMonth.getSelectedItem() == 1 || (int)cbbMonth.getSelectedItem() == 3 ||
                    (int)cbbMonth.getSelectedItem() == 5 || (int)cbbMonth.getSelectedItem() == 7 ||
                    (int)cbbMonth.getSelectedItem() == 8 || (int)cbbMonth.getSelectedItem() == 10 ||
                    (int)cbbMonth.getSelectedItem() == 12){
                cbbDay.removeAllItems();
                for(int i = 1; i <= 31; i++)
                    cbbDay.addItem(i);
            }else if ((int)cbbMonth.getSelectedItem() == 4 || (int)cbbMonth.getSelectedItem() == 6 ||
                    (int)cbbMonth.getSelectedItem() == 9 || (int)cbbMonth.getSelectedItem() == 11){
                cbbDay.removeAllItems();
                for(int i = 1; i <= 30; i++)
                    cbbDay.addItem(i);
            }else if ((int)cbbMonth.getSelectedItem() == 2 && ((int)cbbYear.getSelectedItem()%4)==0){
                cbbDay.removeAllItems();
                for(int i = 1; i <= 29; i++)
                    cbbDay.addItem(i);
            }else if((int)cbbMonth.getSelectedItem() == 2 && ((int)cbbYear.getSelectedItem()%4)!=0){
                cbbDay.removeAllItems();
                for(int i = 1; i <= 28; i++)
                    cbbDay.addItem(i);
            }else
                cbbDay.addItem("chon thang nam");
            
        btnSearch = new JButton("Search");
            btnSearch.setBackground(Color.black);
            btnSearch.setForeground(Color.WHITE);
            btnSearch.setBorder(null);
            btnSearch.setFocusable(false);
            btnSearch.setBounds( 1350 , 5 , 100 , 29 );
            btnSearch.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));    
           
        btnClear = new JButton("Clear");
            btnClear.setBackground(Color.black);
            btnClear.setForeground(Color.WHITE);
            btnClear.setBorder(null);
            btnClear.setFocusable(false);
            btnClear.setBounds( 690 , 5 , 100 , 29 );
            btnClear.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnTotalUp = new JButton("Total Up");
            btnTotalUp.setBackground(Color.black);
            btnTotalUp.setForeground(Color.WHITE);
            btnTotalUp.setBorder(null);
            btnTotalUp.setFocusable(false);
            btnTotalUp.setBounds( 535 , 150 , 100 , 29 );
            btnTotalUp.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
        
        tableModel = new DefaultTableModel(new Object[] { "Vegetable ID", "Category ID", "Vegetable Name" , "Unit" , "Amount Sale" , "Price" , "TotalSale" }, 0);    
            
        tabStatistic = new JTable(tableModel);
            tabStatistic.setBackground(Color.white);
            tabStatistic.getTableHeader().setOpaque(false);
            tabStatistic.getTableHeader().setBackground(Color.BLACK);
            tabStatistic.getTableHeader().setForeground(Color.WHITE);
        
        pnlTable = new JScrollPane(tabStatistic);
            pnlTable.setBounds( 830 , 40 , 620, 650);  
            
        this.add(pnlTable);
        this.add(labStatistic);
        this.add(labUnit);
        this.add(labVegetableID);
        this.add(labCategoryID);
        this.add(labVegetableName);
        this.add(labAmountSale);
        this.add(labPrice);
        this.add(labTotalSale);
        this.add(labYear);
        this.add(labMonth);
        this.add(labDay);
        this.add(txtUnit);
        this.add(txtVegetableName);
        this.add(txtCategoryID);
        this.add(txtAmountSale);
        this.add(txtPrice);
        this.add(txtTotalSale);
        this.add(txtSearch);
        this.add(cbbYear);
        this.add(cbbMonth);
        this.add(cbbDay);
        this.add(btnSearch);
        this.add(btnClear);
        this.add(btnTotalUp);
        this.add(txtVegetableID);
        tabStatistic.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    int row = tabStatistic.getSelectedRow();
                    if (row >= 0 ){
                    txtVegetableID.setText(Integer.toString((int) tabStatistic.getValueAt(row,0)));
                    txtCategoryID.setText(Integer.toString((int) tabStatistic.getValueAt(row,1)));
                    txtVegetableName.setText((String)tabStatistic.getValueAt(row,2));
                    txtUnit.setText((String)tabStatistic.getValueAt(row,3));
                    txtAmountSale.setText(Integer.toString((int) tabStatistic.getValueAt(row,4)));
                    txtPrice.setText(Integer.toString((int) tabStatistic.getValueAt(row,5)));
                    txtTotalSale.setText(Integer.toString((int) tabStatistic.getValueAt(row,6)));
                    }
                }    
                });
        cbbYear.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        if ((int)cbbMonth.getSelectedItem() == 1 || (int)cbbMonth.getSelectedItem() == 3 ||
                            (int)cbbMonth.getSelectedItem() == 5 || (int)cbbMonth.getSelectedItem() == 7 ||
                            (int)cbbMonth.getSelectedItem() == 8 || (int)cbbMonth.getSelectedItem() == 10 ||
                            (int)cbbMonth.getSelectedItem() == 12){
                            cbbDay.removeAllItems();
                            for(int i = 1; i <= 31; i++)
                            cbbDay.addItem(i);
                        }else if ((int)cbbMonth.getSelectedItem() == 4 || (int)cbbMonth.getSelectedItem() == 6 ||
                                  (int)cbbMonth.getSelectedItem() == 9 || (int)cbbMonth.getSelectedItem() == 11){
                            cbbDay.removeAllItems();
                            for(int i = 1; i <= 30; i++)
                                cbbDay.addItem(i);
                        }else if ((int)cbbMonth.getSelectedItem() == 2 && ((int)cbbYear.getSelectedItem()%4)==0){
                            cbbDay.removeAllItems();
                            for(int i = 1; i <= 29; i++)
                                cbbDay.addItem(i);
                        }else if((int)cbbMonth.getSelectedItem() == 2 && ((int)cbbYear.getSelectedItem()%4)!=0){
                            cbbDay.removeAllItems();
                            for(int i = 1; i <= 28; i++)
                                cbbDay.addItem(i);
                        }else
                            cbbDay.addItem("chon thang nam");
                    }
                });
        
        cbbMonth.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        if ((int)cbbMonth.getSelectedItem() == 1 || (int)cbbMonth.getSelectedItem() == 3 ||
                            (int)cbbMonth.getSelectedItem() == 5 || (int)cbbMonth.getSelectedItem() == 7 ||
                            (int)cbbMonth.getSelectedItem() == 8 || (int)cbbMonth.getSelectedItem() == 10 ||
                            (int)cbbMonth.getSelectedItem() == 12){
                            cbbDay.removeAllItems();
                            for(int i = 1; i <= 31; i++)
                            cbbDay.addItem(i);
                        }else if ((int)cbbMonth.getSelectedItem() == 4 || (int)cbbMonth.getSelectedItem() == 6 ||
                                  (int)cbbMonth.getSelectedItem() == 9 || (int)cbbMonth.getSelectedItem() == 11){
                            cbbDay.removeAllItems();
                            for(int i = 1; i <= 30; i++)
                                cbbDay.addItem(i);
                        }else if ((int)cbbMonth.getSelectedItem() == 2 && ((int)cbbYear.getSelectedItem()%4)==0){
                            cbbDay.removeAllItems();
                            for(int i = 1; i <= 29; i++)
                                cbbDay.addItem(i);
                        }else if((int)cbbMonth.getSelectedItem() == 2 && ((int)cbbYear.getSelectedItem()%4)!=0){
                            cbbDay.removeAllItems();
                            for(int i = 1; i <= 28; i++)
                                cbbDay.addItem(i);
                        }else
                            cbbDay.addItem("chon thang nam");
                    }
                });  
        

            btnClear.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        Clear();
                        JOptionPane.showMessageDialog(menu, "All input fields have been refreshed.");
                    }
            });  
            
    }
    public void Clear(){
        txtVegetableID.setText("");
        txtCategoryID.setText("");
        txtVegetableName.setText("");
        txtUnit.setText("");
        txtAmountSale.setText("");
        txtPrice.setText("");
        txtTotalSale.setText("");
    }
//    public void ReturnWhite(){
//        txtVegetableID.setBackground(Color.WHITE);
//        txtCategoryID.setBackground(Color.WHITE);
//        txtVegetableName.setBackground(Color.WHITE);
//        txtUnit.setBackground(Color.WHITE);
//        txtAmountSale.setBackground(Color.WHITE);
//    }
    public void Show(){
    
    }
}
