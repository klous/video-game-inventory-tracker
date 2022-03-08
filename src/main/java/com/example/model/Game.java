package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // platforms have games... games are available on a platform

    private String gameName;
    private int gameID;
    private String description;

    public Game(){}

    public Game(String gameName, int gameID, String description){
        this.gameName = gameName;
        this.gameID = gameID;
        this.description = description;
    };

    public Game(String gameName, int gameID, String description, List<Integer> platformIDs){
        this.gameName = gameName;
        this.gameID = gameID;
        this.description = description;
        this.platformIDs = platformIDs;
    };


    public Integer[] getPlatformIDs() {
        //int[] platformIDsArray = new int[getPlatformIDs().length];
        Integer[] platformIDsArray = platformIDs.toArray(new Integer[0]);

        return platformIDsArray;
    }

    public void setPlatformIDs(List<Integer> platformIDs) {
        this.platformIDs = platformIDs;}

    public void addPlatformID(int platformID){
        this.platformIDs.add(platformID);
    }

    private List<Integer> platformIDs = new ArrayList<>();

    public String getGameName() {return gameName;}
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameID() {return gameID;}
    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getDescription() {return description;}
    public void setDescription(String description) {
        this.description = description;
    }

}
