package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // platforms have games... games are available on a platform

    private String gameName;
    private int gameID;
    private String Description;

    //todo this is an attribute of a OWNERSHIP - how it is owned - not a game, so should not really be here...
    private boolean physical;

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
