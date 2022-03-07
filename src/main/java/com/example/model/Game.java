package com.example.model;

public class Game {

    private String gameName;
    private int gameID;
    private String Description;
    private Platform platform;
    private boolean physical;

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

    public Platform getPlatform() {return platform;}
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

}
