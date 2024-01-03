package com.example.fishingproject.dao;

import com.example.fishingproject.model.Lure;

import java.util.List;

public interface TackleboxDao {
    public void addLure(Lure lure);
    public List<Lure> getTacklebox(int userId);

}
