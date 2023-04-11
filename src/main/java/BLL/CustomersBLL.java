/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CustomersDAL;
import Entity.Customers;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CustomersBLL {
    CustomersDAL customerDAL;
    
    public CustomersBLL() {
        customerDAL = new CustomersDAL();
    }
    
    public List<Customers> loadCustomers() {
        return customerDAL.getCustomers();
    }
    
    public Object[][] convertList(List<Customers> list) {
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getCustomerID();
            obj[i][1] = list.get(i).getFullname();
            obj[i][2] = list.get(i).getPassword();
            obj[i][3] = list.get(i).getAddress();
            obj[i][4] = list.get(i).getCity();
        }
        return obj;
    }
    
    public Customers getCustomer(int customerID) {
        return customerDAL.getCustomer(customerID);
    }
    
    public void addCustomer(Customers customer) {
        customerDAL.addCustomer(customer);
    }
    
    public void deleteCustomer(Customers customer) {
        customerDAL.deleteCustomer(customer);
    }
    
    public void updateCustomer(Customers customer) {
        customerDAL.updateCustomer(customer);
    }
}
