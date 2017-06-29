package com.ttuleja.Controller;

import com.ttuleja.Service.AdminService;
import com.ttuleja.Service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

/**
 * Created by Tomal on 2017-06-16.
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BbsService bbsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String deleteItem() {


        return "admin_panel";
    }

    @RequestMapping(value = "/delete/item", method = RequestMethod.POST)
    public String deleteItem(@RequestParam(value = "id", defaultValue = " ") String id) {

        if (!(id.equals(" "))) adminService.deleteItem(id);

        String redirectUrl = "/";
        return "redirect:" + redirectUrl;
    }


    @RequestMapping(value = "/list_all", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("user_list", adminService.showAllUsers());
        return "list_all";
    }

    @RequestMapping(value = "/disable_user", method = RequestMethod.POST)
    public String disableUserByName(@RequestParam(value = "user_name", defaultValue = "") String user_name) {
        if (!(user_name.equals("admin"))) adminService.disableUserByName(user_name);
        String redirectUrl = "/admin/list_all";
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/enable_user", method = RequestMethod.POST)
    public String enableUserByName(@RequestParam(value = "user_name", defaultValue = "") String user_name) {
        if (!(user_name.equals("admin"))) adminService.enableUserByName(user_name);
        String redirectUrl = "/admin/list_all/";
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/manage_categories", method = RequestMethod.GET)
    public String manageCategories(Model model) {
        model.addAttribute("categories", bbsService.showCategories());
        return "manage_categories";
    }

    @RequestMapping(value = "/manage_cities", method = RequestMethod.GET)
    public String manageCities(Model model) {
        model.addAttribute("cities", bbsService.showCities());
        return "manage_cities";
    }

    @RequestMapping(value = "/add_category", method = RequestMethod.POST)
    public String addCategory(@RequestParam(value = "category_name", defaultValue = "") String category) {

        String redirectUrlError = "/error";

        Pattern p = Pattern.compile("[a-zA-Z0-9ąćęłńóśźżĄĆĘŁŃÓŚŹŻ]*");
        if (!p.matcher(category).matches()) return "redirect:" + redirectUrlError;
        else {
            adminService.addCategory(category);
            String redirectUrl = "/admin/manage_categories";
            return "redirect:" + redirectUrl;
        }
    }

    @RequestMapping(value = "/add_city", method = RequestMethod.POST)
    public String addCity(@RequestParam(value = "city_name", defaultValue = "") String city) {

        String redirectUrlError = "/error";

        Pattern p = Pattern.compile("[a-zA-Z0-9ąćęłńóśźżĄĆĘŁŃÓŚŹŻ]*");
        if (!p.matcher(city).matches()) return "redirect:" + redirectUrlError;
        else {
            adminService.addCity(city);
            String redirectUrl = "/admin/manage_cities";
            return "redirect:" + redirectUrl;
        }
    }

    @RequestMapping(value = "/delete_category", method = RequestMethod.POST)
    public String deleteCategory(@RequestParam(value = "category_name", defaultValue = "") String category) {

        adminService.deleteCategory(category);
        String redirectUrl = "/admin/manage_categories";
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/delete_city", method = RequestMethod.POST)
    public String deleteCity(@RequestParam(value = "city_name", defaultValue = "") String city) {

        adminService.deleteCity(city);
        String redirectUrl = "/admin/manage_cities";
        return "redirect:" + redirectUrl;
    }


}
