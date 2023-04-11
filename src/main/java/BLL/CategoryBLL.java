/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CategoryDAL;
import Entity.Category;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryBLL {

    CategoryDAL categoryDAL;

    public CategoryBLL() {
        categoryDAL = new CategoryDAL();
    }

    public List loadCategory() {
        return categoryDAL.getCategoryList();
    }

    public Object[][] convertList(List<Category> list) {
        int rows = list.size();
        int cols = 4;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getCatagoryID();
            obj[i][1] = list.get(i).getName();
            obj[i][2] = list.get(i).getDescription();
            obj[i][3] = list.get(i).getVegetable().size();
        }
        return obj;
    }

    public void newCategory(Category category) {
        categoryDAL.addCategory(category);
    }                     

    public Category getCategory(int CategoryID) {
        return categoryDAL.getCategory(CategoryID);
    }
    
    public Category getCategory(String CategoryName) {
        return categoryDAL.getCategory(CategoryName);
    }

    public void updateCategory(Category category) {
        categoryDAL.updateCategory(category);
    }

    public void deleteCategory(Category category) {
        categoryDAL.deleteCategory(category);
    }
}
