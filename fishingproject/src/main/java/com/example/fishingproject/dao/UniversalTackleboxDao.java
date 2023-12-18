package com.example.fishingproject.dao;

public interface UniversalTackleboxDao {
    public void addLure(String lureName, String lureType);
    public void deleteLure(String lureName);
    public void getAllLures();
    public void getLureByName(String lureName);
    public void getLureByType(String lureType);
}
