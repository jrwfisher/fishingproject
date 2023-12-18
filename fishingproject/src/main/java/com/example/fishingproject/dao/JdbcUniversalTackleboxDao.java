package com.example.fishingproject.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcUniversalTackleboxDao implements UniversalTackleboxDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcUniversalTackleboxDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void addLure(String lureName, String lureType) {
        String sql = "INSERT INTO tacklebox (lure_name, lure_type) VALUES (?, ?)";
        jdbcTemplate.update(sql, lureName, lureType);
    }
    @Override
    public void deleteLure(String lureName) {
        String sql = "DELETE FROM tacklebox WHERE lure_name = ?";
        jdbcTemplate.update(sql, lureName);
    }

    @Override
    public void getAllLures() {
        String sql = "SELECT * FROM tacklebox";
        jdbcTemplate.query(sql, new UniversalTackleboxMapper());
    }
    @Override
    public void getLureByName(String lureName) {
        String sql = "SELECT * FROM tacklebox WHERE lure_name = ?";
        jdbcTemplate.query(sql, new UniversalTackleboxMapper(), lureName);
    }
    @Override
    public void getLureByType(String lureType) {
        String sql = "SELECT * FROM tacklebox WHERE lure_type = ?";
        jdbcTemplate.query(sql, new UniversalTackleboxMapper(), lureType);
    }



}
