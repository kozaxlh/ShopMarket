/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "orderdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "Orderdetail.findByOrderID", query = "SELECT o FROM OrderDetail o WHERE o.orderdetailPK.orderID = :orderID"),
    @NamedQuery(name = "Orderdetail.findByVegetableID", query = "SELECT o FROM OrderDetail o WHERE o.orderdetailPK.vegetableID = :vegetableID"),
    @NamedQuery(name = "Orderdetail.findByQuantity", query = "SELECT o FROM OrderDetail o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Orderdetail.findByPrice", query = "SELECT o FROM OrderDetail o WHERE o.price = :price")
})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderdetailPK orderdetailPK;
    
    @Basic(optional = false)
    @Column(name = "Quantity")
    private short quantity;
    
    @Basic(optional = false)
    @Column(name = "Price")
    private float price;
    
    @JoinColumn(name = "VegetableID", referencedColumnName = "VegetableID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vegetable vegetable;
    
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Order order1;

    public OrderDetail() {
    }

    public OrderDetail(OrderdetailPK orderdetailPK) {
        this.orderdetailPK = orderdetailPK;
    }

    public OrderDetail(OrderdetailPK orderdetailPK, short quantity, float price) {
        this.orderdetailPK = orderdetailPK;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail(int orderID, int vegetableID) {
        this.orderdetailPK = new OrderdetailPK(orderID, vegetableID);
    }

    public OrderdetailPK getOrderdetailPK() {
        return orderdetailPK;
    }

    public void setOrderdetailPK(OrderdetailPK orderdetailPK) {
        this.orderdetailPK = orderdetailPK;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public Order getOrder1() {
        return order1;
    }

    public void setOrder1(Order order1) {
        this.order1 = order1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderdetailPK != null ? orderdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderdetailPK == null && other.orderdetailPK != null) || (this.orderdetailPK != null && !this.orderdetailPK.equals(other.orderdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Orderdetail[ orderdetailPK=" + orderdetailPK + " ]";
    }
    
}
