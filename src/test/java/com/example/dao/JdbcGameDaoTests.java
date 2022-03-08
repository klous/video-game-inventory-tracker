package com.example.dao;

import com.example.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JdbcGameDaoTests extends BaseDaoTests{

    private static final Game GAME_1 = new Game("Super Mario Bros", 1, "The classic Super Mario Bros game, start at level 1-1 and see how far you can get!");

    private static final List<Integer> PLATFORMS_GAME_2 = new ArrayList<>(){{
        add(2);
        add(7);
    }};
    private static final Game GAME_2 = new Game("Super Mario Bros 3", 2, "A re-thought Mario Bros game where you could get and store power ups and had an map that you would travel around in between levels", PLATFORMS_GAME_2);

    private JdbcGameDao sut;

    @Before
    public void setup(){ sut = new JdbcGameDao(dataSource);}

    @Test
    public void getGame_returns_correct_game_for_id() {
        Game game = sut.getGame(1);
        assertGamesMatch(GAME_1, game);
    }

    @Test
    public void getGame_returns_correct_game_and_platforms_for_id(){
        Game game = sut.getGame(2);
        assertGamesAndPlatformsMatch(GAME_2, game);
    }


    //test to make sure adding to platforms works

    private void assertGamesMatch(Game expected, Game actual){
        Assert.assertEquals(expected.getGameID(), actual.getGameID());
        Assert.assertEquals(expected.getGameName(), actual.getGameName());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

    private void assertGamesAndPlatformsMatch(Game expected, Game actual){
        assertGamesMatch(expected, actual);
        // check length of array of platform ids
        Assert.assertEquals(expected.getPlatformIDs().length, actual.getPlatformIDs().length);
        //check individual values are equivalent
        Integer[] expectedPlatforms = expected.getPlatformIDs();
        Integer[] actualPlatforms = actual.getPlatformIDs();
        for(int i = 0; i< expectedPlatforms.length; i++){
            Assert.assertEquals(expectedPlatforms[i], actualPlatforms[i]);
        }
    }

}
