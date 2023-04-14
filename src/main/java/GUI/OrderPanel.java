/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.*;
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
public class OrderPanel extends JPanel{
    JLabel labOrder, labOrderID, labDate, labCustomerID,
           labTotal, labNote;
    JTextField txtOrderID, txtCustomerID, txtDate, txtTotal, txtNote, txtSearch;
    JTable tabCustomer;
    JButton btnCreate, btnClear, btnSearch, btnDetail;
    JScrollPane pnlTable;
    DefaultTableModel tableModel;
    MenuScreen menu;
    
     public OrderPanel(MenuScreen menu){
        super();
        this.menu = menu;
        GUI();
        Show();
    }

    private void GUI(){ 
        this.setBounds(0,0,1500, 750);
        this.setVisible(true);
        this.setLayout(null);
        
        labOrder = new JLabel("ORDER MANAGER");
            labOrder.setForeground(Color.black);
            labOrder.setBounds( 30 , 5 , 240 , 30 );
            labOrder.setFont(new Font( "Jaldi" , Font.BOLD , 20 ));
        
        labOrderID = new JLabel("Order ID");
            labOrderID.setForeground(Color.black);
            labOrderID.setBounds( 50 , 40 , 240 , 30 );
            labOrderID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
        
        labCustomerID = new JLabel("Customer ID");
            labCustomerID.setForeground(Color.black);
            labCustomerID.setBounds( 50 , 120 , 240 , 30 );
            labCustomerID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));  
            
        labDate= new JLabel("Date");
            labDate.setForeground(Color.black);
            labDate.setBounds( 50 , 200 , 240 , 30 );
            labDate.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labTotal = new JLabel("Total");
            labTotal.setForeground(Color.black);
            labTotal.setBounds( 50 , 280 , 240 , 30 );
            labTotal.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        labNote = new JLabel("Note");
            labNote.setForeground(Color.black);
            labNote.setBounds( 50 , 360 , 240 , 30 );
            labNote.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            
        txtOrderID = new JTextField();
            txtOrderID.setBounds( 55 , 70 , 285 , 40 );
            txtOrderID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtOrderID.setForeground(Color.black);
            txtOrderID.setEnabled(false);
            
        txtCustomerID = new JTextField();
            txtCustomerID.setBounds( 55 , 150 , 285 , 40 );
            txtCustomerID.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtCustomerID.setBackground(Color.white);
            txtCustomerID.setEnabled(false);
            
        txtDate = new JTextField();
            txtDate.setBounds( 55 , 230 , 285 , 40 );
            txtDate.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtDate.setForeground(Color.black);
            txtDate.setEnabled(false);
            
        txtTotal = new JTextField();
            txtTotal.setBounds( 55 , 310 , 285 , 40 );
            txtTotal.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtTotal.setForeground(Color.black);
            txtTotal.setEnabled(false);
            
        txtNote = new JTextField();
            txtNote.setBounds( 55 , 390 , 285 , 40 );
            txtNote.setFont(new Font( "Jaldi" , Font.BOLD , 16 ));
            txtNote.setForeground(Color.black);
            txtNote.setEnabled(false);
            
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
         
        btnCreate = new JButton("Create");
            btnCreate.setBackground(Color.black);
            btnCreate.setForeground(Color.WHITE);
            btnCreate.setBorder(null);
            btnCreate.setFocusable(false);
            btnCreate.setBounds( 640 , 650 , 150 , 29 );
            btnCreate.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnDetail = new JButton("Detail");
            btnDetail.setBackground(Color.black);
            btnDetail.setForeground(Color.WHITE);
            btnDetail.setBorder(null);
            btnDetail.setFocusable(false);
            btnDetail.setBounds( 480 , 650 , 150 , 29 );
            btnDetail.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
            
        btnClear = new JButton("Clear");
            btnClear.setBackground(Color.black);
            btnClear.setForeground(Color.WHITE);
            btnClear.setBorder(null);
            btnClear.setFocusable(false);
            btnClear.setBounds( 690 , 5 , 100 , 29 );
            btnClear.setFont(new Font( "Jaldi" , Font.BOLD ,20 ));
        
        tableModel = new DefaultTableModel(new Object[] { "Order ID", "Customer ID", "Date" , "Total" , "Note" }, 0);    
            
        tabCustomer = new JTable(tableModel);
            tabCustomer.setBackground(Color.white);
            tabCustomer.getTableHeader().setOpaque(false);
            tabCustomer.getTableHeader().setBackground(Color.BLACK);
            tabCustomer.getTableHeader().setForeground(Color.WHITE);
        
        pnlTable = new JScrollPane(tabCustomer);
            pnlTable.setBounds( 830 , 40 , 620, 650);  
            
        this.add(pnlTable);
        this.add(labOrder);
        this.add(labTotal);
        this.add(labCustomerID);
        this.add(labDate);
        this.add(labNote);
        this.add(txtTotal);
        this.add(txtDate);
        this.add(txtCustomerID);
        this.add(txtNote);
        this.add(txtSearch);
        this.add(btnDetail);
        this.add(btnSearch);
        this.add(btnCreate);
        this.add(btnClear);
        this.add(labOrderID);
        this.add(txtOrderID);
        tabCustomer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    int row = tabCustomer.getSelectedRow();
                    if (row >= 0 ){
                    txtOrderID.setText(Integer.toString((int) tabCustomer.getValueAt(row,0)));
                    txtCustomerID.setText(Integer.toString((int) tabCustomer.getValueAt(row,1)));
                    txtDate.setText((String)tabCustomer.getValueAt(row,2));
                    txtTotal.setText(Integer.toString((int) tabCustomer.getValueAt(row,3)));
                    txtNote.setText((String)tabCustomer.getValueAt(row,4));
                    }
                }    
                });
        btnCreate.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        if ( JOptionPane.showConfirmDialog(menu,"Do you want to create a new order?","Confirm",JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION){
                            return;
                            }
                        new OrderDetailScreen(menu);
                        menu.setVisible(false);
                    }
            }); 
        
        btnDetail.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        StringBuilder sb = new StringBuilder();
                        DataValidator.validateTextEmpty(txtOrderID, sb, "Product ID cannot be blank!");
                        if (sb.length()>0 ){
                            JOptionPane.showMessageDialog(menu, sb , "Information is missing!",  JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        new OrderDetailScreen(menu);
                        menu.setVisible(false);
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
        txtOrderID.setText("");
        txtCustomerID.setText("");
        txtDate.setText("");
        txtTotal.setText("");
        txtNote.setText("");
    }
    public void ReturnWhite(){
        txtOrderID.setBackground(Color.WHITE);
        txtCustomerID.setBackground(Color.WHITE);
        txtDate.setBackground(Color.WHITE);
        txtTotal.setBackground(Color.WHITE);
        txtNote.setBackground(Color.WHITE);
    }
    public void Show(){
    
    }
}