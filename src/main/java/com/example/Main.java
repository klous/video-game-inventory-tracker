package com.example;

import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/VideoGameDB");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        


    }
}
