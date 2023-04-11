/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author asus
 */
public class MenuScreen extends JFrame{
    JPanel pnlMenu, pnlContent;
    JButton btnStock, btnReceipt, btnCustomer, btnStatistic;
    JPanel OP = new OrderPanel(this);
    JPanel[] Panel = {
        new StockPanel(),
        OP,
        new CustomerPanel(),
        new StatiѕticPanel()
    };
    public MenuScreen(){
        this.setPreferredSize(new Dimension(1500,800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        
        ShowScreen();
        
        this.pack();
        this.setLocationRelativeTo(null);
    }
     
    public void ShowScreen(){
        CreateMenu();
        CreateContent();      
    }
    
    private void CreateContent(){
        pnlContent = new JPanel();
            pnlContent.setBounds(0, 50, 1500, 750);
            pnlContent.setLayout(null);
           
        this.add(pnlContent);
    }
    private void CreateMenu(){
        
        pnlMenu = new JPanel();
            pnlMenu.setBounds(0, 0, 1500, 40);
            pnlMenu.setLayout(null);
            pnlMenu.setBackground(Color.black);
        
        btnStock = new JButton("STOCK");
            btnStock.setBackground(Color.white);
            btnStock.setForeground(Color.black);
            btnStock.setBorder(null);
            btnStock.setFocusable(false);
            btnStock.setBounds( 5 , 5 , 150 , 30 );
            btnStock.setFont(new Font( "Jaldi" , Font.BOLD ,16 )); 
            
        btnReceipt = new JButton("RECEIPT");
            btnReceipt.setBackground(Color.white);
            btnReceipt.setForeground(Color.black);
            btnReceipt.setBorder(null);
            btnReceipt.setFocusable(false);
            btnReceipt.setBounds( 160 , 5 , 150 , 30 );
            btnReceipt.setFont(new Font( "Jaldi" , Font.BOLD ,16 )); 
            
        btnCustomer = new JButton("CUSTOMER");
            btnCustomer.setBackground(Color.white);
            btnCustomer.setForeground(Color.black);
            btnCustomer.setBorder(null);
            btnCustomer.setFocusable(false);
            btnCustomer.setBounds( 315 , 5 , 150 , 30 );
            btnCustomer.setFont(new Font( "Jaldi" , Font.BOLD ,16 ));
            
        btnStatistic = new JButton("STATISTIC");
            btnStatistic.setBackground(Color.white);
            btnStatistic.setForeground(Color.black);
            btnStatistic.setBorder(null);
            btnStatistic.setFocusable(false);
            btnStatistic.setBounds( 470 , 5 , 150 , 30 );
            btnStatistic.setFont(new Font( "Jaldi" , Font.BOLD ,16 )); 
        
        pnlMenu.add(btnStock);
        pnlMenu.add(btnReceipt);
        pnlMenu.add(btnCustomer);
        pnlMenu.add(btnStatistic);
        this.add(pnlMenu);
        
        btnStock.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){;
                    JPanel Panel = new StockPanel();
                    ChangePanel(Panel);
                } 
            });
        
        btnReceipt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){;
                    ChangePanel(OP);
                } 
            });
        
        btnCustomer.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){;
                    JPanel Panel = new CustomerPanel();
                    ChangePanel(Panel);
                } 
            });
        
        btnStatistic.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){;
                    JPanel Panel = new StatiѕticPanel();
                    ChangePanel(Panel);
                } 
            });
        
    }
    private void ChangePanel(JPanel ThisPanel){
        pnlContent.removeAll();
        pnlContent.add(ThisPanel);
        pnlContent.revalidate();
        pnlContent.repaint();
    }
//    public static void main(String[] args) {
//        MenuScreen m = new MenuScreen();
//    }
}
