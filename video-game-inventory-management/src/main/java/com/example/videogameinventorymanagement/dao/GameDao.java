package com.example.videogameinventorymanagement.dao;

import com.example.videogameinventorymanagement.model.Game;

import java.util.List;

public interface GameDao {
    Game getGame(int gameID);

    List<Game> getGamesByPlatform(int platformID);

    Game createGame(Game game);

    Game updateGame(int gameID, Game game);

    boolean deleteGame(int gameID);

    List<Game> getGamesOwnedByUser(int userID);

    boolean addGameToPlatform(int gameID, int platformID);

    List<Game> searchForGames(String searchTerm);

    boolean removeGameFromPlatform(int gameID, int platformID);

    boolean addGameToUserCollection(int userID, int gameID, int platformID, boolean physical, int quantity);

    boolean addGameToListOfPlatforms(int gameID, int[] platformIDs);
}
