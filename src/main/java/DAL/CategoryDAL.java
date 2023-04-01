/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.Category;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class CategoryDAL {

    Session session;

    public CategoryDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List<Category> getCategoryList() {
        List<Category> category;

        session.beginTransaction();
        category = session.createQuery("FROM Category", Category.class).list();
        session.getTransaction().commit();

        return category;
    }

    public Category getCategory(int CategoryID) {
        Category category;
        
        session.beginTransaction();
        category = session.get(Category.class, CategoryID);
        session.getTransaction().commit();
        return category;
    }

    public void addCategory(Category category) {
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    public void updateCategory(Category category) {
        session.beginTransaction();
        session.update(category);
        session.getTransaction().commit();
    }

    public void deleteCategory(Category category) {
        session.beginTransaction();
        session.delete(category);
        session.getTransaction().commit();
    }

}
