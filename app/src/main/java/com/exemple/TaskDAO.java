package com.exemple;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TaskDAO {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(Task task) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(task);
            session.getTransaction().commit();
        }
    }

    public Task findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Task.class, id);
        }
    }

    public List<Task> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Task", Task.class).list();
        }
    }

    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Task p = session.get(Task.class, id);
            if (p != null) session.remove(p);
            session.getTransaction().commit();
        }
    }
    public void update(Task task) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(task);
            session.getTransaction().commit();
        }
    }
} 