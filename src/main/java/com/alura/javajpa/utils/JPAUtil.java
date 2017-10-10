package com.alura.javajpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by MarcosNami on 10/9/2017.
 */
public class JPAUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas-postgresql");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
