/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCatagoryID", query = "SELECT c FROM Category c WHERE c.catagoryID = :catagoryID"),
    @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name"),
    @NamedQuery(name = "Category.findByDescription", query = "SELECT c FROM Category c WHERE c.description = :description")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CatagoryID")
    private Integer catagoryID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "CatagoryID", referencedColumnName = "CatagoryID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Vegetable vegetable;

    public Category() {
    }

    public Category(Integer catagoryID) {
        this.catagoryID = catagoryID;
    }

    public Category(Integer catagoryID, String name) {
        this.catagoryID = catagoryID;
        this.name = name;
    }

    public Integer getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(Integer catagoryID) {
        this.catagoryID = catagoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catagoryID != null ? catagoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.catagoryID == null && other.catagoryID != null) || (this.catagoryID != null && !this.catagoryID.equals(other.catagoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Category[ catagoryID=" + catagoryID + " ]";
    }
    
}
