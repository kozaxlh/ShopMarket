/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.Order;
import Entity.OrderDetail;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class OrderDAL {

    Session session;

    public OrderDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List<Order> getOrderInCustomer(int CustomerID) {
        List<Order> orders;

        session.beginTransaction();

        Query query = session.createQuery("FROM Order WHERE CustomerID= :customerID");
        query.setParameter("customerID", CustomerID);

        orders = query.list();
        session.getTransaction().commit();

        return orders;
    }

    public Order getOrder(int OrderID) {
        Order order;

        session.beginTransaction();
        order = session.get(Order.class, OrderID);
        session.getTransaction().commit();

        return order;

    }

    public void addOrder(Order order) {
        session.save(order);
    }

    public void updateOrder(Order order) {
        session.update(order);
    }

    public void deleteOrder(Order order) {
        session.delete(order);
    }

}
