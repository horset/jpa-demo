package com.martychen.demo.jpa;

import javax.persistence.Persistence;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Demo is started");

        createPersistenceContext();

        System.out.println("Demo is ended");
    }

    private static void createPersistenceContext() {
        Persistence.createEntityManagerFactory("my-persistence-unit");
    }
}