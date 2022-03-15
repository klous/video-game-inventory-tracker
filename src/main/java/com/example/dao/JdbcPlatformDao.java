package com.example.dao;

import com.example.model.Platform;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPlatformDao implements PlatformDao{

  private final JdbcTemplate jdbcTemplate;

  public JdbcPlatformDao(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<Platform> getPlatformsForGame(int gameID) {
        List<Platform> platformList = new ArrayList<>();
        String sql = "SELECT platform.platform_id, platform_name, platform_nickname, platform.description, image_url\n" +
                "FROM platform\n" +
                "JOIN platform_game pg ON pg.platform_id = platform.platform_id\n" +
                "WHERE game_id=?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gameID);
        if(results.next()){
            platformList.add(mapRowToPlatform(results));
        }
        return null;
    }

    private Platform mapRowToPlatform(SqlRowSet results) {

        Platform platform = new Platform();

        //todo map the row to the Platform object using setters

        return platform;
    }
}
