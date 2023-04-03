/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.VegetableDAL;
import Entity.Vegetable;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VegetableBLL {

    VegetableDAL vegetableDAL;

    public VegetableBLL() {
        vegetableDAL = new VegetableDAL();
    }

    public List<Vegetable> loadVegetable() {
        return vegetableDAL.getVegetableList();
    }
    
    public Object[][] convertList(List<Vegetable> list) {
        int rows = list.size();
        int cols = 6;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getVegetableID();
            obj[i][1] = list.get(i).getVegetableName();
            obj[i][2] = list.get(i).getCategory().getName();
            obj[i][3] = list.get(i).getUnit();
            obj[i][4] = list.get(i).getAmount();
            obj[i][5] = list.get(i).getPrice();
        }
        return obj;
    }

    public void addVegetable(Vegetable vegetable) {
        vegetableDAL.addVegetable(vegetable);
    }
    
    public Vegetable getVegetable(int vegetableID) {
        return vegetableDAL.getVegetable(vegetableID);
    }
    
    public void deleteVegetable(Vegetable vegetable) {
        vegetableDAL.deleteVegetable(vegetable);
    }
    
    public boolean updateVegetable(Vegetable vegetable) {
        if(vegetable.getAmount() >= 0)
            vegetableDAL.updateVegetable(vegetable);
        else
            return false;
        return true;
    }
}
