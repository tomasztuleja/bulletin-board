package com.ttuleja.Entity;

/**
 * Created by Tomal on 2017-06-16.
 */
public class Item {
    private int item_id;
    private String item_name;
    private String user_name;
    private String item_description;
    private String item_category;
    private String date;
    private int item_price;
    private String item_city;

    public Item(int item_id, String item_name, String user_name, String item_description, String item_category, String date, int item_price, String item_city) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.user_name = user_name;
        this.item_description = item_description;
        this.item_category = item_category;
        this.date = date;
        this.item_price = item_price;
        this.item_city = item_city;
    }

    public Item(){}

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public String getItem_city() {
        return item_city;
    }

    public void setItem_city(String item_city) {
        this.item_city = item_city;
    }
}
