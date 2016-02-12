
package org.aadsp.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ConexaoHibernate{
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            return cfg.buildSessionFactory();
//            AnnotationConfiguration configuration = new AnnotationConfiguration();          
//            return configuration.configure("hibernate.cfg.xml").buildSessionFactory(); 
        }
        catch(Throwable e)
        { 
            System.out.println("Criação inicial do objeto SessionFactory falhou. Erro:"+e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
      public static SessionFactory getSessionFactory()
    {

        return sessionFactory;

    }
    
}
