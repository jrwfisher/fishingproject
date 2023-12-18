package com.example.fishingproject.dao;

import com.example.fishingproject.model.Lure;

import java.util.List;

public interface LureDao {
    public void addLure(Lure lure);
    public void deleteLure(Lure lure);
    public List<Lure> getAllLures();

}
