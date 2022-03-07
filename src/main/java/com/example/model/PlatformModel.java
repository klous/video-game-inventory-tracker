package com.example.model;

public class PlatformModel {
    private String name;
    private int platformModelID;
    private Platform platform;
    private String description;
    private String wikiURL;

    public int getPlatformModelID() {return platformModelID;}
    public void setPlatformModelID(int platformModelID) {
        this.platformModelID = platformModelID;
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;}

    public Platform getPlatform() {return platform;}
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getDescription() {return description;}
    public void setDescription(String description) {
        this.description = description;
    }

    public String getWikiURL() {return wikiURL;}
    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }


}
