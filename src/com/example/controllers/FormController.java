package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tomek on 25.03.2017.
 */

@Controller
@RequestMapping("/minor")
public class FormController {

    @RequestMapping("/")
    public String func() {
        return "site";
    }

    @RequestMapping("/processForm")
    public String obsluzFormularz() {
        System.out.println("kukulele");
        return "index";
    }
}
