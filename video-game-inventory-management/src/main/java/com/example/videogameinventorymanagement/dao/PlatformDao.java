package com.example.videogameinventorymanagement.dao;

import com.example.videogameinventorymanagement.model.Platform;

import java.util.List;

public interface PlatformDao {
    List<Platform> getPlatformsForGame(int gameID);
}
