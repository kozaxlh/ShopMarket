/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.Vegetable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class VegetableDAL {

    Session session;

    public VegetableDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List<Vegetable> getVegetableInCategory(int CategoryID) {
        List<Vegetable> vegetableList;

        session.beginTransaction();

        Query query = session.createQuery("FROM Vegetable WHERE CatagoryID = :categoryID");
        query.setParameter("categoryID", CategoryID);

        vegetableList = query.list();
        session.getTransaction().commit();

        return vegetableList;
    }

    public Vegetable getVegetable(int VegetableID) {
        Vegetable vegetable;

        session.beginTransaction();
        vegetable = session.get(Vegetable.class, VegetableID);
        session.getTransaction().commit();

        return vegetable;

    }

    public void addVegetable(Vegetable vegetable) {
        session.save(vegetable);
    }

    public void updateVegetable(Vegetable vegetable) {
        session.update(vegetable);
    }

    public void deleteVegetable(Vegetable vegetable) {
        session.delete(vegetable);
    }
    
}