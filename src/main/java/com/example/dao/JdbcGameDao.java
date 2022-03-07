package com.example.dao;

import com.example.model.Game;
import com.example.model.Platform;
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
        int[] platformIDs = null;
        //the game_id alone doesn't uniquely identify a game that can be owned since you have to own it on a platform
        String sql =
                "SELECT game_name, game.game_id, game.description, platform_game.platform_id\n" +
                "FROM game\n" +
                "INNER JOIN platform_game on platform_game.game_id = game.game_id\n" +
                "INNER JOIN platform on platform.platform_id = platform_game.platform_id\n" +
                "WHERE game.game_id = ?\n" +
                "ORDER BY platform_game.platform_id ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gameID);

        while(results.next()){
            game = mapRowToGame(results);

        }
        return game;
    }


    @Override
    public List<Game> getGamesByPlatform(int platformID) {
        List <Game> gameList = new ArrayList<>();

        String sql = "SELECT game_name, game.game_id, platform_name, platform.platform_id\n" +
                "FROM game\n" +
                "INNER JOIN platform_game on platform_game.game_id = game.game_id\n" +
                "INNER JOIN platform on platform.platform_id = platform_game.platform_id\n" +
                "WHERE platform_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, platformID);
        while(results.next()){
            gameList.add(mapRowToGame(results));
        }

        return gameList;
    }

    @Override
    public Game createGame(Game game) {
        return null;
    }

    @Override
    public void updateGame(Game Game) {

    }

    @Override
    public void deleteGame(int gameID) {

    }

    @Override
    public void addGameToPlatform(int gameID, Platform platform) {

    }

    @Override
    public void removeGameFromPlatform(int gameID, Platform platform) {

    }

    private Game mapRowToGame(SqlRowSet rowSet){
        Game game = new Game();
        // set the attributes for game Object
        game.setGameID(rowSet.getInt("game_id"));
        game.setPhysical(rowSet.getBoolean("physical"));
        game.setGameName(rowSet.getString("game_name"));
        game.addPlatformID(rowSet.getInt("platform_id"));
        if(rowSet.getString("description") != null){
            game.setDescription(rowSet.getString("description"));
        }

        return game;

    }

}
