/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OrderDAL;
import Entity.Order;
import Entity.OrderDetail;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderBLL {

    OrderDAL orderDAL;

    public OrderBLL() {
        orderDAL = new OrderDAL();
    }

    public Object[][] convertOrderList(List<Order> list) {
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getOrderID();
            obj[i][1] = list.get(i).getCustomerID().getCustomerID();
            obj[i][2] = list.get(i).getDate();
            obj[i][3] = list.get(i).getNote();
            obj[i][4] = list.get(i).getTotal();
        }
        return obj;
    }
    
    public Object[][] convertOrderDetailList(List<OrderDetail> list) {
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getVegetable().getVegetableName();
            obj[i][1] = list.get(i).getQuantity();
            obj[i][2] = list.get(i).getVegetable().getUnit();
            obj[i][3] = list.get(i).getVegetable().getPrice();
            obj[i][4] = list.get(i).getPrice();
        }
        return obj;
    }
    
    public Order getOrder(int orderID) {
        return orderDAL.getOrder(orderID);
    }
    
    public void addOrder(Order order) {
        orderDAL.addOrder(order);
    }
    
    public void updateOrder(Order order) {
        orderDAL.updateOrder(order);
    }
    
    public void deleteOrder(Order order) {
        orderDAL.deleteOrder(order);
    }
    
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDAL.addOrderDetail(orderDetail);
    }
    
    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDAL.updateOrderDetail(orderDetail);
    }
    
    public void deleteOrderDetail(OrderDetail orderDetail) {
        orderDAL.deleteOrderDetail(orderDetail);
    }
}