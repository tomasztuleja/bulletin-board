package com.ttuleja.Controller;

import com.ttuleja.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Tomal on 2017-06-16.
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/delete/item", method = RequestMethod.POST)
    public String deleteItem(@RequestParam(value = "id", defaultValue = " ") String id) {

        if (!(id.equals(" "))) adminService.deleteItem(id);

        String redirectUrl = "/";
        return "redirect:" + redirectUrl;
    }


}
