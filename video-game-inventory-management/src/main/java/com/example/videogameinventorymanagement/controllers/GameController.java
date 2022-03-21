package com.example.videogameinventorymanagement.controllers;

import com.example.videogameinventorymanagement.dao.GameDao;
import com.example.videogameinventorymanagement.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GameController {

    private GameDao gameDao;

    public GameController(GameDao gameDao){this.gameDao = gameDao;}

    @RequestMapping(path="/api/game/{id}", method = RequestMethod.GET)
    Game getGame (@PathVariable int id){
        return gameDao.getGame(id);
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    String getHome (){
        return "This is the homepage";
    }

}
