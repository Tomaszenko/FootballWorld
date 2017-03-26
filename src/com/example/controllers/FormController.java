package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/goodProcessor")
    public String goodProcessor(HttpServletRequest request, Model model) {

        String name=request.getParameter("footballer");

        String message=name+", najlepszy napastnik Polski!";

        model.addAttribute("message",message);

        return "index";
    }
}
