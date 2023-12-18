package com.example.fishingproject.dao;

import com.example.fishingproject.model.Fish;
import com.example.fishingproject.model.FishDto;

import java.util.List;

public interface FishDao {
    public void addFish(FishDto fishDto);
    public List<Fish> getAllFish();
    public List<Fish> getFishByRegion(String region);
    public Fish addDescription(Fish fish);
}
