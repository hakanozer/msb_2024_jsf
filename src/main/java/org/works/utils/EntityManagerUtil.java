package org.works.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {

    private EntityManagerUtil() {
        throw new AssertionError();
    }

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MSBPU");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
