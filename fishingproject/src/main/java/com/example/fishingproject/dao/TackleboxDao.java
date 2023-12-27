package com.example.fishingproject.dao;

import com.example.fishingproject.model.Lure;

public interface TackleboxDao {
    public void addLure(Lure lure);
    public TackleboxDao getTacklebox(int userId);

}
