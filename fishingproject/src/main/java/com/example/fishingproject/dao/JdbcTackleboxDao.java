package com.example.fishingproject.dao;

import com.example.fishingproject.model.Lure;
import org.springframework.stereotype.Component;

@Component
public class JdbcTackleboxDao implements TackleboxDao{
    @Override
    public void addLure(Lure lure) {

    }

    @Override
    public TackleboxDao getTacklebox(int userId) {
        return null;
    }
}
