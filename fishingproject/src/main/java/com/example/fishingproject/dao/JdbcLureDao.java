package com.example.fishingproject.dao;

import com.example.fishingproject.model.Lure;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLureDao implements LureDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcLureDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void addLure(Lure lure) {
        String sql = "INSERT INTO tacklebox (lure_name, lure_type) VALUES (?, ?)";
        String lureName = lure.getLureName();
        String lureType = lure.getLureType();
        jdbcTemplate.update(sql, lureName, lureType);
    }
    @Override
    public void deleteLure(Lure lure) {
        String sql = "DELETE FROM tacklebox WHERE lure_name = ?";
        String lureName = lure.getLureName();
        jdbcTemplate.update(sql, lureName);
    }

    @Override
    public List<Lure> getAllLures() {
        String sql = "SELECT lure_name, lure_type, lure_id FROM tacklebox;";
        List<Lure> lureList = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Lure lure = new Lure();
            lure.setLureName(results.getString("lure_name"));
            lure.setLureType(results.getString("lure_type"));
            lure.setLureId(results.getInt("lure_id"));
            lureList.add(lure);
        }
        return lureList;
    }


}
