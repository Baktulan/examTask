package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.entity.Comment;
import org.example.entity.Post;
import org.example.entity.Profile;
import org.example.entity.User;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateDataBase {
    public static EntityManager getEntityManager(){
            Properties properties= new Properties();
            properties.setProperty(Environment.DRIVER,"org.postgresql.Driver");
            properties.setProperty(Environment.URL,"jdbc:postgresql://localhost:5432/java");
            properties.setProperty(Environment.USER,"postgres");
            properties.setProperty(Environment.PASS,"1234");
            properties.setProperty(Environment.HBM2DDL_AUTO,"update");
            properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
            properties.setProperty(Environment.SHOW_SQL,"true");
            Configuration configuration = new Configuration();
            configuration.addProperties(properties);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Post.class);
            configuration.addAnnotatedClass(Profile.class);
            configuration.addAnnotatedClass(Comment.class);
            return configuration.buildSessionFactory().createEntityManager();
        }
    }

