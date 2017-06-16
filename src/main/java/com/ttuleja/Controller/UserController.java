package com.ttuleja.Controller;

import com.ttuleja.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

/**
 * Created by Tomal on 2017-06-14.
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addUserPanel() {

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "username", defaultValue = " ") String username,
                          @RequestParam(value = "password", defaultValue = " ") String pass,
                          @RequestParam(value = "phone_number", defaultValue = " ") String phone_number) {

        String redirectUrlError = "/error";
        String redirectUrlSuccess = "/user/login";

        Pattern p = Pattern.compile("[a-zA-Z0-9]*");
        Pattern pphonenumber = Pattern.compile("[0-9]*");
        if (!p.matcher(username).matches()) return "redirect:" + redirectUrlError;
        if (!p.matcher(pass).matches()) return "redirect:" + redirectUrlError;
        if (!pphonenumber.matcher(phone_number).matches()) return "redirect:" + redirectUrlError;

        userService.addUser(username, pass, phone_number);
        return "redirect:" + redirectUrlSuccess;

    }

    @RequestMapping(value = {"/login"})
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/my_profile", method = RequestMethod.GET)
    public String myProfile(Model model) {

        String user_name = userService.getUserName();
        model.addAttribute("user_name", user_name);
        return "my_profile";


    }

    @RequestMapping(value = "/user_profile/{user_name}", method = RequestMethod.GET)
    public String userProfile(@PathVariable("user_name") String target_name, Model model) {

        String user_name = userService.getUserName();

        if (target_name.equals(user_name)) return "my_profile";

        else if (userService.checkIfUserExists(target_name)) {

            model.addAttribute("user_name", user_name);
            model.addAttribute("target_name", target_name);
            return "user_profile";
        } else return "error";

    }

}
