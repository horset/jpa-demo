package com.martychen.demo.jpa.persistence.daos;

import com.martychen.demo.jpa.persistence.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BookDao {
    private final EntityManagerFactory entityManagerFactory;

    public BookDao(EntityManagerFactory entityManagerFactory) {
        if (entityManagerFactory == null) {
            throw new IllegalArgumentException("entityManagerFactory cannot be null.");
        }

        this.entityManagerFactory = entityManagerFactory;
    }

    public void persist(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Book find(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book result = entityManager.find(Book.class, id);
        entityManager.close();
        return result;
    }
}
