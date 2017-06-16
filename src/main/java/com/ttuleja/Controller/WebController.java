package com.ttuleja.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tomal on 2017-06-14.
 */

@Controller
public class WebController {

    @RequestMapping(value = "/")
    public String index() {

        return "index";
    }


}
