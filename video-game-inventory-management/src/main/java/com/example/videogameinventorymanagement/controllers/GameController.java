package com.example.videogameinventorymanagement.controllers;

import com.example.videogameinventorymanagement.dao.GameDao;
import com.example.videogameinventorymanagement.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class GameController {

    private GameDao gameDao;

    public GameController(GameDao gameDao){this.gameDao = gameDao;}

    @PreAuthorize("permitAll")
    @RequestMapping(path="/api/game/{id}", method = RequestMethod.GET)
    Game getGame (@PathVariable int id){
        return gameDao.getGame(id);
    }


    /**
     * Get Games By Platform ID
     * @return
     */
    @PreAuthorize("permitAll")
    @RequestMapping(path="/api/games/filter", method = RequestMethod.GET)
    public List<Game> getGamesByPlatformID(@RequestParam int platformid){
        return gameDao.getGamesByPlatform(platformid);
    }



}
