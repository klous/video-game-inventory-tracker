package com.example.dao;

import com.example.model.Game;
import com.example.model.Platform;

import java.util.List;

public interface GameDao {
    Game getGame(int gameID);

    List<Game> getGamesByPlatform(int platformID);

    Game createGame(Game game);

    void updateGame(Game Game);

    boolean deleteGame(int gameID);

    boolean addGameToPlatform(int gameID, int platformID);

    boolean removeGameFromPlatform(int gameID, int platformID);

    boolean addGameToUserCollection(int gameID, int platformID, boolean physical, int quantity);

}
