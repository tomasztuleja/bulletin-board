package com.ttuleja.Service;

import com.ttuleja.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Tomal on 2017-06-14.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(String username, String pass, String phone_number) {

        userDao.addUser(username, generate(pass), phone_number);
    }

    public static String generate(String pass) {
        int i = 0;
        String hashedPassword = "";
        while (i < 10) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            hashedPassword = passwordEncoder.encode(pass);
            i++;
        }
        return hashedPassword;
    }

    public String getUserName() {

        return this.userDao.getUserName();
    }


    public boolean checkIfUserExists(String target_name) {
        return this.userDao.checkIfUserExists(target_name);
    }
}
