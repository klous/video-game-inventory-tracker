package com.example.dao;

import com.example.model.Game;
import com.example.model.Platform;

import java.util.List;

public interface GameDao {
    Game getGame(int gameID);

    List<Game> getGamesByPlatform(int platformID);

    Game createGame(Game game);

    void updateGame(Game Game);

    void deleteGame(int gameID);

    void addGameToPlatform(int gameID, Platform platform);

    void removeGameFromPlatform(int gameID, Platform platform);






}
