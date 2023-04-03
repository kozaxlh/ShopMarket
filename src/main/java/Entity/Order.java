/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Shopmarket.Order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shopmarket.Order.findAll", query = "SELECT o FROM Order o"),
    @NamedQuery(name = "Shopmarket.Order.findByOrderID", query = "SELECT o FROM Order o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "Shopmarket.Order.findByDate", query = "SELECT o FROM Order o WHERE o.date = :date"),
    @NamedQuery(name = "Shopmarket.Order.findByTotal", query = "SELECT o FROM Order o WHERE o.total = :total")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrderID")
    private Integer orderID;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "Total")
    private float total;
    @Basic(optional = false)
    @Lob
    @Column(name = "Note")
    private String note;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customer;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "order")
    private List<OrderDetail> orderdetailList;

    public Order() {
    }

    public Order(Integer orderID) {
        this.orderID = orderID;
    }

    public Order(Integer orderID, Date date, float total, String note) {
        this.orderID = orderID;
        this.date = date;
        this.total = total;
        this.note = note;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setDate(Calendar date) {
        this.date = date.getTime();
    }
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Customers getCustomerID() {
        return customer;
    }

    public void setCustomerID(Customers customerID) {
        this.customer = customerID;
    }

    @XmlTransient
    public List<OrderDetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<OrderDetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Order1[ orderID=" + orderID + " ]";
    }
    
}
