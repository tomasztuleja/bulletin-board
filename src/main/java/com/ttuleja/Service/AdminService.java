package com.ttuleja.Service;

import com.ttuleja.Dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
