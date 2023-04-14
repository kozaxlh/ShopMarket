/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OrderDAL;
import Entity.Order;
import Entity.OrderDetail;
import Entity.Vegetable;
import POJO.VegetableRevenue;
import java.util.ArrayList;
import java.util.Calendar;
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
            obj[i][3] = list.get(i).getTotal();
            obj[i][4] = list.get(i).getNote();
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

    public Object[][] convertVegetableRevenue(Calendar date) {
        List<VegetableRevenue> list = orderDAL.getVegetableRevenue(date);

        return getObjectVegetableRevenue(list);
    }

    public Object[][] convertVegetableRevenue() {
//        List<VegetableRevenue> list = orderDAL.getVegetableRevenue();
        List<VegetableRevenue> list = new ArrayList();

        return getObjectVegetableRevenue(list);
    }

    private Object[][] getObjectVegetableRevenue(List<VegetableRevenue> list) {
        int rows = list.size();
        int cols = 7;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getVegetable().getVegetableID();
            obj[i][1] = list.get(i).getVegetable().getCategory().getName();
            obj[i][2] = list.get(i).getVegetable().getVegetableName();
            obj[i][3] = list.get(i).getVegetable().getUnit();
            obj[i][4] = list.get(i).getQuantity();
            obj[i][5] = list.get(i).getVegetable().getPrice();
            obj[i][6] = list.get(i).getTotal();
        }
        return obj;
    }

    public Order getOrder(int orderID) {
        return orderDAL.getOrder(orderID);
    }
    
    public Order getOrder() {
        return orderDAL.getOrder();
    }

    public List<Order> getOrderList() {
        return orderDAL.getOrderList();
    }

    public void addOrder(Order order, List<OrderDetail> list) throws IllegalArgumentException {
        orderDAL.addOrder(order);
        addOrderDetail(list);
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

    public void addOrderDetail(List<OrderDetail> list) throws IllegalArgumentException {
        int lastID = getOrder().getOrderID();
        VegetableBLL vegetableBLL = new VegetableBLL();
        for (var item : list) {
            Vegetable vegetable = vegetableBLL.getVegetable(item.getOrderdetailPK().getVegetableID());
            if(vegetable.getAmount() - item.getQuantity() < 0) {
                deleteOrder(getOrder());
                throw new IllegalArgumentException("Not enough products to sell");
            }
            
            item.getOrderdetailPK().setOrderID(lastID);
            orderDAL.addOrderDetail(item);
          
            vegetable.setAmount(vegetable.getAmount() - item.getQuantity());
            vegetableBLL.updateVegetable(vegetable);
        }
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDAL.updateOrderDetail(orderDetail);
    }

    public void deleteOrderDetail(OrderDetail orderDetail) {
        orderDAL.deleteOrderDetail(orderDetail);
    }
}
