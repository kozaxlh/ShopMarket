/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.Customers;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class CustomersDAL {
    Session session;

    public CustomersDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List<Customers> getCustomers() {
        List<Customers> customers;
        
        session.beginTransaction();
        customers = session.createQuery("FROM Customers", Customers.class).list();
        session.getTransaction().commit();
        
        return customers;
    }
    
    public Customers getCustomer(int CustomerID) {
        return session.get(Customers.class, CustomerID);
    }
    
    public void addCustomer(Customers customer) {
        session.save(customer);
    }
    
    public void updateCustomer(Customers customer) {
        session.update(customer);
    }
    
    public void deleteCustomer(Customers customer) {
        session.delete(customer);
    }

}
