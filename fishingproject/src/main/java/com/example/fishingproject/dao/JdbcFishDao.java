package com.example.fishingproject.dao;


import com.example.fishingproject.exception.DaoException;
import com.example.fishingproject.model.Fish;
import com.example.fishingproject.model.FishDto;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcFishDao implements FishDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcFishDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addFish(FishDto fishDto) {
        String fishSql = "INSERT INTO species (fish_name, description) VALUES (?, ?) RETURNING fish_id;";
        String regionSql = "SELECT region_id FROM region WHERE region_name = ?;";
        String regionFishSql = "INSERT INTO region_species (region_id, fish_id) VALUES (?, ?);";
        String name = fishDto.getName();
        String description = fishDto.getDescription();
        String region = fishDto.getRegion();
        try {
            int fishId = jdbcTemplate.queryForObject(fishSql, Integer.class, name, description);
            int regionId = jdbcTemplate.queryForObject(regionSql, Integer.class, region);
            jdbcTemplate.update(regionFishSql, regionId, fishId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to add fish");
        }
    }

    public List<Fish> getAllFish() {
        String sql = "SELECT fish_name, description FROM species;";
        List<Fish> fishList = new ArrayList<>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Fish fish = new Fish();
                fish.setName(results.getString("fish_name"));
                if(results.getString("description") != null && !results.getString("description").isEmpty()) {
                    fish.setDescription(results.getString("description"));
                }
                fishList.add(fish);
            }
            return fishList;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to get all fish");
        }
    }

    @Override
    public List<Fish> getFishByRegion(String region) {
        String sql = "SELECT fish_name, description FROM species JOIN region_species USING (fish_id) JOIN region USING (region_id) WHERE region_name = ?;";
        List<Fish> fishList = new ArrayList<>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, region);
            while (results.next()) {
                Fish fish = new Fish();
                fish.setName(results.getString("fish_name"));
                if(results.getString("description") != null && !results.getString("description").isEmpty()) {
                    fish.setDescription(results.getString("description"));
                }
                fishList.add(fish);
            }
            return fishList;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to get fish by region");
        }
    }

    @Override
    public Fish addDescription(Fish fish) {
        String sql = "UPDATE species SET description = ? WHERE fish_name = ?;";
        String name = fish.getName();
        String description = fish.getDescription();
        try {
            jdbcTemplate.update(sql, description, name);
            return fish;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to add description");
        }
    }
}
