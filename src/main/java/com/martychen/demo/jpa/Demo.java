package com.martychen.demo.jpa;

import com.martychen.demo.jpa.persistence.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        System.out.println("Demo is started");

        createPersistenceContext();

        Book book = new Book();
        book.setId(1);
        book.setTitle("Hello World");
        book.setDescription("It is always the first application!");

        persistBook(book);
        showPersistedBookWithId(book.getId());

        System.out.println("Demo is ended");
    }

    private static void createPersistenceContext() {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    private static void persistBook(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void showPersistedBookWithId(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book result = entityManager.find(Book.class, id);
        System.out.println(result);
        entityManager.close();
    }
}