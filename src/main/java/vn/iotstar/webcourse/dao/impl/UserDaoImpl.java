package vn.iotstar.webcourse.dao.impl;

import jakarta.persistence.*;
import vn.iotstar.webcourse.dao.UserDao;
import vn.iotstar.webcourse.model.User;

public class UserDaoImpl implements UserDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Testing");

    @Override
    public User get(String username) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.userName = :username", User.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void insert(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            return !query.getResultList().isEmpty();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean checkExistUsername(String username) {
        return get(username) != null;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.phone = :phone", User.class);
            query.setParameter("phone", phone);
            return !query.getResultList().isEmpty();
        } finally {
            em.close();
        }
    }
}