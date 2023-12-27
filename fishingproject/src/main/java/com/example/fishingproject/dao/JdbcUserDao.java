package com.example.fishingproject.dao;

import com.example.fishingproject.exception.DaoException;
import com.example.fishingproject.model.RegisterUserDto;
import com.example.fishingproject.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class JdbcUserDao implements UserDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT user_id, username, password_hash, role FROM app_user WHERE user_id = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
            if (rowSet.next()) {
                user = mapRowToUser(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");
        User user = null;
        String sql = "SELECT user_id, username, password_hash, role FROM app_user WHERE username = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
            if (rowSet.next()) {
                user = mapRowToUser(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return user;
    }

    @Override
    public User createUser(RegisterUserDto user) {
        return null;
    }

    //    @Override
//    public User createUser(RegisterUserDto user) {
//        User newUser = null;
//        String insertUserSql = "INSERT INTO app_user (username, password_hash, role) values (?, ?, ?) RETURNING user_id";
//        String password_hash = new BCryptPasswordEncoder().encode(user.getPassword());
//        String ssRole = user.getRole().toUpperCase().startsWith("ROLE_") ? user.getRole().toUpperCase() : "ROLE_" + user.getRole().toUpperCase();
//        try {
//            int newUserId = jdbcTemplate.queryForObject(insertUserSql, int.class, user.getUsername(), password_hash, ssRole);
//            newUser = getUserById(newUserId);
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (DataIntegrityViolationException e) {
//            throw new DaoException("Data integrity violation", e);
//        }
//        return newUser;
//    }
    public User mapRowToUser(SqlRowSet rowSet) {
        User user = new User();
        user.setId(rowSet.getInt("user_id"));
        user.setUsername(rowSet.getString("username"));
        user.setPassword(rowSet.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rowSet.getString("role")));
        user.setActivated(true);
        return user;
    }
}
