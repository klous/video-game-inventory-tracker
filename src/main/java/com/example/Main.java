package com.example;

import com.example.dao.GameDao;
import com.example.dao.JdbcGameDao;
import com.example.model.Game;
import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/VideoGameDB");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        GameDao gameDao = new JdbcGameDao(dataSource);

        System.out.println(displayGame(gameDao.getGame(8)));

    }

    private static String displayGame(Game game){
        String gameName = game.getGameName();
        int gameID = game.getGameID();
        String gameDescription = game.getDescription();

        String output = "gameID: " + gameID + " | Game Name: " + gameName + "\nDescription: " + gameDescription +"\nAvailable on these platform ids: ";

        String platformIdString ="(";
        Integer[] platformIDs = game.getPlatformIDs();
        for (int i = 0; i < platformIDs.length;i++){
            platformIdString += platformIDs[i];
            if(i< platformIDs.length-1){
                platformIdString +=", ";
            }

        }
        return output + platformIdString;
    }

}


