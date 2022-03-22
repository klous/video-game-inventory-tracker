package com.example.videogameinventorymanagement.controllers;

import com.example.videogameinventorymanagement.dao.PlatformDao;
import com.example.videogameinventorymanagement.model.Game;
import com.example.videogameinventorymanagement.model.Platform;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

//    @PreAuthorize("permitAll")
//    @RequestMapping(path="/api/platforms/filter", method = RequestMethod.GET)
//    public List<Platform> getplatforms(@RequestParam int id){
//        return platformDao.getPlatforms();
//    }

}
