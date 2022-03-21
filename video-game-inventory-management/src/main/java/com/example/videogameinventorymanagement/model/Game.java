package com.example.videogameinventorymanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // platforms have games... games are available on a platform

    private String gameName;
    private int gameID;
    private String description;

    public List<Integer> getPlatformIDList() {
        return platformIDList;
    }

    public void setPlatformIDList(List<Integer> platformIDList) {
        this.platformIDList = platformIDList;
    }

    private List<Integer> platformIDList = new ArrayList<>();

    public Game(){}

    public Game(String gameName, int gameID, String description){
        this.gameName = gameName;
        this.gameID = gameID;
        this.description = description;
    };

    //todo I don't think I really like how this takes a List in the constructor...an array could be used instead
    public Game(String gameName, int gameID, String description, List<Integer> platformIDList){
        this.gameName = gameName;
        this.gameID = gameID;
        this.description = description;
        this.platformIDList = platformIDList;
    };


    public void setPlatformIDs(List<Integer> platformIDs) {
        this.platformIDList = platformIDs;}

    public void addPlatformID(int platformID){
        this.platformIDList.add(platformID);
    }


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
