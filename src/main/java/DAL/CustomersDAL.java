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
        Customers customer;
        
        session.beginTransaction();
        customer = session.get(Customers.class, CustomerID);
        session.getTransaction().commit();
        return customer;
    }

    public void addCustomer(Customers customer) {
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    public void updateCustomer(Customers customer) {
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
    }

    public void deleteCustomer(Customers customer) {
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
    }

}
