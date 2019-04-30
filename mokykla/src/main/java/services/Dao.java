package services;


import helpers.EntityManagerHelper;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

public class Dao<T> {

    // CRUD

    // C
    public T create(T entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction(); // atidarom transakciją

        em.persist(entity);

        EntityManagerHelper.commit(); // uždaome transakciją
        EntityManagerHelper.closeEntityManager();

        return entity;
    }

    // R
    public T read(Class<T> clazz, Object pk) {

        EntityManager em = EntityManagerHelper.getEntityManager();

        T entity = em.find(clazz, pk);

        EntityManagerHelper.closeEntityManager();
        return entity;
    }
    public T read(Class<T> clazz, Object pk, String graph) {

        EntityManager em = EntityManagerHelper.getEntityManager();

        EntityGraph entityGraph = em.getEntityGraph(graph);
        Map<String, Object> properties = new HashMap<>();
        properties.put(EntityManagerHelper.FETCH_GRAPH, entityGraph);
        T entity = em.find(clazz, pk, properties);

//        EntityManagerHelper.closeEntityManager();
        return entity;
    }

    // U
    public T update(T entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction(); // atidarom transakciją

        entity = em.merge(entity);

        EntityManagerHelper.commit(); // uždaome transakciją
        EntityManagerHelper.closeEntityManager();

        return entity;
    }

    // D
    public void delete(T entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction(); // atidarom transakciją

        entity = em.merge(entity);
        em.remove(entity);

        EntityManagerHelper.commit(); // uždaome transakciją
        EntityManagerHelper.closeEntityManager();

    }
}