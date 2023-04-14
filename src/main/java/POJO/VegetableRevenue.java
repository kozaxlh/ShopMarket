/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import Entity.Vegetable;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
public class VegetableRevenue {

    private Vegetable vegetable;
    private long quantity;
    private float total;

    public VegetableRevenue() {
    }
    
    public VegetableRevenue(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public VegetableRevenue(Vegetable vegetable, float total) {
        this.vegetable = vegetable;
        this.total = total;
    }

    public VegetableRevenue(Vegetable vegetable, double total) {
        this.vegetable = vegetable;
        this.total = (float) total;
    }

    public VegetableRevenue(Vegetable vegetable, long quantity, double total) {
        this.vegetable = vegetable;
        this.quantity = quantity;
        this.total = (float) total;
    }
    
    

}
