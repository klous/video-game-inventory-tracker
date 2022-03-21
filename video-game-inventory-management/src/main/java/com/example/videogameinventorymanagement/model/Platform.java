package com.example.videogameinventorymanagement.model;

public class Platform {
    private String name;
    private int platformID;
    private String manufacturer;
    private String nickname;
    private String description;
    private String imageURL;

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {return manufacturer;}
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNickname() {return nickname;}
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {return description;}
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {return imageURL;}
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getPlatformID() {return platformID;}
    public void setPlatformID(int platformID) {
        this.platformID = platformID;
    }
}
