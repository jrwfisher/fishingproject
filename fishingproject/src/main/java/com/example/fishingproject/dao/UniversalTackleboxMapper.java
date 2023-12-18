package com.example.fishingproject.dao;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UniversalTackleboxMapper implements RowCallbackHandler {
    @Override
    public void processRow(ResultSet rs) throws SQLException {
        String lureName = rs.getString("lure_name");
        String lureType = rs.getString("lure_type");
        System.out.println(lureName + " " + lureType);
    }
}
