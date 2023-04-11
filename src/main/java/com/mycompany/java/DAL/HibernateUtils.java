/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.*;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

/**
 *
 * @author Admin
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;
    
//    private static SessionFactory buildSessionFactory() {
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("C:\\Users\\asus\\OneDrive\\Documents\\NetBeansProjects\\SaleManagement\\src\\main\\java\\com\\mycompany\\resources\\hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//        return metadata.getSessionFactoryBuilder().build();
//    }
    static {
        Configuration conf = new Configuration();
        Properties prop = new Properties();
        
        prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        prop.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
        prop.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/shopmarket");
        prop.setProperty(Environment.USER, "root");
        prop.setProperty(Environment.PASS, "");
        prop.setProperty(Environment.POOL_SIZE, "4");
        prop.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        prop.setProperty(Environment.CACHE_PROVIDER_CONFIG, "org.hibernate.cache.internal.NoCacheProvider");
        prop.setProperty(Environment.SHOW_SQL, "true");
        conf.setProperties(prop);
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Customers.class);
        conf.addAnnotatedClass(Order.class);
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(Vegetable.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        sessionFactory = conf.buildSessionFactory(serviceRegistry);

}
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void close() {
        getSessionFactory().close();
    }
}
