package com.example.fishingproject.dao;

import com.example.fishingproject.model.Lure;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcTackleboxDao implements TackleboxDao{
    //Adding lures to user's tacklebox
    @Override
    public void addLure(Lure lure) {
        String sql = "INSERT INTO tacklebox (lure_name) VALUES (?)";
    }

    //Getting all lures from user's tacklebox
    @Override
    public List<Lure> getTacklebox(int userId) {
        return null;
    }
}
