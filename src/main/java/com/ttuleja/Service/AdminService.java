package com.ttuleja.Service;

import com.ttuleja.Dao.AdminDao;
import com.ttuleja.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Tomal on 2017-06-16.
 */
@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public void deleteItem(String id) {
        this.adminDao.deleteItem(id);
    }

    public Collection<User> showAllUsers() {
        return this.adminDao.showAllUsers();
    }

    public void disableUserByName(String user_name) {
        this.adminDao.disableUserByName(user_name);
    }

    public void enableUserByName(String user_name) {
        this.adminDao.enableUserByName(user_name);
    }

    public void deleteCategory(String category) {
        this.adminDao.deleteCategory(category);
    }

    public void deleteCity(String city) {
        this.adminDao.deleteCity(city);
    }

    public void addCategory(String category) {
        this.adminDao.addCategory(category);
    }

    public void addCity(String city) {
        this.adminDao.addCity(city);
    }
}
