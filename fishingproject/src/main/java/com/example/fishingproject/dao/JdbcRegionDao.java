package com.example.fishingproject.dao;

import com.example.fishingproject.exception.DaoException;
import com.example.fishingproject.model.Region;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcRegionDao implements RegionDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcRegionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Region> getAllRegions() {
        String sql = "SELECT region_name FROM region";
        List<Region> regions = new ArrayList<>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Region region = new Region();
                region.setName(results.getString("region_name"));
                regions.add(region);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to get all regions");
        }
        return regions;
    }
}
