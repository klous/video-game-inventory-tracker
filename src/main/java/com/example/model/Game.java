package com.example.model;

import java.util.List;

public class Game {
    // platforms have games... games are available on a platform

    private String gameName;
    private int gameID;
    private String Description;
    private boolean physical;

    //todo should I really be returning a list of the platformIDs?
    public List<Integer> getPlatformIDs() {
        return platformIDs;
    }

    public void setPlatformIDs(List<Integer> platformIDs) {this.platformIDs = platformIDs;}

    public void addPlatformID(int platformID){
        this.platformIDs.add(platformID);
    }

    private List<Integer> platformIDs;


    public boolean isPhysical() {return physical;}
    public void setPhysical(boolean physical) {
        this.physical = physical;
    }

    public String getGameName() {return gameName;}
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameID() {return gameID;}
    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getDescription() {return Description;}
    public void setDescription(String description) {
        Description = description;
    }

}
