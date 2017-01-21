package com.prits.importexportapi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 3ppat on 1/21/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String home(){
        return "index";
    }
}
