package com.ken.simplon.Util;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagers {
    private static EntityManagerFactory managerFactory ;
    public static EntityManagerFactory getEntityManagerFactory() {
        if(managerFactory == null) {
            managerFactory = Persistence.createEntityManagerFactory("simplonlite");
        }
        return managerFactory;
    }
    public static void shutdown() {
        if(managerFactory != null) {
            managerFactory.close();
        }
    }

}
