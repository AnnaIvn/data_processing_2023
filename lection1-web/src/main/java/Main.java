import Entity.MyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        List<MyEntity> entities;

        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (SessionFactory sessionFactory= new MetadataSources(registry)
            .addAnnotatedClass(MyEntity.class)
            .buildMetadata()
            .buildSessionFactory()) {

            Session session = sessionFactory.openSession();     // opening session
            session.beginTransaction();                         // begin transaction


            session.save(new MyEntity(1, "Sleeping bag 1", 2));
            session.save(new MyEntity(2, "North Face bag", 3));
            session.save(new MyEntity(3, "Light sleeping bag", 1));
            MyEntity update1 = new MyEntity(1, "Bag 1", 2);
            session.update(update1);

            // putting entities from database to list                                         // saving to list
            entities = (List<MyEntity>) session.createQuery("from MyEntity").list();


            session.getTransaction().commit();                  // getting transaction and making commit
        }

        for (MyEntity entity: entities){      // going through list
            System.out.println(entity);       // printing out entities
        }

        System.out.println("All good");


    }

}
