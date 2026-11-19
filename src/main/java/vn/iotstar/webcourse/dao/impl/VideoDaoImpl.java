package vn.iotstar.webcourse.dao.impl;

import jakarta.persistence.*;
import vn.iotstar.webcourse.dao.VideoDao;
import vn.iotstar.webcourse.model.Video;
import java.util.List;

public class VideoDaoImpl implements VideoDao {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataSource");

    @Override
    public void insert(Video video) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(video);
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) trans.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> findAll(int page, int pageSize) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Video> query = em.createQuery("SELECT v FROM Video v ORDER BY v.id DESC", Video.class);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public long count() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT COUNT(v) FROM Video v", Long.class).getSingleResult();
        } finally {
            em.close();
        }
    }
}