package com.example.videogameinventorymanagement.controllers;

import com.example.videogameinventorymanagement.dao.PlatformDao;
import com.example.videogameinventorymanagement.model.Game;
import com.example.videogameinventorymanagement.model.Platform;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class PlatformController {

    private PlatformDao platformDao;

    public PlatformController(PlatformDao platformDao){
        this.platformDao = platformDao;
    }


    @PreAuthorize("permitAll")
    @RequestMapping(path="/api/platforms", method = RequestMethod.GET)
    public List<Platform> getAllPlatforms(){
        return platformDao.getAllPlatforms();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path="/api/platforms/filter", method = RequestMethod.GET)
    public List<Platform> getplatformsForGame(@RequestParam int gameid){
        return platformDao.getPlatformsForGame(gameid);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path="/api/platform/{id}", method = RequestMethod.GET)
    public Platform getPlatform(@PathVariable int id) {
        return platformDao.getPlatform(id);
    }
}
