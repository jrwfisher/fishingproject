package com.example.fishingproject.controller;

import com.example.fishingproject.dao.RegionDao;
import com.example.fishingproject.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RegionController {
    @Autowired
    private RegionDao regionDao;

    @RequestMapping(path = "/regions", method = RequestMethod.GET)
    public List<Region> getAllRegions() {
        return regionDao.getAllRegions();
    }

}
