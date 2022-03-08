package com.example.dao;

import com.example.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGameDao implements GameDao{

    private final JdbcTemplate jdbcTemplate;

     public JdbcGameDao(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }

    @Override
    public Game getGame(int gameID) {
        Game game = null;
        //the game_id alone doesn't uniquely identify a game that can be owned since you have to own it on a platform

        //todo two separate queries - one for the game info, a second for the platform_ids
        String sql =
                "SELECT game_name, game_id, description\n" +
                "FROM game\n" +
                "WHERE game_id = ?\n";
        SqlRowSet gameResult = jdbcTemplate.queryForRowSet(sql, gameID);

        if(gameResult.next()){
            game = mapRowToGame(gameResult);
        }

        sql =
                "SELECT platform.platform_id\n" +
                "FROM game\n" +
                "INNER JOIN platform_game on platform_game.game_id = game.game_id\n" +
                "INNER JOIN platform on platform.platform_id = platform_game.platform_id\n" +
                "WHERE game.game_id = ?\n" +
                "ORDER BY platform.platform_id;";
        SqlRowSet IDresults = jdbcTemplate.queryForRowSet(sql, gameID);

        List <Integer> platformIDs = new ArrayList<>();

        while(IDresults.next()){
            platformIDs.add(mapRowToPlatformID(IDresults));
        }
        game.setPlatformIDs(platformIDs);

        return game;
    }


    @Override
    public List<Game> getGamesByPlatform(int platformID) {
        List <Game> gameList = new ArrayList<>();

        String sql =
                "SELECT game_name, game.game_id, game.description\n" +
                        "FROM game\n" +
                        "INNER JOIN platform_game on platform_game.game_id = game.game_id\n" +
                        "INNER JOIN platform on platform.platform_id = platform_game.platform_id\n" +
                        "WHERE platform_game.platform_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, platformID);
        while(results.next()){
            gameList.add(mapRowToGame(results));
        }

        return gameList;
    }

    @Override
    public Game createGame(Game game) {
        String sql =
                "INSERT INTO game \n" +
                "(game_name, description)\n" +
                "VALUES\n +" +
                "(?, ?)\n" +
                "RETURNING game_id;";
        int newID = jdbcTemplate.update(sql, game.getGameName(), game.getDescription());

        Game createdGame = getGame(newID);

        return createdGame;
    }

    @Override
    public Game updateGame(int gameID, Game game) {
         Game updatedGame = null;
         String sql =
                 "UPDATE game SET game_name = ?, description=? " +
                 "WHERE game_id=?;";
         jdbcTemplate.update(sql, game.getGameName(), game.getDescription(), gameID );
         updatedGame = getGame(gameID);

         return updatedGame;
    }

    @Override
    public boolean deleteGame(int gameID) {
         String sql =
             "DELETE FROM games_users_own\n" +
             "WHERE game_id = ?;\n" +
             "DELETE FROM platform_game\n" +
             "WHERE game_id = ?;\n" +
             "DELETE FROM game\n" +
             "WHERE game_id = ?;";
         // jdbcTemplate.update returns an integer of rows affected, should be 1 when successfully deleting a row by id
         return jdbcTemplate.update(sql, gameID, gameID, gameID) == 1;
    }

    @Override
    public boolean addGameToPlatform(int gameID, int platformID) {
        String sql =
            "INSERT into platform_game\n" +
            "(game_id, platform_id)\n" +
            "VALUES\n" +
            "(?, ?);";
        // jdbcTemplate.update returns an integer of rows affected, so if 1 row affected / inserted will be true.
        return jdbcTemplate.update(sql, gameID, platformID) == 1;
    }

    @Override
    public boolean addGameToListOfPlatforms(int gameID, int[] platformIDs) {
         boolean platformIDsAdded = false;
         for(int platformID : platformIDs){
             platformIDsAdded = addGameToPlatform(gameID, platformID);
             // if a platform id was NOT added, the addGameToPlatform will return false - then we check for that here and break out of for loop
             if(platformIDsAdded == false){
                 break;
             }
        }
         return platformIDsAdded;
     }


    @Override
    public boolean removeGameFromPlatform(int gameID, int platformID) {
        return false;
    }

    @Override
    public boolean addGameToUserCollection(int gameID, int platformID, boolean physical, int quantity) {
        return false;
    }




    private int mapRowToPlatformID(SqlRowSet rowSet){
         return (rowSet.getInt("platform_id"));
    }

    private Game mapRowToGame(SqlRowSet rowSet){
        Game game = new Game();
        // set the attributes for game Object
        game.setGameID(rowSet.getInt("game_id"));
        game.setGameName(rowSet.getString("game_name"));
        if(rowSet.getString("description") != null){
            game.setDescription(rowSet.getString("description"));
        }
        return game;

    }

}
