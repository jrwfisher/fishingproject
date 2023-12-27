package com.example.fishingproject.model;

import java.util.List;

public class Tacklebox {
    private int userId;
    private List<Lure> lures;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Lure> getLures() {
        return lures;
    }

    public void setLures(List<Lure> lures) {
        this.lures = lures;
    }
}
