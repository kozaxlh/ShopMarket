/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
public class VegetableRevenue {

    private String vegetableName;
    private long quantity;
    private float price;

    public VegetableRevenue() {
    }

    public VegetableRevenue(String vegetableName, float price) {
        this.vegetableName = vegetableName;
        this.price = price;
    }

    public VegetableRevenue(String vegetableName, double price) {
        this.vegetableName = vegetableName;
        this.price = (float) price;
    }

    public VegetableRevenue(String vegetableName, long quantity, double price) {
        this.vegetableName = vegetableName;
        this.quantity = quantity;
        this.price = (float) price;
    }
    
    

}
