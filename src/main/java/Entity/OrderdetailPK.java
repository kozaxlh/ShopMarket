/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Admin
 */
@Embeddable
public class OrderdetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "OrderID")
    private int orderID;
    @Basic(optional = false)
    @Column(name = "VegetableID")
    private int vegetableID;

    public OrderdetailPK() {
    }

    public OrderdetailPK(int orderID, int vegetableID) {
        this.orderID = orderID;
        this.vegetableID = vegetableID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getVegetableID() {
        return vegetableID;
    }

    public void setVegetableID(int vegetableID) {
        this.vegetableID = vegetableID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderID;
        hash += (int) vegetableID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderdetailPK)) {
            return false;
        }
        OrderdetailPK other = (OrderdetailPK) object;
        if (this.orderID != other.orderID) {
            return false;
        }
        if (this.vegetableID != other.vegetableID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OrderdetailPK[ orderID=" + orderID + ", vegetableID=" + vegetableID + " ]";
    }
    
}
