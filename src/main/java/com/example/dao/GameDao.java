package com.example.dao;

import com.example.model.Game;

import java.util.List;

public interface GameDao {
    Game getGame(int gameID);

    List<Game> getGamesByPlatform(int platformID);

    Game createGame(Game game);

    Game updateGame(int gameID, Game game);

    boolean deleteGame(int gameID);

    boolean addGameToPlatform(int gameID, int platformID);

    boolean removeGameFromPlatform(int gameID, int platformID);

    boolean addGameToUserCollection(int gameID, int platformID, boolean physical, int quantity);

    boolean addGameToListOfPlatforms(int gameID, int[] platformIDs);

}
