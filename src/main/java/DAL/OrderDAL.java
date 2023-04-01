/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.Order;
import Entity.OrderDetail;
import java.util.Calendar;
import java.util.Date;
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

    public List getVegetableRevenue(Calendar date) {
        List list;

        session.beginTransaction();
        String hql = "SELECT new POJO.VegetableRevenue(OD.vegetable.vegetableName, sum(OD.quantity), sum(OD.price)) "
                + "FROM OrderDetail OD "
                + "WHERE year(OD.order.date) = :year AND month(OD.order.date) = :month AND day(OD.order.date) = :day "
                + "GROUP BY OD.vegetable.vegetableID ";
        Query query = session.createQuery(hql);

        query.setParameter("year", date.get(Calendar.YEAR));
        query.setParameter("month", date.get(Calendar.MONTH) + 1);
        query.setParameter("day", date.get(Calendar.DATE));

        list = query.list();

        return list;
    }
    
    public List getVegetableRevenue() {
        List list;

        session.beginTransaction();
        String hql = "SELECT new POJO.VegetableRevenue(OD.vegetable.vegetableName, sum(OD.quantity), sum(OD.price)) "
                + "FROM OrderDetail OD "
                + "GROUP BY OD.vegetable.vegetableID ";
        Query query = session.createQuery(hql);

        list = query.list();

        return list;
    }

    public void addOrder(Order order) {
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
    }

    public void updateOrder(Order order) {
        session.beginTransaction();
        session.update(order);
        session.getTransaction().commit();
    }

    public void deleteOrder(Order order) {
        session.beginTransaction();
        session.delete(order);
        session.getTransaction().commit();
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        session.beginTransaction();
        session.save(orderDetail);
        session.getTransaction().commit();
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        session.beginTransaction();
        session.update(orderDetail);
        session.getTransaction().commit();
    }

    public void deleteOrderDetail(OrderDetail orderDetail) {
        session.beginTransaction();
        session.delete(orderDetail);
        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        OrderDAL dal = new OrderDAL();

        Order order = dal.getOrder(1);

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(order.getDate());

        List list = dal.getVegetableRevenue(calendar);
        for (var item : list) {
            System.out.println(item);
        }
    }
}
