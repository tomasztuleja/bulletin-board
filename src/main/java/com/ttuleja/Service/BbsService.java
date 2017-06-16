package com.ttuleja.Service;

import com.ttuleja.Dao.BbsDao;
import com.ttuleja.Entity.Category;
import com.ttuleja.Entity.City;
import com.ttuleja.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Tomal on 2017-06-16.
 */
@Service
public class BbsService {

    @Autowired
    private BbsDao bbsDao;

    public Collection<Item> showItems(String sort_by, String category, String city) {
        return this.bbsDao.showItems(sort_by, category, city);
    }

    public Item showItemDescription(int id) {
        return this.bbsDao.showItemDescription(id);

    }

    public String getUsersPhoneNumber(int id) {
        return this.bbsDao.getUsersPhoneNumber(id);

    }

    public Collection<Category> showCategories() {
        return this.bbsDao.showCategories();
    }

    public Collection<City> showCities() {
        return this.bbsDao.showCities();
    }

    public void addItem(String item_city, String item_price, String item_category, String user_name, String item_description, String item_name) {
        this.bbsDao.addItem(item_city,item_price, item_category, user_name, item_description, item_name);
    }
}
