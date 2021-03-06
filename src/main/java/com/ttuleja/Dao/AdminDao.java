package com.ttuleja.Dao;

import com.ttuleja.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Tomal on 2017-06-16.
 */

@Repository
public class AdminDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void deleteItem(String id) {
        String sql = "DELETE FROM item WHERE item_id=?";
        jdbcTemplate.update(sql, id);

    }

    public Collection<User> showAllUsers() {
        String sql = "SELECT * FROM user WHERE user_id<>1";

        Collection<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));

        return users;
    }

    public void disableUserByName(String user_name) {
        String sql = "UPDATE user SET user_status=0 WHERE user_name = ?";
        jdbcTemplate.update(sql, user_name);
    }

    public void enableUserByName(String user_name) {
        String sql = "UPDATE user SET user_status=1 WHERE user_name = ?";
        jdbcTemplate.update(sql, user_name);
    }

    public void deleteCategory(String category) {
        String sql1 = "DELETE FROM item WHERE item_category=?";
        jdbcTemplate.update(sql1, category);

        String sql = "DELETE FROM category WHERE category_name=?";
        jdbcTemplate.update(sql, category);

    }

    public void deleteCity(String city) {
        String sql1 = "DELETE FROM item WHERE item_city=?";
        jdbcTemplate.update(sql1, city);

        String sql = "DELETE FROM city WHERE city_name=?";
        jdbcTemplate.update(sql, city);

    }

    public void addCategory(String category) {
        String sql = "INSERT INTO category (category_name) VALUES (?)";
        jdbcTemplate.update(sql, new Object[]{category});

    }

    public void addCity(String city) {
        String sql = "INSERT INTO city (city_name) VALUES (?)";
        jdbcTemplate.update(sql, new Object[]{city});

    }
}
