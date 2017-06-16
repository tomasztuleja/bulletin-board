package com.ttuleja.Entity;

/**
 * Created by Tomal on 2017-06-14.
 */
public class User {

    private int user_id;
    private String user_name;
    private String user_password;
    private String user_role;
    private String user_city;
    private int user_status;

    public User(int user_id, String user_name, String user_password, String user_role, String user_city, int user_status) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_role = user_role;
        this.user_city = user_city;
        this.user_status = user_status;
    }

    public User() {
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }
}
