package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tomek on 25.03.2017.
 */

@Controller
public class BigController {

    @RequestMapping("/home")
    public String func() {
        System.out.println("kukulele");
        return "index";
    }
}
