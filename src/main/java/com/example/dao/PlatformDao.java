package com.example.dao;

import com.example.model.Platform;

import java.util.List;

public interface PlatformDao {

    List<Platform> getPlatformsForGame(int gameID);



}
