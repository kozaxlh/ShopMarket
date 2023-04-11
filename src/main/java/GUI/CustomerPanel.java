/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.CustomersBLL;
import Entity.Customers;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class CustomerPanel extends JPanel{
    JLabel labCustomer, labCustomerID, labFullName, labPassword,
           labAddress, labCity;
    JTextField txtCustomerID, txtPassword, txtFullName, txtAddress, txtCity, txtSearch;
    JTable tabCustomer;
    JButton btnAdd, btnClear, btnDelete, btnEdit, btnSearch;
    JScrollPane pnlTable;
    DefaultTableModel tableModel;
    MenuScreen menu;
    CustomersBLL customerBLL;
    List<Customers> customerList;
    Customers selectedCustomer;
    int customerIndex;
    public CustomerPanel(){
        super();
        customerBLL = new CustomersBLL();
        customerList = customerBLL.loadCustomers();
        GUI();
        Show();
    }
   
    private void GUI(){ 
        this.setBounds(0,0,1500, 750);
        this.setVisible(true);
        this.setLayout(null);
        
        labCustomer = new JLabel("CUSTOMER MANAGER");
            labCustomer.setForeground(Color.black);
            labCustomer.setBounds( 30 , 5 , 240 , 30 );
            labCustomer.setFont(new Font( "Jaldi" , Font.BOLD , 20 ));
        
        labCustomerID = new JLabel("Customer ID");
            labCustomerID.setForeground(Color.black);
            labCustomerID.setBounds( 50 , 40 , 240 , 30 );
            labCustomerID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        labFullName= new JLabel("Full Name");
            labFullName.setForeground(Color.black);
            labFullName.setBounds( 50 , 120 , 240 , 30 );
            labFullName.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labPassword = new JLabel("Password");
            labPassword.setForeground(Color.black);
            labPassword.setBounds( 50 , 200 , 240 , 30 );
            labPassword.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));  
            
        labAddress = new JLabel("Address");
            labAddress.setForeground(Color.black);
            labAddress.setBounds( 50 , 280 , 240 , 30 );
            labAddress.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labCity = new JLabel("City");
            labCity.setForeground(Color.black);
            labCity.setBounds( 50 , 360 , 240 , 30 );
            labCity.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        txtCustomerID = new JTextField();
            txtCustomerID.setBounds( 55 , 70 , 285 , 40 );
            txtCustomerID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtCustomerID.setForeground(Color.black);
            txtCustomerID.setFocusable(false);
            
        txtFullName = new JTextField();
            txtFullName.setBounds( 55 , 150 , 285 , 40 );
            txtFullName.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtFullName.setForeground(Color.black);
            
        txtPassword = new JTextField();
            txtPassword.setBounds( 55 , 230 , 285 , 40 );
            txtPassword.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtPassword.setBackground(Color.white);
            
        txtAddress = new JTextField();
            txtAddress.setBounds( 55 , 310 , 285 , 40 );
            txtAddress.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtAddress.setForeground(Color.black);
            
        txtCity = new JTextField();
            txtCity.setBounds( 55 , 390 , 285 , 40 );
            txtCity.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtCity.setForeground(Color.black);
            
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
        
        tableModel = new DefaultTableModel(new Object[] { "Customer ID", "Full Name", "Password" , "Address" , "City" }, 0);    
            
        tabCustomer = new JTable(tableModel);
            tabCustomer.setBackground(Color.white);
            tabCustomer.getTableHeader().setOpaque(false);
            tabCustomer.getTableHeader().setBackground(Color.BLACK);
            tabCustomer.getTableHeader().setForeground(Color.WHITE);
        
        pnlTable = new JScrollPane(tabCustomer);
            pnlTable.setBounds( 830 , 40 , 620, 650);  
            
        this.add(pnlTable);
        this.add(labCustomer);
        this.add(labAddress);
        this.add(labPassword);
        this.add(labFullName);
        this.add(labCity);
        this.add(txtAddress);
        this.add(txtFullName);
        this.add(txtPassword);
        this.add(txtCity);
        this.add(txtSearch);
        this.add(btnSearch);
        this.add(btnAdd);
        this.add(btnEdit);
        this.add(btnDelete);
        this.add(btnClear);
        this.add(labCustomerID);
        this.add(txtCustomerID);
        tabCustomer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    int row = tabCustomer.getSelectedRow();
                    if (row >= 0 ){
                    customerIndex = customerList.indexOf(new Customers((int) tabCustomer.getValueAt(row,0)));
                    selectedCustomer = customerList.get(customerIndex);
                        
                    txtCustomerID.setText(Integer.toString((int) tabCustomer.getValueAt(row,0)));
                    txtFullName.setText((String)tabCustomer.getValueAt(row,1));
                    txtPassword.setText((String)tabCustomer.getValueAt(row, 2));
                    txtAddress.setText((String)tabCustomer.getValueAt(row,3));
                    txtCity.setText((String)tabCustomer.getValueAt(row,4));
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
//                        DataValidator.validateTextEmpty(txtCustomerID, sb, "Please enter ID" );
                        DataValidator.validateTextEmpty(txtPassword, sb, "Please enter Password" );
                        DataValidator.validateTextEmpty(txtFullName, sb, "Please enter Fullname" );
//                        DataValidator.validateTextEmpty(txtAddress, sb, "Please enter Address" );
//                        DataValidator.validateTextEmpty(txtCity, sb, "Please enter City" );
                        if (sb.length() > 0){
                            JOptionPane.showMessageDialog(menu, sb.toString() , "Information is missing!",  JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        
                        //add code here
                        Customers customer = new Customers();
                            customer.setFullname(txtFullName.getText());
                            customer.setPassword(txtPassword.getText());
                            customer.setAddress(txtAddress.getText());
                            customer.setCity(txtCity.getText());
                        
                        customerBLL.addCustomer(customer);
                        customerList.add(customer);
                        
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
                        DataValidator.validateTextEmpty(txtCustomerID, sb, "Please choose customer!" );
                        if (sb.length() > 0){
                            JOptionPane.showMessageDialog(menu, sb.toString() , "Information is missing!",  JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        
                        //add code here
                        customerBLL.deleteCustomer(selectedCustomer);
                        customerList.remove(selectedCustomer);
                        
                        JOptionPane.showMessageDialog(menu, "Customer deleted successfully!" , "Done!",  JOptionPane.INFORMATION_MESSAGE);
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
                        DataValidator.validateTextEmpty(txtCustomerID, sb, "Please choose account!" );
                        DataValidator.validateTextEmpty(txtPassword, sb, "Please enter Username" );
                        DataValidator.validateTextEmpty(txtFullName, sb, "Please enter Password" );
//                        DataValidator.validateTextEmpty(txtAddress, sb, "Please enter Address" );
//                        DataValidator.validateTextEmpty(txtCity, sb, "Please enter City" );
                        if (sb.length() > 0){
                            JOptionPane.showMessageDialog(menu, sb.toString() , "Information is missing!",  JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        
                        //add code here
                        selectedCustomer.setFullname(txtFullName.getText());
                        selectedCustomer.setPassword(txtPassword.getText());
                        selectedCustomer.setAddress(txtAddress.getText());
                        selectedCustomer.setCity(txtCity.getText());

                        customerBLL.updateCustomer(selectedCustomer);
                        customerList.set(customerIndex, selectedCustomer);
                        
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
            
    }
    public void Clear(){
        txtCustomerID.setText("");
        txtPassword.setText("");
        txtFullName.setText("");
        txtAddress.setText("");
        txtCity.setText("");
    }
    public void ReturnWhite(){
        txtCustomerID.setBackground(Color.WHITE);
        txtPassword.setBackground(Color.WHITE);
        txtFullName.setBackground(Color.WHITE);
        txtAddress.setBackground(Color.WHITE);
        txtCity.setBackground(Color.WHITE);
    }
    public void Show(){
        Object[][] table = customerBLL.convertList(customerList);
        tableModel.setRowCount(0);
        
        for(int i = 0; i < table.length; i++) {
            tableModel.addRow(table[i]);
        }
        tabCustomer.setModel(tableModel);
    }
}
