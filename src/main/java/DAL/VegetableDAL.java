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
    
    public List<Vegetable> getVegetableList() {
        List<Vegetable> vegetableList;

        session.beginTransaction();

        Query query = session.createQuery("FROM Vegetable");

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
        session.beginTransaction();
        session.save(vegetable);
        session.getTransaction().commit();
    }

    public void updateVegetable(Vegetable vegetable) {
        session.beginTransaction();
        session.update(vegetable);
        session.getTransaction().commit();
    }

    public void deleteVegetable(Vegetable vegetable) {
        session.beginTransaction();
        session.delete(vegetable);
        session.getTransaction().commit();

    }

}