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
    
    static {
        Configuration conf = new Configuration();
        
            Properties props = new Properties();
                props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
                props.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
                props.put(Environment.URL,"jdbc:mysql://localhost:3306/shopmarket");
                props.put(Environment.USER,"root");
                props.put(Environment.PASS,"");
                props.put(Environment.SHOW_SQL,"true");
                props.put(Environment.POOL_SIZE,"4");
                props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
                props.put(Environment.CACHE_PROVIDER_CONFIG,"org.hibernate.cache.internal.NoCacheProvider");
            
            conf.setProperties(props);

            conf.addAnnotatedClass(Category.class);
            conf.addAnnotatedClass(Customers.class);
            conf.addAnnotatedClass(Vegetable.class);
            conf.addAnnotatedClass(Order.class);
            conf.addAnnotatedClass(OrderDetail.class);
       
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
