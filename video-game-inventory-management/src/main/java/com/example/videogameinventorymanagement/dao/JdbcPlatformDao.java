package com.example.videogameinventorymanagement.dao;

import com.example.videogameinventorymanagement.model.Platform;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPlatformDao implements PlatformDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPlatformDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Platform> getPlatformsForGame(int gameID) {
        List<Platform> platforms = new ArrayList<>();
        String sql = "SELECT platform.platform_id as pid, platform_name, platform_nickname, platform.description as platform_description, manufacturer_name, image_url\n" +
                "FROM platform\n" +
                "JOIN manufacturer manu on manu.manufacturer_id = platform.manufacturer_id\n" +
                "JOIN platform_game on platform_game.platform_id = platform.platform_id\n" +
                "WHERE game_id = ?\n" +
                "ORDER BY pid;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gameID);
        while(results.next()){
            platforms.add(mapRowToPlatform(results));
        }
        return platforms;
    }

    @Override
    public List<Platform> getAllPlatforms() {
        List<Platform> platforms = new ArrayList<>();
        String sql = "SELECT platform.platform_id as pid, platform_name, platform_nickname, platform.description as platform_description, manufacturer_name, image_url\n" +
                "FROM platform\n" +
                "JOIN manufacturer manu on manu.manufacturer_id = platform.manufacturer_id\n" +
                "ORDER BY pid;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            platforms.add(mapRowToPlatform(results));
        }
        return platforms;
    }

    private Platform mapRowToPlatform(SqlRowSet sqlRowSet) {

        Platform platform = new Platform();
        platform.setName(sqlRowSet.getString("platform_name"));
        platform.setPlatformID(sqlRowSet.getInt("pid"));
        platform.setDescription(sqlRowSet.getString("platform_description"));
        platform.setNickname(sqlRowSet.getString("platform_nickname"));
        platform.setImageURL(sqlRowSet.getString("image_url"));
        platform.setManufacturer(sqlRowSet.getString("manufacturer_name"));

        return platform;
    }
}
