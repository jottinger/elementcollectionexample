package com.autumncode.alloys;

import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class StructureTest {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

    EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    @Test
    public void testStructure() {
        EntityManager manager = getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Element copper = new Element();
        copper.setName("copper");
        manager.persist(copper);
        Element zinc = new Element();
        zinc.setName("zinc");
        manager.persist(zinc);
        Alloy a = new Alloy();
        a.setName("brass");
        a.getComposition().put(zinc, 0.35);
        a.getComposition().put(copper, 0.65);
        manager.persist(a);
        tx.commit();
        manager.close();

        manager = getEntityManager();
        tx = manager.getTransaction();
        tx.begin();
        List<Alloy> alloys = manager.createQuery("select a from Alloy a").getResultList();
        for(Alloy alloy:alloys) {
            System.out.println(a);
        }
        tx.commit();
        manager.close();
    }
}
