package com.example.fishingproject.controller;

import com.example.fishingproject.dao.FishDao;
import com.example.fishingproject.model.Fish;
import com.example.fishingproject.model.FishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class FishController {
    @Autowired
    private FishDao fishDao;
    @RequestMapping(path = "/fish", method = RequestMethod.POST)
    public void addFish(@RequestBody FishDto fishDto) {
        fishDao.addFish(fishDto);
    }
    @RequestMapping(path = "/fish", method = RequestMethod.GET)
    public List<Fish> getAllFish() {
        return fishDao.getAllFish();
    }
    @RequestMapping(path = "/fish", method = RequestMethod.PUT)
    public Fish addDescription(@RequestBody Fish fish) {
        return fishDao.addDescription(fish);
    }

    @RequestMapping(path = "/fish/{region}", method = RequestMethod.GET)
    public List<Fish> getFishByRegion(@PathVariable String region) {
        return fishDao.getFishByRegion(region);
    }


}
